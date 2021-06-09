package com.codurance.bank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Repository {

  private final Clock clock;
  private List<Transaction> transactions = new ArrayList<>();

  public Repository(Clock clock) {
    this.clock = clock;
  }

  public void deposit(int amount) {
    LocalDate date = clock.date();
    transactions.add(new Transaction(amount, date));
  }

  public void withdraw(int amount) {
    LocalDate date = clock.date();
    transactions.add(new Transaction(-amount, date));
  }

  public List<Transaction> getTransactions() {
    return transactions;
  }
}
