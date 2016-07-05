package com.oncheck.Scraper;


import com.oncheck.Domain.*;
import com.oncheck.Repository.CodeRepository;
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
import java.util.ArrayList;

/**
 * Created by stevejaminson on 7/1/16.
 */
@Component
public class CodeScraper {

    @Autowired
    CodeRepository codeRepository;

    public URL url;
    private InputStream is = null;
    private File file = new File("/Users/stevejaminson/Dev/Labs/InspectionWebScraper/CodeTest.html"); //This is a local file
    private Elements rows;

    public File getDocument() throws IOException {
        String inspection = "http://www.dhss.delaware.gov/dhss/dph/hsp/fic.html";
        File stateData = new File("/Users/stevejaminson/Dev/Labs/InspectionWebScraper/CodeTest.html");
        URL url = new URL(inspection);
        try {
            is = url.openStream();
            try {
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            downloadFileFromSite(inspection, stateData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stateData;
    }

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
        Element table = doc.select("table.center").first();
        return table;
    }

    /**
     * Gets every row of data in the table
     * @param table
     */
    public Elements getRows(Element table){
        rows = table.select("td.left");
        return rows;
    }

    /**
     * Removes HTML and populates ArrayList of inspection objects
     * @param rows
     */
    public void parseAndPopulate(Elements rows){
        ArrayList<String> lines = new ArrayList<>();
        int count = 1;
        for(Element row : rows){
            String[] line = row.toString().split("<td(.*?)>");
            for (int i = 1; i < line.length; i++) {
                line[i] = line[i].replaceAll("<a(.*?)?>|<tr(.*?)?>|<td(.*?)?>|<span(.*?)?>|<br>|</span>|</td>|</a>|</tr>|\\n", "");
//                line[i] = line[i].replaceAll("\\.", "_");
                line[i] = line[i].trim();
            }
            lines.add(line[1]);
            if(count % 4 == 0){
                codeRepository.save(new Code(lines.get(0), lines.get(1), lines.get(2), lines.get(3)));
                lines.clear();
            }
            count++;
        }
    }

    @Scheduled(fixedRate = 604800000)
    public void runCodeScraper(){
        parseAndPopulate(getRows(getTableElement(fileToDocument(file))));
    }
}
