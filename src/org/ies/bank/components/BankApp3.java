package org.ies.bank.components;

import org.ies.bank.model.Account;
import org.ies.bank.model.Bank;

public class BankApp3 {
    private final BankReader bankReader;

    public BankApp3(BankReader bankReader) {
        this.bankReader = bankReader;
    }
    public void run() {
        Bank bank = bankReader.read();

    }

}