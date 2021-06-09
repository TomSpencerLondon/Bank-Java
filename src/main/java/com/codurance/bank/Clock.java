package com.codurance.bank;

import java.time.LocalDate;

public class Clock {

  public LocalDate date() {
    return now();
  }

  public LocalDate now() {
    return LocalDate.now();
  }
}
