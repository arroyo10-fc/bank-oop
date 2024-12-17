package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;
import org.ies.bank.model.Customer;

public class BankApp3 {
    private final BankReader bankReader;

    public BankApp3(BankReader bankReader) {
        this.bankReader = bankReader;
    }
    public void run() {
        Bank bank = bankReader.read();
        // Muestra todas las cuentas del banco
        System.out.println("Cuentas del banco: ");
        for (Account account : bank.findAccount());
        System.out.println(account);

        // Saca 50 de la cuenta ES0003
        Account accountES0003 = bank.findAccount("ES0003");
        if (accountES0003 != null) {
            accountES0003.deposit(-50);
            System.out.println("Hemos sacado 50 euros");
        } else {
            System.out.println("La cuenta no existe");
        }

        // Muestra las cuentas del cliente con NIF 000X
        Customer customer000X = bank.findNif("000X");
        if (customer000X != null) {
            customer000X.showInfo();
        }

        //Mete 300 en la cuenta ES004
        Account accountES0004 = bank.findAccount("ES0004");
        if (accountES0003 != null) {
            accountES0003.deposit(300);
            System.out.println("Hemos ingresado 50 euros");
        } else {
            System.out.println("La cuenta no existe");
        }


        //Muestra los datos del titular de la cuenta ES0001
        Account accountES0001 = bank.findAccount("ES0001");

    }
}