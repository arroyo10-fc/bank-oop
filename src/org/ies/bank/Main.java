package org.ies.bank;

import org.ies.bank.components.AccountReader;
import org.ies.bank.components.BankApp;
import org.ies.bank.components.BankReader;
import org.ies.bank.components.CustomerReader;
import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
        CustomerReader customerReader = new CustomerReader(scanner);
        AccountReader accountReader = new AccountReader(scanner, customerReader);
        BankReader bankReader = new BankReader(scanner, accountReader);
        BankApp bankApp = new BankApp(scanner, bankReader);

        bankApp.run();
    }
}
