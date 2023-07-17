package Homeworks.Homework3.service;

import Homeworks.Homework3.model.Insurance;
import Homeworks.Homework3.model.InsuranceTypeEnum;

public class InsuranceService {

    public Insurance createInsurance(InsuranceTypeEnum insuranceTypeEnum, String name){

        Insurance insurance = new Insurance();

        insurance.setInsuranceTypeEnum(insuranceTypeEnum);
        insurance.setName(name);

        return insurance;
    }
}
