package com.oncheck.tipSystem;


import org.springframework.core.io.FileSystemResource;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

class TipsManager {

    private TipFactory tipFactory = new TipFactory();
    private String myUrl = "localhost/tips";

    /**
     * SENDING TIP TO OFFICIAL PARTY
     */
    private void submitTip(Tip tip) {

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
//        sender.send(message);

    }

    /**
     * ADDING NEW TIP TO THE DATABASE
     */
    void addTip(String message, String evidence) {
        try {

            Connection dbConnection = DriverManager.getConnection(myUrl, "root", "");

            Tip tip = tipFactory.createTip(message, evidence);

            String sqlCommandFrame = " insert into tips (message, evidence)"
                    + " values (?, ?)";

            PreparedStatement actualSqlCommand = dbConnection.prepareStatement(sqlCommandFrame);

            actualSqlCommand.setString(1, tip.getMessage());
            actualSqlCommand.setString(2, tip.getEvidence());

            actualSqlCommand.execute();

            dbConnection.close();

            //submitTip(tip);

        }
        catch (Exception e) {

            System.err.println("Encountered an exception");
            e.printStackTrace();

        }
    }

    /**
     * RETRIEVE TIPS FROM THE DATABASE
     */
    public Tip[] getTip() {
        return null;
    }
}
