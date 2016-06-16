package com.oncheck.tipSystem;

import java.sql.*;

public class TipsManager {

    TipFactory tipFactory = new TipFactory();
    String myUrl = "localhost/tips";

    /**
     * SENDING TIP TO OFFICIAL PARTY
     */
    public void submitTip() {

    }

    /**
     * ADDING NEW TIP TO THE DATABASE
     */
    public void addTip(String message, String evidence) {
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

        }
        catch (Exception e) {



        }
    }

    /**
     * RETRIEVE TIPS FROM THE DATABASE
     */
    public Tip[] getTip() {
        return null;
    }
}
