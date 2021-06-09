package com.codurance.bank;

import static java.util.Collections.*;

import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AccountService {

  private final Console console;
  private final Repository repository;
  private int balance;

  public AccountService(Console console, Repository repository) {
    this.console = console;
    this.repository = repository;
  }


  public void print() {
    String header = "Date       || Amount || Balance";
    console.print(header);
    printTransactions();
  }

  private void printTransactions() {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    Comparator<Transaction> compareByDate = (Transaction o1, Transaction o2) -> o1.date.compareTo( o2.date);
    List<Transaction> transactions = repository.getTransactions();
    Collections.sort(transactions, compareByDate);

    transactions.stream().forEach((t) -> {
      balance += t.amount;
      StringBuilder builder = new StringBuilder();
      builder.append(formatter.format(t.date));
      builder.append(" ");
      builder.append(t.amount);
      builder.append(" " + balance);
      console.print(builder.toString());
    });
  }

  public void deposit(int money) {
    repository.deposit(money);
  }

  public void withdraw(int money) {
    repository.withdraw(money);
  }
}
