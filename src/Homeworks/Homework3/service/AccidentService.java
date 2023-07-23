package Homeworks.Homework3.service;

import Homeworks.Homework3.model.Accident;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class AccidentService {

    /*
    Accident sınıfı için service oluşturuldu. accident objesini oluşturmak ve fieldları doldurmak için
    "createAccident" methodu oluşturuldu.
     */


    public Accident createAccident(LocalDate accidentDate, String description, BigDecimal damageprice, int faliureRate){

        Accident accident = new Accident();

        accident.setAccidentDate(accidentDate);
        accident.setDescription(description);
        accident.setDamagePrice(damageprice);
        accident.setFailureRate(faliureRate);

        return accident;
    }


}
