package com.zaf3r.customerstatementprocessor.model;

public class CustomerStatementLineItem {
    private int transactionReference;
    private String accountNumber;
    private double startBalance;
    private double mutation;
    private double endBalance;
    private String description;

    public CustomerStatementLineItem(int transactionReference, String accountNumber, double startBalance, double mutation, double endBalance, String description) {
        this.transactionReference = transactionReference;
        this.accountNumber = accountNumber;
        this.startBalance = startBalance;
        this.mutation = mutation;
        this.endBalance = endBalance;
        this.description = description;
    }

    public int getTransactionReference() {
        return transactionReference;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getStartBalance() {
        return startBalance;
    }

    public double getMutation() {
        return mutation;
    }

    public double getEndBalance() {
        return endBalance;
    }

    public String getDescription() {
        return description;
    }
}
