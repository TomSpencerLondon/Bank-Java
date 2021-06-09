package com.codurance.bank;

import static org.apache.commons.lang3.builder.EqualsBuilder.reflectionEquals;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.Date;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class RepositoryTest {

  private Repository repository;

  @Mock
  Clock clock;

  @BeforeEach
  void setUp() {
    repository = new Repository(clock);
  }

  @Test
  void deposits_transaction_with_date() {
    when(clock.date())
        .thenReturn(LocalDate.of(2012, 01, 14));
    repository.deposit(500);
    assertThat(repository.getTransactions()).hasSize(1);
    assertThat(
        repository.getTransactions()
    ).contains(new Transaction(500,
        LocalDate.of(2012, 01, 14)));
  }

  @Test
  void withdraw_transaction() {
    when(clock.date())
        .thenReturn(LocalDate.of(2012, 01, 14))
        .thenReturn(LocalDate.of(2012, 01, 15));

    repository.deposit(1000);
    repository.withdraw(500);
    assertThat(repository.getTransactions()).hasSize(2);
    assertTrue(
        reflectionEquals(
          repository.getTransactions().get(0),
          new Transaction(1000, LocalDate.of(2012, 01, 14)))
    );

    assertTrue(
        reflectionEquals(
        repository.getTransactions().get(1),
        new Transaction(-500, LocalDate.of(2012, 01, 15)))
    );
  }
}
