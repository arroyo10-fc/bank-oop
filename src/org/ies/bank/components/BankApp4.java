package org.ies.bank.components;

import org.ies.bank.model.Bank;
import org.ies.bank.model.Account;

public class BankApp4 {
    private final BankReader bankReader;

    public BankApp4(BankReader bankReader) {
        this.bankReader = bankReader;
    }

    public void run() {
        //Pide un banco usando BankReader
        Bank bank = bankReader.read();
        //Busca la cuenta con IBAN ES0001
        Account account = bank.findAccount("ES0001");
        if (account != null) {
            account.showInfo();
            account.showInfo(bank);
        }
        //Si no existe la cuenta muestra un mensaje de error
        //Si existe:
        //Muestra los datos de la cuenta
        //Haz una transferencia de todo el dinero de la cuenta ES0001 a la cuenta ES0002
        //Muestra la información del banco
    }

}
