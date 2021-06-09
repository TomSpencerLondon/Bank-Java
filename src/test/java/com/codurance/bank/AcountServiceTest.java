package com.codurance.bank;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class AcountServiceTest {

  @Mock
  Repository repository;

  @Mock
  private Console console;

  private AccountService service;

  @BeforeEach
  void setUp() {
    service = new AccountService(console, repository);
  }

  @Test
  void print_calls_console() {
    // act
    service.print();
    // assert
    String s = "Date       || Amount || Balance";

    verify(console).print(s);
  }

  @Test
  void should_deposit_money() {
      service.deposit(500);
      verify(repository).deposit(500);
  }

  @Test
  void should_withdraw_money() {
    service.withdraw(300);
    verify(repository).withdraw(300);
  }
}
