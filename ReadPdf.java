/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.groupassignment;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import java.io.File;
import java.io.IOException;

public class ReadPdf {
    
     public static int charCount = 0;
    public static int wordCount = 0;
    public static int lineCount = 0;
    static int u=0;

    public static void main(String[] args) throws IOException {

        try (PDDocument document = PDDocument.load(new File("C:\\Users\\User\\Desktop\\Zhamri_UCP-CkMetrics - Copy.pdf"))) {

            document.getClass();

            if (!document.isEncrypted()) {

                PDFTextStripperByArea stripper = new PDFTextStripperByArea();
                stripper.setSortByPosition(true);

                PDFTextStripper tStripper = new PDFTextStripper();

                String pdfFileInText = tStripper.getText(document);
                //System.out.println("Text:" + st);

                // split by whitespace
                String lines[] = pdfFileInText.split("\\r\n");
                for (String line : lines) {
                    System.out.println(line);
                    
                    //start
                    String[] words = line.split(" ");
                    //Updating the wordCount
                   
                    wordCount = wordCount + words.length;
                    //Iterating each word
                    for (String word : words) {
                        //Updating the charCount
                        charCount += word.length();
                        for (int i = 0; i < word.length(); i++) {
                            if (word.charAt(i) == 'u' || word.charAt(i) == 'U') {
                                u++;
                            }
                        }
                    }//end
                    
                }
                System.out.println("Number Of Chars In A File : " + charCount);

            System.out.println("Number Of Words In A File : " + wordCount);

            System.out.println("Number Of Lines In A File : " + lineCount);
            
            System.out.println("Number of u in a File : "+ u);

            }

        }

    }
}
