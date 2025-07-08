package com.example;

import java.util.List;

public class School {
  private List<Student> students;
  private List<Teacher> teachers;
  private static int totalMoneyEarned;
  private static int totalMoneySpent;

  /*
   * This method is used to get the list of students in the school
   * 
   * @return the list of students
   * 
   */
  public School(List<Student> students, List<Teacher> teachers) {
    this.students = students;
    this.teachers = teachers;
    totalMoneyEarned = 0;
    totalMoneySpent = 0;

  }

  /*
   * This method is used to add a new student to the school
   * 
   * @param student the new student to be added
   */
  public List<Student> getStudents() {
    return students;
  }

  /*
   * returns the list of students in the school
   * 
   * @return the list of students
   */
  public void addStudents(Student student) {
    students.add(student);
  }

  /*
   * This method is used to add a new teacher to the school
   * 
   * @param teacher the new teacher to be added
   */
  public List<Teacher> getTeachers() {
    return teachers;
  }

  /*
   * returns the list of teachers in the school
   * 
   * @return the list of teachers
   */
  public void addTeachers(Teacher teacher) {
    teachers.add(teacher);
  }

  /*
   * This method is used to add the total money earned by the school
   * 
   * @param money the money to be added
   */

  public int getTotalMoneyEarned() {
    return totalMoneyEarned;
  }

  /*
   * This method is used to update the total money earned by the school
   * 
   * @param MoneyEarned the money to be added
   */
  public static void updateTotalMoneyEarned(int MoneyEarned) {
    totalMoneyEarned += MoneyEarned;
  }

  public int getTotalMoneySpent() {
    return totalMoneySpent;
  }

  /*
   * This method is used to update the total money spent by the school
   * 
   * @param MoneySpent the money to be subtracted
   */
  public static void updateTotalMoneySpent(int MoneySpent) {
    totalMoneySpent += MoneySpent;
  }

  @Override
  public String toString() {
    return "School{" +
        "students=" + students.size() +
        ", teachers=" + teachers.size() +
        ", totalMoneyEarned=" + totalMoneyEarned +
        ", totalMoneySpent=" + totalMoneySpent +
        '}';
  }

}
