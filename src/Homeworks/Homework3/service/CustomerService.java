package Homeworks.Homework3.service;

import Homeworks.Homework3.model.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    ProposalService proposalService = new ProposalService();
    PaymentMovementService paymentMovementService = new PaymentMovementService();

    /*
    Customer sınıfı için service oluşturuldu. customer objesini oluşturmak ve fieldları doldurmak için
    "createCustomer" ve add methodları oluşturuldu.
     */


    public Customer createCustomer(String name, CustomerTypeEnum customerTypeEnum){

        Customer customer = new Customer();
        customer.setName(name);
        customer.setCustomerTypeEnum(customerTypeEnum);

        return customer;
    }

    public void addBankAccountToCustomer(Customer customer, BankAccount bankAccount){

        if(customer.getBankAccountList()!=null) {
            customer.getBankAccountList().add(bankAccount);
        }else {
            ArrayList<BankAccount> bankAccountList = new ArrayList<>();
            bankAccountList.add(bankAccount);
            customer.setBankAccountList(bankAccountList);
        }
    }

    public void addInsuranceRequestToCustomer(Customer customer, InsuranceRequest insuranceRequest){

        if(customer.getInsuranceRequestList() != null){
            customer.getInsuranceRequestList().add(insuranceRequest);
        }else{
            ArrayList<InsuranceRequest> insuranceRequestList = new ArrayList<>();
            insuranceRequestList.add(insuranceRequest);
            customer.setInsuranceRequestList(insuranceRequestList);
        }
    }

    public void addPolicyToCustomer(Customer customer, Policy policy){

        if (customer.getPolicyList() != null){
            customer.getPolicyList().add(policy);
        }else{
            ArrayList<Policy> policyList = new ArrayList<>();
            policyList.add(policy);
            customer.setPolicyList(policyList);
        }
    }

    public void addPaymentMovementToCustomer(Customer customer, PaymentMovement paymentMovement){

        if (customer.getPaymentMovementList() != null){
            customer.getPaymentMovementList().add(paymentMovement);
        }else{
            ArrayList<PaymentMovement> paymentMovementList = new ArrayList<>();
            paymentMovementList.add(paymentMovement);
            customer.setPaymentMovementList(paymentMovementList);
        }
    }

    public void addVehicleToCustomer(Customer customer, Vehicle vehicle){

        if (customer.getVehicleList() != null){
            customer.getVehicleList().add(vehicle);
        }else{
            ArrayList<Vehicle> vehicleList = new ArrayList<>();
            vehicleList.add(vehicle);
            customer.setVehicleList(vehicleList);
        }
    }

    public void acceptProposal(Customer customer, Proposal proposal, InsuranceRequest insuranceRequest,
                               Agency agency, InsuranceCompany insuranceCompany){

        List<InsuranceRequest> insuranceRequestList = customer.getInsuranceRequestList();

        AgencyService agencyService = new AgencyService();
        InsuranceCompanyService insuranceCompanyService = new InsuranceCompanyService();

        for (InsuranceRequest insuranceRequest1: insuranceRequestList
             ) {if (insuranceRequest1.equals(insuranceRequest)){
            for (Proposal proposal1: insuranceRequest1.getProposalList()
                 ) {
                if (proposal1.equals(proposal)){
                    BankAccount bankAccount = checkBankAccount(customer,proposalService.calculateDiscountedPrice(proposal));
                    if (bankAccount!=null){

                        BigDecimal priceWithDiscount = proposalService.calculateDiscountedPrice(proposal);
                      bankAccount.setAmount(bankAccount.getAmount().subtract(priceWithDiscount));

                      PaymentMovement customerPaymentMovement = paymentMovementService.createPaymentMovement(bankAccount,
                              "insurance payment",MovementType.OUTCOME,priceWithDiscount);

                      addPaymentMovementToCustomer(customer,customerPaymentMovement);

                      BigDecimal agencyPayment = priceWithDiscount.multiply(proposal.getCompany().getCommission()).divide(new BigDecimal(100));

                      agency.getBankAccountList().get(0).setAmount(agency.getBankAccountList().get(0).getAmount().add(agencyPayment));

                      PaymentMovement agencyPaymentMovement = paymentMovementService.createPaymentMovement(agency.getBankAccountList().get(0),
                              "insurance payment transfer to agency",MovementType.INCOME,agencyPayment);

                      agencyService.addPaymentMovementToAgency(agency,agencyPaymentMovement);

                      BigDecimal companyPayment = priceWithDiscount.subtract(agencyPayment);

                      insuranceCompany.getBankAccountList().get(0).setAmount(insuranceCompany.getBankAccountList().get(0).getAmount().add(companyPayment));

                      PaymentMovement companyPaymentMovement = paymentMovementService.createPaymentMovement(insuranceCompany.getBankAccountList().get(0),
                              "insurance payment transfer to insurance company",MovementType.INCOME,companyPayment);

                      insuranceCompanyService.addPaymentMovementToInsuranceCompany(insuranceCompany,companyPaymentMovement);


                        proposal1.setApproved(true);


                    }
                }

            }
        }

        }

    }

   public BankAccount checkBankAccount(Customer customer, BigDecimal amount){

        List<BankAccount> bankAccountList = customer.getBankAccountList();
       for (BankAccount bankAccount: bankAccountList) {

           if (bankAccount.getAmount().compareTo(amount)>=0){
               return bankAccount;
           }

       }
       return null;
   }




}
