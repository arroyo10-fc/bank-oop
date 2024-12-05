package org.ies.bank.components;

import org.ies.bank.model.Bank;

import java.util.Scanner;

public class BankApp {
    // Se necesita el Scanner para hacer el menu
    private final Scanner scanner;
    // Se necesita el BankReader para pedir un banco al usuario
    private final BankReader bankReader;

    public BankApp(Scanner scanner, BankReader bankReader) {
        this.scanner = scanner;
        this.bankReader = bankReader;
    }

    public void run() {
        // Siempre empezamos pidiendo los datos con el reader
        Bank bank = bankReader.read();

        int option;
        do {
            option = chooseOption();
            if (option == 1) {
                // Mostrar cuentas
                bank.showAccounts();
            } else if (option == 2) {
                // Mostrar datos cuenta
                System.out.println("Introduce el IBAN:");
                String iban = scanner.nextLine();
                bank.showAccount(iban);
            } else if (option == 3) {
                // Mostrar cuentas de cliente
                System.out.println("Introduce el NIF");
                String nif = scanner.nextLine();
                bank.showAccount(nif);
            } else if (option == 4) {
                // Ingresar
                System.out.println("Introduce el IBAN:");
                String iban = scanner.nextLine();
                System.out.println("Que cantidad quieres ingresar: ");
                double num1 = scanner.nextInt();
                scanner.nextLine();
                bank.deposit(iban, num1);
                bank.showAccount(iban);
            } else if (option == 5) {
                // Sacar
                System.out.println("Introduce el IBAN");
                String iban = scanner.nextLine();
                System.out.println("Que cantidad quieres sacar: ");
                double num2 = scanner.nextInt();
                bank.deposit(iban, num2);
                bank.showAccount(iban);
                scanner.nextLine();
            }
        } while (option != 6);
    }

    private int chooseOption() {
        int option;
        do {
            System.out.println("Elige una opcion:");
            System.out.println("1. Mostrar cuentas");
            System.out.println("2. Mostrar datos cuenta");
            System.out.println("3. Mostrar cuentas de cliente");
            System.out.println("4. Ingresar");
            System.out.println("5. Sacar");
            System.out.println("6. Salir");
            option = scanner.nextInt();
            scanner.nextLine();
        } while (option < 1 || option > 6);
        return option;
    }
}