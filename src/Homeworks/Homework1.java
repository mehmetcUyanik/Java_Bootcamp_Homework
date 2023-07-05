package Homeworks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Homework1 {


    public static void main(String[] args) {


        ArrayList<String> Class1 = new ArrayList<>();

        Class1.add("Ahmet Bulut");
        Class1.add("Furkan Kara");
        Class1.add("Mehmet Koca");
        Class1.add("Görkem Yılmaz");
        Class1.add("Halil Nedim Ceylan");
        Class1.add("Mustafa Gökhan Yıldırım");
        Class1.add("Vural Aysal");
        Class1.add("Gökçe Nadir");
        Class1.add("Burhan Büyük");

        ArrayList<String> Class2 = new ArrayList<>();

        Class2.add("Hakkı Bulut");
        Class2.add("Müslüm Gürses");
        Class2.add("Hakan Taşıyan");
        Class2.add("Mahsun Kırmızıgül");
        Class2.add("İbrahim Tatlıses");
        Class2.add("Mahmut Ferhan Yıldız");
        Class2.add("Yıldız Tilbe");
        Class2.add("Numan Ateş");
        Class2.add("Feride Küçük");

        ArrayList<String> Class3 = new ArrayList<>();

        Class3.add("Bayram Derviş");
        Class3.add("Tarkan Uzun");
        Class3.add("Burcu Gülhan Akar");
        Class3.add("Esra Bakırcı");
        Class3.add("Kıvanç Ertan Gevrek");
        Class3.add("Kamuran Başoğlu");
        Class3.add("Semiramis Uyanık");
        Class3.add("Gül Tarıkoğlu");
        Class3.add("Burhan Çakmak");


        Map<String, ArrayList> studentClass = new HashMap<>();

        studentClass.put("Class-1", Class1);
        studentClass.put("Class-2", Class2);
        studentClass.put("Class-3", Class3);



        for (int i=0;i< studentClass.size();i++){
            ArrayList classArr =(studentClass.get("Class-"+(i+1)));
            for (int j=0;j<classArr.size();j++){
                String names = classArr.get(j).toString();
                String splitName[]= names.split(" ");
                String justName = splitName[splitName.length-2];
                if(justName.endsWith("an")){
                    System.out.println(names + " in the Class-"+(i+1));
                }
            }
        }




    }

}
