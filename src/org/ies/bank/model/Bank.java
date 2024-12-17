package org.ies.bank.model;

import java.util.Arrays;
import java.util.Objects;

public class Bank {
    private String name;
    private Account[] accounts;
    private Customer[] customers;

    public Bank(String name, Account[] accounts, Customer[] customers) {
        this.name = name;
        this.accounts = accounts;
        this.customers = customers;
    }

    public void showAccountCustomer(String iban) {
        var account = findAccount(iban);
        if (account == null) {
            System.out.println("La cuenta no existe");
        } else {
            account.getCustomer().showInfo();
        }
    }

    public int countCustomerAccounts(String nif) {
        int count = 0;
        for (var account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                count++;
            }
        }
        return count;
    }


    public void showAccounts() {
        for (var account : accounts) {
            account.showInfo();
        }
    }

    public void showAccount(String iban) {
        var account = findAccount(iban);
        if (account == null) {
            System.out.println("Cuenta no encontrada");
        } else {
            account.showInfo();
        }
    }

    public void showCustomerAccounts(String nif) {
        for (var account : accounts) {
            if (account.getCustomer().getNif().equals(nif)) {
                account.showInfo();
            }
        }
    }

    public void withdraw(String iban, double amount) {
        var account = findAccount(iban);
        if (account != null) {
            if (account.getBalance() >= amount) {
                account.deposit(-amount);
            } else {
                System.out.println("No hay suficiente saldo");
            }
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }

    public void deposit(String iban, double amount) {
        var account = findAccount(iban);

        if (account != null) {
            account.deposit(amount);
        } else {
            System.out.println("Cuenta no encontrada");
        }
    }

    public Account findAccount(String iban) {
        for (var account : accounts) {
            if (account.getIban().equals(iban)) {
                return account;
            }
        }
        return null;
    }

    public Customer findNif(String nif) {
        for (Customer customer : customers) {
            if (customer.getNif().equals(nif)) {
                return customer;
            }
        }
        return null;
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

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bank bank = (Bank) o;
        return Objects.equals(name, bank.name) && Objects.deepEquals(accounts, bank.accounts) && Objects.deepEquals(customers, bank.customers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, Arrays.hashCode(accounts), Arrays.hashCode(customers));
    }

    @Override
    public String toString() {
        return "Bank{" +
                "name='" + name + '\'' +
                ", accounts=" + Arrays.toString(accounts) +
                ", customers=" + Arrays.toString(customers) +
                '}';
    }

}