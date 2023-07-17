package Homeworks.Homework3.service;

import Homeworks.Homework3.model.InsuranceCompany;
import Homeworks.Homework3.model.Proposal;
import Homeworks.Homework3.model.Vehicle;

import java.math.BigDecimal;
import java.util.Date;

public class ProposalService {

    /*
    Proposal sınıfı için service oluşturuldu. proposal objesini oluşturmak ve fieldları doldurmak için
    "createProposal" methodu oluşturuldu.
     */

    public Proposal createProposal(InsuranceCompany company, Vehicle vehicle, BigDecimal offerPrice,
                                   Date startDate, Date endDate, Date expireDate, boolean isApproved, BigDecimal discountPrice){

        Proposal proposal = new Proposal();
        proposal.setCompany(company);
        proposal.setVehicle(vehicle);
        proposal.setOfferPrice(offerPrice);
        proposal.setStartDate(startDate);
        proposal.setEndDate(endDate);
        proposal.setExpireDate(expireDate);
        proposal.setApproved(isApproved);
        proposal.setDiscountPrice(discountPrice);

        return proposal;
    }
}
