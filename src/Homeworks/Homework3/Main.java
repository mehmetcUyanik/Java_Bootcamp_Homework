package Homeworks.Homework3;

import Homeworks.Homework3.model.*;
import Homeworks.Homework3.service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class Main {
    public static void main(String[] args) {


        AgencyService agencyService = new AgencyService();
        BankAccountService bankAccountService = new BankAccountService();
        InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();
        InsuranceService insuranceService = new InsuranceService();
        CustomerService customerService = new CustomerService();
        VehicleService vehicleService = new VehicleService();
        InsuranceRequestService insuranceRequestService = new InsuranceRequestService();
        ProposalService proposalService = new ProposalService();
        AccidentService accidentService = new AccidentService();

        Agency agency = agencyService.createAgency("Man");

        System.out.println(agency);

        BankAccount bankAccount = bankAccountService.createBankAccount("İş Bankası","TR123456789", BigDecimal.ZERO);

        agencyService.addBankAccountToAgency(agency,bankAccount);

        System.out.println(agency);

        InsuranceCompany insuranceCompany = insuranceCompanyService.createInsuranceCompany("Allianz","Çankaya",
                "84936482","Ankara", new BigDecimal(8));

        Insurance insurance = insuranceService.createInsurance(InsuranceTypeEnum.COMPULSORY_TRAFFIC_INSURANCE,
                "Zorunlu Trafik Sigortası");

        insuranceCompanyService.addInsuranceToInsuranceCompany(insuranceCompany,insurance);

        BankAccount allianzBankAccount = bankAccountService.createBankAccount("Yapı Kredi","TR987654321", new BigDecimal(10000000));

        insuranceCompanyService.addBankAccountToInsuranceCompany(insuranceCompany,allianzBankAccount);

        Customer customer = customerService.createCustomer("Mehmet",CustomerTypeEnum.INDIVIDUAL);

        BankAccount customerBankAccount = bankAccountService.createBankAccount("Ziraat Bankası","TR456123789", new BigDecimal(10000));

        customerService.addBankAccountToCustomer(customer,customerBankAccount);

        agencyService.addCustomerToAgency(agency,customer);

        agencyService.addInsuranceCompanyToAgency(agency,insuranceCompany);

        Vehicle vehicle = vehicleService.createVehicle("Ford","Focus","34JK24","123456",
                2010,ColorTypeEnum.BLACK);

        customerService.addVehicleToCustomer(customer,vehicle);

        System.out.println(customer);

        InsuranceRequest insuranceRequest = insuranceRequestService.createInsuranceRequest(vehicle);

        customerService.addInsuranceRequestToCustomer(customer,insuranceRequest);

        LocalDate startDate = LocalDate.of(2023, Month.APRIL,25);
        LocalDate endDate = LocalDate.of(2024, Month.APRIL,25);
        LocalDate expiredDate = startDate.plusDays(3);

        Proposal proposal = proposalService.createProposal(insuranceCompany,vehicle,new BigDecimal(2000),
                startDate,endDate,expiredDate,new BigDecimal(100));

        insuranceRequestService.addProposalToInsuranceRequest(insuranceRequest,proposal);

        customerService.acceptProposal(customer,proposal,insuranceRequest,agency,insuranceCompany);

        System.out.println("*********************************************");

        System.out.println(proposal);
        System.out.println(customer);
        System.out.println(agency);
        System.out.println(insuranceCompany);

        LocalDate accidentDate = LocalDate.now();
        Accident accident = accidentService.createAccident(accidentDate,"Kaza tutanağı",new BigDecimal(5000),
                6);

        Vehicle vehicle1 = vehicleService.createVehicle("Ford","Focus","34JK24","123456",
                2010,ColorTypeEnum.BLACK);

        vehicleService.addAccidentToVehicle(vehicle1,accident);

        System.out.println("*********************************************");

        Proposal proposal1 = proposalService.createProposal(insuranceCompany,vehicle1,new BigDecimal(2000),
                startDate,endDate,expiredDate,new BigDecimal(100));

        insuranceRequestService.addProposalToInsuranceRequest(insuranceRequest,proposal1);

        customerService.acceptProposal(customer,proposal1,insuranceRequest,agency,insuranceCompany);

        System.out.println(proposal1);



    }
}
