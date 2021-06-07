package com.codurance.bank;

public class AccountService {

  private final Console console;

  public AccountService(Console console) {
    this.console = console;
  }


  public void print() {
    String header = "Date       || Amount || Balance";
    console.print(header);
  }
}
