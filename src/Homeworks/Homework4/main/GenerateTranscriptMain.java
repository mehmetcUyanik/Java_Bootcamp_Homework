package Homeworks.Homework4.main;

import Homeworks.Homework4.util.GenerateTranscript;

public class GenerateTranscriptMain {
    public static void main(String[] args) {


        GenerateTranscript generateTranscript = new GenerateTranscript();

        generateTranscript.takeInputFromUser();


        // transcript bilgileri test.txt dosyasının içerisinde

        generateTranscript.takeInputFromFile();

    }

}
