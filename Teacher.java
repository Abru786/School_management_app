package com.example;

/*
 * This class represents a Teacher in the school management system.
 * It can be extended to include properties and methods relevant to teachers.
 * 
 */
public class Teacher {
  private int Id;
  private String name;
  private int Salary;
  private int salaryEarned;

  Teacher(int id, int Salary, String name) {
    this.Id = id;
    this.name = name;
    this.Salary = Salary;
    this.salaryEarned = 0;
  }

  /*
   * this method is getting the teacher's ID
   * 
   * @return the ID of the teacher
   */
  public int getId() {
    return Id;
  }

  /*
   * this method is return name of the teacher
   * 
   * @return the name of the teacher
   */
  public String getName() {
    return name;
  }

  /*
   * this method is return the salary of the teacher
   * 
   * @return the salary of the teacher
   */
  public int getSalary() {
    return Salary;
  }

  // /*
  // * this method is return the salary earned by the teacher
  // *
  // * @return the salary earned by the teacher
  // */
  // public void receiveSalary(int salary) {
  // salaryEarned += salary;
  // School.updateTotalMoneySpent(salary);
  // }
  public int getSalaryEarned() {
    return salaryEarned;
  }

  public void receiveSalary(int salary) {
    salaryEarned += salary;
    School.updateTotalMoneySpent(salary);
  }

  @Override
  public String toString() {
    return "Teacher{" +
        "Id=" + Id +
        ", name='" + name + '\'' +
        ", Salary=" + Salary +
        ", salaryEarned=" + salaryEarned +
        '}';
  }

}
