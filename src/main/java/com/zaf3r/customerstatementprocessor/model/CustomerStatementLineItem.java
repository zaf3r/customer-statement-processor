package com.zaf3r.customerstatementprocessor.model;

public class CustomerStatementLineItem {
    private long transactionReference;
    private String accountNumber;
    private double startBalance;
    private double mutation;
    private double endBalance;
    private String description;
    private boolean failedRecord;

    public CustomerStatementLineItem(long transactionReference, String accountNumber, double startBalance, double mutation, double endBalance, String description) {
        this.transactionReference = transactionReference;
        this.accountNumber = accountNumber;
        this.startBalance = startBalance;
        this.mutation = mutation;
        this.endBalance = endBalance;
        this.description = description;
    }

    public long getTransactionReference() {
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

    public boolean isFailedRecord() {
        return failedRecord;
    }

    public void setFailedRecord(boolean failedRecord) {
        this.failedRecord = failedRecord;
    }

    @Override
    public String toString() {
        return "CustomerStatementLineItem{" +
                "transactionReference=" + transactionReference +
                ", accountNumber='" + accountNumber + '\'' +
                ", startBalance=" + startBalance +
                ", mutation=" + mutation +
                ", endBalance=" + endBalance +
                ", description='" + description + '\'' +
                ", failedRecord=" + failedRecord +
                '}';
    }
}
