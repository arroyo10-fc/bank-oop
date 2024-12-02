package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;

import java.util.Scanner;

public class Bank {
    private String name;
    private Account[] accounts;

    public Bank(String name, Account[] accounts) {
        this.name = name;
        this.accounts = accounts;
    }

    // Mostrar todas las cuentas del banco (IBAN, saldo y NIF del cliente)
    // public void showAccounts() {
    //    for (Account account : accounts) {
    //        System.out.println("IBAN: " + account.getIban() + "Saldo: " + account.getSaldo() + "NIF: " + account.getCustomer().getNif());
    //    }
    // }

    public void showAccounts() {
        for (var account : accounts) {
            account.showInfo();
        }
    }

    // Encontrar una cuenta
    public Account findAccount(String iban) {
        for (Account account : accounts) {
            if (account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
    }

    // Dado un IBAN, mostrar la información de la cuenta con ese IBAN.
    public void showIban(String iban) {
        for (var account : accounts) {
            if(account.getIban().equals(iban)) {
                account.showInfo();
            }
        }
    }

    // Dado un NIF, mostrar todas las cuentas del cliente con ese NIF
    public void showNif(String nif) {
        for (var account : accounts) {
            if(account.getCustomer().getNif().equals(nif)) {
                account.showInfo();
            }
        }
    }

    //Dado un IBAN y una cantidad de dinero, ingresar esa cantidad en la cuenta con ese IBAN. Si no se encuentra la cuenta con ese IBAN muestra el mensaje "No se encuentra la cuenta"
    public void ingresarDinero(String iban, double cantidad) {
        boolean accountFind = false;
        for (var account : accounts) {
            if (account.getIban().equals(iban)) {
                account.ingresar(cantidad);
                accountFind = true;
                System.out.println("Cantidad ingresada correctamente. Nuevo saldo: " + account.getSaldo());
                break;
            }
        }

        if (!accountFind) {
            System.out.println("No se encuentra la cuenta");
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Account[] getAccounts() {
        return accounts;
    }

    public void setAccounts(Account[] accounts) {
        this.accounts = accounts;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                '}';
    }
}
