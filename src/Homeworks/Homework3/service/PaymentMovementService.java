package Homeworks.Homework3.service;

import Homeworks.Homework3.model.BankAccount;
import Homeworks.Homework3.model.MovementType;
import Homeworks.Homework3.model.PaymentMovement;

import java.math.BigDecimal;

public class PaymentMovementService {

    /*
    PaymentMovement sınıfı için service oluşturuldu. paymentMovement objesini oluşturmak ve fieldları doldurmak için
    "createPaymentMovement" methodu oluşturuldu.
     */


    public PaymentMovement createPaymentMovement (BankAccount bankAccount, String description,
                                                  MovementType movementType, BigDecimal amount){

        PaymentMovement paymentMovement = new PaymentMovement();

        paymentMovement.setBankAccount(bankAccount);
        paymentMovement.setDescription(description);
        paymentMovement.setMovementType(movementType);
        paymentMovement.setAmount(amount);

        return paymentMovement;
    }
}
