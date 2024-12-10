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
        System.out.println("ES0001");
        String iban = scanner.nextLine();
        Account account = bankReader.read().findAccount(iban);

        //int option;
        //do {
        //    option = chooseOption();
        //    if (option == 1) {
        //        System.out.println("ES0001");
        //        String iban = scanner.nextLine();
        //        Account account = bank.findAccount(iban);
        //        account.deposit(500);
        //    } else if (option == 2) {
        //        System.out.println("ES0002");
        //         String iban = scanner.nextLine();
        //        Account account = bank.findAccount(iban);
        //       account.deposit(-30);
        //   } else if (option == 3) {
        //       System.out.println("ES0001");
        //       String iban = scanner.nextLine();
        //       bank.showAccount(iban);
        //   } else if (option == 4) {
        //       System.out.println("ES0002");
        //       String iban = scanner.nextLine();
        //      bank.showAccount(iban);
        //   }
        //} while (option != 4);
        //}

        //private int chooseOption() {
        //int option;
        //do {
        //  System.out.println("Elige una opción:");
        //  System.out.println("Busca la cuenta");
        //  System.out.println("Busca la cuenta");
        //  System.out.println("Muestra la información de la cuenta");
        //  System.out.println("Muestra la información de la cuenta");
        //  System.out.println("Hacer una transferencia de la cuenta a la cuenta");
        //  option = scanner.nextInt();
        //  scanner.nextLine();
        //} while (option < 1 || option > 8);
        //return option;
        //}
}
