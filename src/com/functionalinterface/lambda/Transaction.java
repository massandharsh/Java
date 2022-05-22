package com.functionalinterface.lambda;

public class Transaction{
    Integer value;
    TransactionType transactionType;
    double id;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "value=" + value +
                ", transactionType=" + transactionType +
                '}';
    }

    public Transaction(int value, TransactionType transactionType) {
        this.value = value;
        this.transactionType = transactionType;
        this.id = Math.random();
    }


}
