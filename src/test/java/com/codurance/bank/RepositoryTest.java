package com.codurance.bank;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RepositoryTest {

  private Repository repository;

  @BeforeEach
  void setUp() {
    repository = new Repository();
  }

  @Test
  void deposits_transaction() {
    repository.deposit(500);
    assertThat(repository.getTransactions()).hasSize(1);
    assertThat(
        repository.getTransactions()
    ).contains(new Transaction(500));
  }

  @Test
  void withdraw_transaction() {
    repository.deposit(1000);
    repository.withdraw(500);
    assertThat(repository.getTransactions()).hasSize(2);
    assertTrue(
        reflectionEquals(
        repository.getTransactions().get(0),
        new Transaction(1000))
    );

    assertTrue(
        reflectionEquals(
        repository.getTransactions().get(1),
        new Transaction(-500))
    );
  }
}
