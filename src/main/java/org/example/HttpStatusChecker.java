package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpStatusChecker {
    public static String getStatusImage(int code) {
        //setting url
        URL catUrl = null;
        try {
            catUrl = new URL("https", "http.cat", "/"+String.valueOf(code)+".jpg");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
        //getting connection to
        Connection.Response response= null;
        try{
            Jsoup.connect(String.valueOf(catUrl))
                    .ignoreContentType(true)
                    .execute();
        }catch (IOException e){
            e.printStackTrace();
        }
        return String.valueOf(catUrl);
    }
}
