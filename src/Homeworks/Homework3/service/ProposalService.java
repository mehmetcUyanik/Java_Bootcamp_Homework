package Homeworks.Homework3.service;

import Homeworks.Homework3.model.InsuranceCompany;
import Homeworks.Homework3.model.Proposal;
import Homeworks.Homework3.model.Vehicle;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

public class ProposalService {

    VehicleService vehicleService = new VehicleService();

    /*
    Proposal sınıfı için service oluşturuldu. proposal objesini oluşturmak ve fieldları doldurmak için
    "createProposal" methodu oluşturuldu.
     */

    public Proposal createProposal(InsuranceCompany company, Vehicle vehicle, BigDecimal offerPrice,
                                   LocalDate startDate, LocalDate endDate, LocalDate expireDate, BigDecimal discountPrice){

        Proposal proposal = new Proposal();
        proposal.setCompany(company);
        proposal.setVehicle(vehicle);
        proposal.setOfferPrice(calculatedDamagePriceForAccident(offerPrice,vehicle));
        proposal.setStartDate(startDate);
        proposal.setEndDate(endDate);
        proposal.setExpireDate(expireDate);
        proposal.setDiscountPrice(discountPrice);

        return proposal;
    }

    public BigDecimal calculateDiscountedPrice(Proposal proposal){

        if (proposal.getDiscountPrice()!=null){
            return proposal.getOfferPrice().subtract(proposal.getDiscountPrice());
        }else
        return proposal.getOfferPrice();
    }


    public BigDecimal calculatedDamagePriceForAccident(BigDecimal offerPrice, Vehicle vehicle){
        BigDecimal totalOfferPrice = BigDecimal.ZERO;

        BigDecimal totalDamagePrice = vehicleService.totalOfAccidentDamagePrice(vehicle);

        if (totalDamagePrice.compareTo(BigDecimal.ZERO) == 0){
            totalOfferPrice = offerPrice;
        }
        else if (totalDamagePrice.compareTo(BigDecimal.ZERO) > 0 && totalDamagePrice.compareTo(new BigDecimal(4000)) <=0){
            totalOfferPrice = offerPrice.add(totalOfferPrice.multiply(new BigDecimal(10)).divide(new BigDecimal(100)));
        }else if (totalDamagePrice.compareTo(new BigDecimal(4000)) >=0 && totalDamagePrice.compareTo(new BigDecimal(8000))<=0) {
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(25)).divide(new BigDecimal(100)));
        }else if (totalDamagePrice.compareTo(new BigDecimal(8000)) > 0 && totalDamagePrice.compareTo(new BigDecimal(16000)) <=0){
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(40)).divide(new BigDecimal(100)));
        }else {
            totalOfferPrice = offerPrice.add(offerPrice.multiply(new BigDecimal(80)).divide(new BigDecimal(100)));
        }

        return totalOfferPrice;
    }


}
