package org.example;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpImageStatusCli {
    public static void askStatus(){
        boolean isValid = false;
        boolean imageDownloaded = false;
        do {
            //asking user for an input
            System.out.println("Enter HTTP status code: ");
            Scanner scanner = new Scanner(System.in);
            String userInput = scanner.nextLine();
            scanner.close();
            //validating users' input
            Pattern pattern = Pattern.compile("^\\d+$");
            Matcher matcher = pattern.matcher(userInput);
            isValid = matcher.find();
            if(!isValid) {
                System.out.println("Please enter valid number");
                continue;
            }
            //sending http request to find the image
            try {
                HttpStatusImageDownloader.downloadStatusImage(Integer.parseInt(userInput));
                imageDownloaded = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println("Image has been successfully downloaded!");
        }while(!isValid || !imageDownloaded);


    }

}
