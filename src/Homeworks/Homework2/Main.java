package Homeworks.Homework2;

import Homeworks.Homework2.model.Category;
import Homeworks.Homework2.model.Film;
import Homeworks.Homework2.model.Platform;

import java.util.*;

public class Main{
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        boolean flag = true;

        int control;
        int controlAdmin;

        List <Film> FilmList = new ArrayList<>();

        ArrayList<String> platformList = new ArrayList<>();
        platformList.add("Netflix");
        platformList.add("Amazon Prime");
        platformList.add("BluTV");
        platformList.add("Disney");
        platformList.add("IPTV");

        ArrayList<String> categoryList = new ArrayList<>();
        categoryList.add("Korku");
        categoryList.add("Komedi");
        categoryList.add("Bilim Kurgu");
        categoryList.add("Romantik");
        categoryList.add("Aksiyon");
        categoryList.add("Macera");
        categoryList.add("Dram");
        categoryList.add("Çocuk");



        do {

            System.out.println("1-Admin Girişi\n2-Kullanıcı Girişi\n0-Çıkış Yap");
            control= input.nextInt();

            switch (control){
                case 1:
                    System.out.println("Admin Paneline Hoşgeldiniz...");
                    System.out.println("Lütfen Yapmak İstediğiniz İşlemi Seçiniz :");
                    System.out.println("1-Kategori Ekle\n2-Platform Ekle\n3-Film Ekle\n0-Çıkış Yap");
                    controlAdmin=input.nextInt();

                    switch (controlAdmin){

                        case 1:
                            input.nextLine();
                            System.out.println("Eklenecek Kategorinin Adını Giriniz: ");
                           String newCatName = input.nextLine();
                           categoryList.add(newCatName);


                            break;

                        case 2:
                            input.nextLine();
                            System.out.println("Eklenecek Platformun Adını Giriniz: ");
                            String newPlatName = input.nextLine();
                            platformList.add(newPlatName);


                            break;

                        case 3:
                            System.out.println("Filmin kategorisini seçin :");
                            for (int i=0;i<categoryList.size();i++){
                                System.out.println((i+1)+"-"+categoryList.get(i));
                            }
                            int catNum = input.nextInt();
                            System.out.println("Filmin Platformunu seçin :");
                            for (int i=0;i<platformList.size();i++){
                                System.out.println((i+1)+"-"+platformList.get(i));
                            }
                            int platNum = input.nextInt();
                            input.nextLine();
                            System.out.println("Filmin adını giriniz :");
                            String nameInp = input.nextLine();
                            System.out.println("Filmin yapım tarihini giriniz :");
                            int yearInp = input.nextInt();
                            input.nextLine();
                            System.out.println("Filmin yönetmenini giriniz :");
                            String directorInp = input.nextLine();
                            System.out.println("Filmin imdb puanını giriniz :");
                            double imdbInp = input.nextDouble();
                            input.nextLine();
                            System.out.println("Filmin süresini giriniz :");
                            String runtimeInp = input.nextLine();
                            Film newFilm = new Film(nameInp,yearInp,directorInp,imdbInp,runtimeInp);

                            Category tempCat = new Category();
                            tempCat.setCategoryName(categoryList.get(catNum-1));
                            ArrayList <Category> tempCatList = new ArrayList<>();
                            tempCatList.add(tempCat);
                            newFilm.setCatArrayList(tempCatList);

                            Platform tempPlat = new Platform();
                            tempPlat.setPlatformName(platformList.get(platNum-1));
                            ArrayList <Platform> tempPlatList = new ArrayList<>();
                            tempPlatList.add(tempPlat);
                            newFilm.setPlayArrayList(tempPlatList);

                            FilmList.add(newFilm);



                            System.out.println("Film başarıyla oluşturuldu...");


                            break;


                    }
                    break;

                    case 2:
                        System.out.println("Filmleri Görmek İçin Kategori Seçiniz.");
                        for (int i=0;i<categoryList.size();i++){
                            System.out.println((i+1)+"-"+categoryList.get(i));
                        }
                        int userChoice = input.nextInt();
                        System.out.println(categoryList.get(userChoice-1)+" kategorisindeki filmler :");


                        int count = 0;

                        for (Film fd : FilmList){
                            for (Category c : fd.getCatArrayList()){
                                if (c.getCategoryName().equals(categoryList.get(userChoice-1))){
                                    System.out.println(fd);
                                    count++;
                                }
                            }
                        }

                        System.out.println(categoryList.get(userChoice-1)+" kategorisinde "+count+" tane film vardır...");




                        break;


                case 0:
                    System.out.println("Çıkış Yapıyorsunuz...");
                    flag = false;
                    input.close();
            }

        }while (flag);
    }
}
