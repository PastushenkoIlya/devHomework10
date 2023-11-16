package org.example;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpStatusImageDownloader {
    //implicit constructor of the utility class
    private HttpStatusImageDownloader(){}
    public static void downloadStatusImage(int code) throws IOException {
        //setting url
        URL catUrl = null;
        try {
            catUrl = new URL("https", "http.cat", "/"+code+".jpg");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        //getting connection
        Connection.Response response = Jsoup.connect(catUrl.toString()).ignoreContentType(true).execute();
        if(response.statusCode() == 200) {
            //saving it to file in `images` directory
            BufferedImage bufferedImage = ImageIO.read(catUrl);
            ImageIO.write(bufferedImage, "jpg",
                    new File("src/main/java/org/example/images/" + code + ".jpg"));
        }
        else throw new IOException("url doesn't exists");
    }
}
