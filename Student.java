package com.example;

import java.security.PrivateKey;

public class Student {
  private int Id;
  private String name;
  private int grade;
  private int feesPaid;
  private int feesTotal;

  public Student(int id, String name, int grade) {
    this.feesPaid = 0;
    this.feesTotal = 30000;
    this.Id = id; // Fixed bug here
    this.name = name;
    this.grade = grade;
  }

  public void setGrade(int grade) {
    this.grade = grade;
  }

  public void payfees(int fees) {
    feesPaid += fees;
    School.updateTotalMoneyEarned(fees);
  }

  public int getId() {
    return Id;
  }

  public String getName() {
    return name;
  }

  public int getGrade() {
    return grade;
  }

  public int getFeesPaid() {
    return feesPaid;
  }

  public int getFeesTotal() {
    return feesTotal;
  }

  public int getRemainingFees() {
    return feesTotal - feesPaid;
  }

  @Override
  public String toString() {
    return "Student{" +
        "Id=" + Id +
        ", name='" + name + '\'' +
        ", grade=" + grade +
        ", feesPaid=" + feesPaid +
        ", feesTotal=" + feesTotal +
        '}';
  }
}