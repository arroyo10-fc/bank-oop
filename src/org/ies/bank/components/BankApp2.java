package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp2 {
    private final Scanner scanner;
    private final BankReader bankReader;

    public BankApp2(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        Bank bank = bankReader.read();

        //Busca la cuenta con IBAN "ES0001".
        //Si no existe muestra "La cuenta no existe"
        //Si existe, hace un deposito en la misma de 500
        Account account01 = bank.findAccount("ES0001");
        if (account01 != null) {
            bank.deposit("ES0001", 500);
        } else {
            System.out.println("La cuenta no existe");
        }
        //Busca otra cuenta con IBAN "ES0002"
        //Si no existe muestra "La cuenta no existe"
        //Si existe, saca 30 euros
        Account account02 = bank.findAccount("ES0002");
        if (account02 != null) {
            bank.deposit("ES0002", -30);
        } else {
            System.out.println("La cuenta no existe");
        }
        //Muestra en pantalla la información de la cuenta "ES0001"
        account01.showInfo();
        //Muestra en pantalla la información de la cuenta "ES0002"
        account02.showInfo();
        //Haz una trasnferencia de 500 euros desde "ES0001" a "ES0002"


        }
}
