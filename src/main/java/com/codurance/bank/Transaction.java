package com.codurance.bank;
import static org.apache.commons.lang3.builder.EqualsBuilder.*;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;

import java.time.LocalDate;


public class Transaction {

  public final int amount;
  public final LocalDate date;

  public Transaction(int amount, LocalDate date) {
    this.amount = amount;
    this.date = date;
  }

  @Override
  public boolean equals(Object other) {
    return reflectionEquals(this, other);
  }

  @Override
  public int hashCode() {
    return reflectionHashCode(this);
  }

}
