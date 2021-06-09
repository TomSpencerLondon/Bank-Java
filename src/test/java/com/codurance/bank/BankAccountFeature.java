package com.codurance.bank;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class BankAccountFeature {
//  Date       || Amount || Balance
//14/01/2012 || -500   || 2500
//    13/01/2012 || 2000   || 3000
//    10/01/2012 || 1000   || 1000
    private static final String HEADER = "Date       || Amount || Balance";

  @Mock
  private Console console;

  private AccountService service;

  @BeforeEach
  void setUp() {
    service = new AccountService(console);
  }

  @Test
  void prints_empty_statement() {

    service.print();

    verify(console).print(HEADER);
 }

 @Test
 void prints_statement_with_records() {
     service.deposit(1000);
     service.deposit(2000);
     service.withdraw(500);
     service.print();

    verify(console).print(HEADER);
    verify(console).print("14/01/2012 -500 2500");
 }
}
