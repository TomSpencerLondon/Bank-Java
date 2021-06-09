package com.codurance.bank;

public class AccountService {

  private final Console console;
  private final Repository repository;

  public AccountService(Console console, Repository repository) {
    this.console = console;
    this.repository = repository;
  }


  public void print() {
    String header = "Date       || Amount || Balance";
    console.print(header);
  }

  public void deposit(int money) {
    repository.deposit(money);
  }

  public void withdraw(int money) {
    repository.withdraw(money);
  }
}
