package com.rn.code.service;

import org.apache.log4j.Logger;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

/**
 * Created by rneup on 11/10/2017.
 */
public class RequestService {
    private final static Logger logger = Logger.getLogger(RestService.class);

    /*
        * @body = send either as string or json object.
        * */
    Object sendPost(String url, Map<String,String> headerParameters, Object body) throws Exception {
        URL obj = new URL(url);
        HttpsURLConnection con = (HttpsURLConnection) obj.openConnection();
        con.setRequestMethod("POST");
        if(headerParameters != null){
            for (Map.Entry<String, String> entry : headerParameters.entrySet()) {
                con.setRequestProperty(entry.getKey(),entry.getValue());
            }
        }
        con.setDoOutput(true);
        DataOutputStream wr = new DataOutputStream(con.getOutputStream());
        wr.writeBytes(body.toString());
        wr.flush();
        wr.close();

        logger.info("\nSending 'POST' request to URL : " + url);
        logger.info("Response Code : " + con.getResponseCode());

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.length() > 0 ? response : null;
    }

    Object sendGet(String url, Map<String,String> headerParameters) throws Exception {
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        con.setRequestMethod("GET");
        if(headerParameters != null){
            for (Map.Entry<String, String> entry : headerParameters.entrySet()) {
                con.setRequestProperty(entry.getKey(),entry.getValue());
            }
        }
        logger.info("\nSending 'GET' request to URL : " + url);
        logger.info("Response Code : " + con.getResponseCode());

        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();
        return response.length() > 0 ? response : null;

    }
}
