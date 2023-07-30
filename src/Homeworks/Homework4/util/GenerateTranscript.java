package Homeworks.Homework4.util;

import java.util.Scanner;
import java.io.*;

public class GenerateTranscript {

    /*
    1. Kullanıcıdan bilgi alıp transcript oluşturmak için "takeInputFromUser" methodu oluşturuldu.
    2. Text dosyasından bilgi alıp transcript oluşturmak için "takeInputFromFile" methodu oluşturuldu.
     */


    public void takeInputFromUser(){

        Scanner input = new Scanner(System.in);

        System.out.println("Enter Student ID: ");
        int id = input.nextInt();
        boolean flag = true;
        Transcript stuTranscript = new Transcript(id);
        while (flag){

            System.out.println("Enter Department: ");
            String department = input.nextLine();
            input.nextLine();
            System.out.println("Enter Course Code: ");
            int courseCode = input.nextInt();
            System.out.println("Enter Credit: ");
            int credit = input.nextInt();
            System.out.println("Enter Grade: ");
            double grade = input.nextInt();
            stuTranscript.addCourseTaken(new CourseGrade(department,courseCode,credit,grade));
            System.out.println("Do you want to add new course to transcript ?\n1-Yes\n2-No");
            int choice = input.nextInt();
            if (choice == 2){
                flag = false;
            }

        }
        input.close();
        System.out.println(stuTranscript);
    }

        public void takeInputFromFile() {

            int studentId = 0;
            Transcript transcript = new Transcript(studentId);
            Scanner scanner = new Scanner(System.in);

            System.out.println("Enter filename:");
            String fileName = scanner.nextLine();


            File file = new File(fileName);
            try {
                scanner = new Scanner(file);

                if (scanner.hasNextLine()) {
                    studentId = scanner.nextInt();
                    transcript.setStudentID(studentId);
                }

                while (scanner.hasNextLine()) {
                    String line = scanner.nextLine().trim();
                    String[] parts = line.split("\\s+");

                    if (parts.length == 4) {
                        String department = parts[0];
                        int code = Integer.parseInt(parts[1]);
                        int credit = Integer.parseInt(parts[2]);
                        double grade = Double.parseDouble(parts[3]);

                        transcript.addCourseTaken(new CourseGrade(department,code,credit,grade));
                    }
                }

                scanner.close();
                System.out.println(transcript);
            } catch (FileNotFoundException e) {
                System.out.println("Error: File not found!");
                e.printStackTrace();
            }
        }



    }

