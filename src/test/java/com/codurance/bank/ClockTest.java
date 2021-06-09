package com.codurance.bank;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ClockTest {

  private Clock testableClock;

  @BeforeEach
  void setUp() {
    testableClock = new TestableClock();
  }

  @Test
  void returns_date() {
    assertEquals(
        testableClock.date(),
        LocalDate.of(2012, 01, 14)
    );
  }

  private class TestableClock extends Clock {
    public LocalDate now() {
      return LocalDate.of(2012, 01, 14);
    }
  }
}
