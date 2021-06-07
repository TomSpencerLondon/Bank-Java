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

  @Mock
  private Console console;

  private AccountService service;

  @BeforeEach
  void setUp() {
    service = new AccountService(console);
  }

  @Test
  void prints_empty_statement() {
    String s = "Date       || Amount || Balance";

    service.print();

    verify(console).print(s);
 }
}
