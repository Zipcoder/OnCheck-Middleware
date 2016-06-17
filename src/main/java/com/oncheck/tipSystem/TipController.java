package com.oncheck.tipSystem;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TipController {

    private TipsManager tipsManager = new TipsManager();

    @RequestMapping(value ="/addtip", params= {"message", "evidence"})
    @ResponseBody
    public String storeTip(@RequestParam("message") String message, @RequestParam("evidence") String evidence){
        tipsManager.addTip(message, evidence);
        return "Tip submitted with message " + message + " and evidence path of " + evidence;
    }

}
