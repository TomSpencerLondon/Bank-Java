package com.codurance.bank;

import java.util.ArrayList;
import java.util.List;

public class Repository {

  private List<Transaction> transactions = new ArrayList<>();

  public void deposit(int amount) {
    transactions.add(new Transaction(amount));
  }

  public void withdraw(int amount) {
    transactions.add(new Transaction(-amount));
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }
}
