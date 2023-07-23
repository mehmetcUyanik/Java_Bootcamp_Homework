package Homeworks.Homework3.service;

import Homeworks.Homework3.model.InsuranceRequest;
import Homeworks.Homework3.model.Policy;
import Homeworks.Homework3.model.Proposal;
import Homeworks.Homework3.model.Vehicle;

import java.util.ArrayList;

public class InsuranceRequestService {

    /*
    InsuranceRequest sınıfı için service oluşturuldu. insuranceRequest objesini oluşturmak ve fieldları doldurmak için
    "createInsuranceRequest" ve add methodları oluşturuldu.
     */

    public InsuranceRequest createInsuranceRequest(Vehicle vehicle){

        InsuranceRequest insuranceRequest = new InsuranceRequest();

        insuranceRequest.setVehicle(vehicle);


        return insuranceRequest;
    }

    public void addProposalToInsuranceRequest(InsuranceRequest insuranceRequest, Proposal proposal){

        if (insuranceRequest.getProposalList() != null){
            insuranceRequest.getProposalList().add(proposal);
        }else {
            ArrayList<Proposal> proposalList = new ArrayList<>();
            proposalList.add(proposal);
            insuranceRequest.setProposalList(proposalList);
        }
    }
}
