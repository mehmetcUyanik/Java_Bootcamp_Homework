package Homeworks.Homework3.service;

import Homeworks.Homework3.model.InsuranceCompany;
import Homeworks.Homework3.model.Policy;
import Homeworks.Homework3.model.Vehicle;

import java.math.BigDecimal;
import java.util.Date;

public class PolicyService {

    public Policy createPolicy(InsuranceCompany insuranceCompany, Vehicle vehicle, BigDecimal price,
                               Date startDate, Date endDate){

        Policy policy = new Policy();

        policy.setInsuranceCompany(insuranceCompany);
        policy.setVehicle(vehicle);
        policy.setPrice(price);
        policy.setStartDate(startDate);
        policy.setEndDate(endDate);

        return policy;
    }
}
