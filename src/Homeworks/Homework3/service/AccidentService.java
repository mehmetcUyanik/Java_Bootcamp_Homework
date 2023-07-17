package Homeworks.Homework3.service;

import Homeworks.Homework3.model.Accident;

import java.math.BigDecimal;
import java.util.Date;

public class AccidentService {


    public Accident createAccident(Date accidentDate, String description, BigDecimal damageprice, int faliureRate){

        Accident accident = new Accident();

        accident.setAccidentDate(accidentDate);
        accident.setDescription(description);
        accident.setDamagePrice(damageprice);
        accident.setFailureRate(faliureRate);

        return accident;
    }
}
