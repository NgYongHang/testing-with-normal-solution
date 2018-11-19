/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.groupassignment;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author User
 */
public class Method2 {

    public static int charCount = 0;
    public static int wordCount = 0;
    public static int lineCount = 0;


    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        BufferedReader reader = null;

        //Initializing charCount, wordCount and lineCount to 0
        int u =0, g=0,y=0,h=0;
        
       

        try {
            //Creating BufferedReader object
            reader = new BufferedReader(new FileReader("C:\\Users\\User\\Desktop\\test.pdf"));
            //Reading the first line into currentLine
            String currentLine = reader.readLine();
            while (currentLine != null) {
                //Updating the lineCount
                lineCount++;
                //Getting number of words in currentLine
                String[] words = currentLine.split(" ");
                //Updating the wordCount
                wordCount = wordCount + words.length;
                //Iterating each word
                for (String word : words) {
                    //Updating the charCount
                    charCount+= word.length();
                    for(int i=0; i<word.length(); i++){
                        if(word.charAt(i) == 'u' || word.charAt(i) == 'U')
                            u++;
                    }
                }

                //Reading next line into currentLine
                currentLine = reader.readLine();
            }

            //Printing charCount, wordCount and lineCount
            System.out.println("Number Of Chars In A File : " + charCount);

            System.out.println("Number Of Words In A File : " + wordCount);

            System.out.println("Number Of Lines In A File : " + lineCount);
            
            System.out.println("Number of u in a File : "+ u);
            
            
            reader.close();           //Closing the reader
            
        
        } catch (IOException e) {
        } 
    }
}
