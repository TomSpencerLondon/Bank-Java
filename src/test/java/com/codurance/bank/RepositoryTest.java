package com.codurance.bank;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collections;
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
}
