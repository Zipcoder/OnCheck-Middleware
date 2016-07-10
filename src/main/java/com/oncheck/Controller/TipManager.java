package com.oncheck.Controller;

import com.oncheck.Domain.Tip;
import com.oncheck.Repository.TipRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;


@RestController
public class TipManager {

    @Autowired
    TipRepository tipRepository;

    @RequestMapping(value ="/tips", method= RequestMethod.POST)
    public ResponseEntity<?> createTip(@ModelAttribute Tip tip) {
        tipRepository.save(tip);
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newPollUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(tip.getId())
                .toUri();
        responseHeaders.setLocation(newPollUri);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }

    @CrossOrigin
    @RequestMapping(value ="/tips", method= RequestMethod.GET)
    public Iterable<Tip> getTips(HttpServletResponse response) {

        return tipRepository.findAll();
    }

    @CrossOrigin
    @RequestMapping(value ="/tips/{userId}", method= RequestMethod.GET)
    public Iterable<Tip> getUserTips(@PathVariable Long userId) {
        return tipRepository.findTipByUser(userId);
    }

//    private void submitTip(Tip tip) {
//
//        JavaMailSenderImpl sender = new JavaMailSenderImpl();
//        sender.setHost("mail.foodoncheck.io");
//
//        MimeMessage message = sender.createMimeMessage();
//
//        MimeMessageHelper helper = new MimeMessageHelper(message, true);
//        helper.setTo("someofficialperson@dhss.gov");
//
//        helper.setText(tip.getMessage());
//
//        FileSystemResource file = new FileSystemResource(new File(tip.getEvidence()));
//        helper.addAttachment("Evidence.jpg", file);
//
//    }

}
