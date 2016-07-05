package com.oncheck.tipSystem;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
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

    @RequestMapping(value ="/tips", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Tip>> getTips() {
        Iterable<Tip> allTips = tipRepository.findAll();

        return new ResponseEntity<>(tipRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value ="/tips/{userId}", method= RequestMethod.GET)
    public ResponseEntity<Iterable<Tip>> getUserTips(@PathVariable Long userId) {
        Iterable<Tip> userTips = tipRepository.findTipByUser(userId);

        return new ResponseEntity<>(tipRepository.findTipByUser(userId), HttpStatus.OK);
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
