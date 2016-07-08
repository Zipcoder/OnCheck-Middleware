package com.oncheck.Scraper;

import com.oncheck.Domain.*;
import com.oncheck.Repository.RestaurantRepository;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


import java.io.*;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * Created by stevejaminson on 6/14/16.
 */
@Component
public class Scraper {

    @Autowired
    RestaurantRepository restaurantRepository;

    private URL url;
    private InputStream is = null;
    private File file = new File("/Users/brianabbott/Dev/Labs/InspectionWebScraper/Test.html"); //This is a local file
    private Elements rows;

    /**
     * This method retrieves the html file from the DHSS Food Establishment Inspection Reports webpage.
     * This method, due to the Thread.sleep functionality and due to the size of the html file, takes
     * roughly 4 minutes and 40 seconds. The Thread.sleep is 3 minutes to give the webpage time to load.
     * @throws IOException
     */
    public File getDocument() throws IOException {
        String inspection = "http://dhss.delaware.gov/dhss/dph/hsp/Default.aspx?listAll=1&sort=Establishment";
        File stateData = new File("/Users/brianabbott/Dev/Labs/InspectionWebScraper/Test.html");
        URL url = new URL(inspection);
        try {
            is = url.openStream();
            try {
                Thread.sleep(210*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            downloadFileFromSite(inspection, stateData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stateData;
    }
    /**
     * This will connect to the @param dataSite and download the html file to the @param destination.
     */
    public void downloadFileFromSite(String dataSite, File destination) {
        try {
            URL website = new URL(dataSite);
            ReadableByteChannel readable;
            readable = Channels.newChannel(website.openStream());
            FileOutputStream fileOutput = new FileOutputStream(destination);
            fileOutput.getChannel().transferFrom(readable, 0, Long.MAX_VALUE);
            fileOutput.close();
            readable.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Converts local html file to Jsoup Document
     * @param file
     * @return
     */
    public Document fileToDocument(File file){
        Document doc = null;
        try {
            doc = Jsoup.parse(file,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;
    }

    /**
     * Gets the table of health inspection info
     * @param doc
     * @return
     */
    public Element getTableElement(Document doc){
        Element table = doc.select("table.datagrid").first();
        return table;
    }

    /**
     * Gets every row of data in the table
     * @param table
     */
    public Elements getRows(Element table){
        rows = table.select("tr.datagridItem, tr.datagridAlternatingItem");
        return rows;
    }

    /**
     * Removes HTML and populates ArrayList of inspection objects
     * @param rows
     */
    public void parseAndPopulate(Elements rows){
        for(Element row : rows){
            String[] line = row.toString().split("<td(.*?)>");
            for(int i = 0; i < line.length; i++){
                line[i] = line[i].replaceAll("<a(.*?)?>|<tr(.*?)?>|<td(.*?)?>|<span(.*?)?>|<br>|</span>|</td>|</a>|</tr>|\\n","");
                line[i] = line[i].trim();
            }
            restaurantRepository.save(new Restaurant(line[1], line[2], line[3], line[4], line[5], line[6], line[7], line[8]));
        }
    }
    @Scheduled(fixedRate = 604800000)
    public void runScraper(){
//        try {
        parseAndPopulate(getRows(getTableElement(fileToDocument(file))));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

}