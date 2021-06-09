package com.codurance.bank;
import static org.apache.commons.lang3.builder.EqualsBuilder.*;
import static org.apache.commons.lang3.builder.HashCodeBuilder.reflectionHashCode;


public class Transaction {

  private final int amount;

  public Transaction(int amount) {
    this.amount = amount;
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
