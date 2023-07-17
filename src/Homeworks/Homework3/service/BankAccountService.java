package Homeworks.Homework3.service;

import Homeworks.Homework3.model.BankAccount;

import java.math.BigDecimal;

public class BankAccountService {

    /*
    BankAccount sınıfı için service oluşturuldu. bankAccount objesini oluşturmak ve fieldları doldurmak için
    "createBankAccount" methodu oluşturuldu.
     */

    public BankAccount createBankAccount(String name, String iban, BigDecimal amount){

        BankAccount bankAccount = new BankAccount();
        bankAccount.setName(name);
        bankAccount.setIban(iban);
        bankAccount.setAmount(amount);

        return bankAccount;
    }
}
