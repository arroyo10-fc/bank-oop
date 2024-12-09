package org.ies.bank.components;

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

        int option;
        do {

        } while (option != 4);
    }

    private int chooseOption() {
        int option;
        do {
            System.out.println("");
            System.out.println("");
            System.out.println("");
            option = scanner.nextInt();
        } while (option < 1 || option > 8);
        return option;
    }
}
