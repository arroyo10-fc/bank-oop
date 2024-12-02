package org.ies.bank.components;

import org.ies.bank.model.Bank;
import org.ies.bank.model.Account;

import java.util.Scanner;

public class BankReader {
    private final Scanner scanner;
    private final AccountReader accountReader;

    public BankReader(Scanner scanner, AccountReader accountReader) {
        this.scanner = scanner;
        this.accountReader = accountReader;
    }

    public Bank reader () {
        System.out.println("Introduce los datos del banco");
        System.out.println("Nombre del banco: ");
        String name = scanner.nextLine();
        System.out.println("¿Cuantas cuentas tiene el banco?");
        int numAccounts = scanner.nextInt();
        scanner.nextLine();

        Account[] accounts = new Account[numAccounts];
        for (int i = 0; i < accounts.length; i++) {
            accounts[i] = accountReader.read();
        }

        return new Bank(
                name,
                accounts
        );
    }
}


