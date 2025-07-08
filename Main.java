
package com.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static School Saifiya;

    public static void main(String[] args) {
        // Initialize teachers and students
        Teacher Abrar = new Teacher(101, 59999, "Abrar");
        Teacher Ali = new Teacher(102, 60000, "Ali");
        Teacher Ahmed = new Teacher(103, 70000, "ahmed");
        List<Teacher> teacherList = new ArrayList<>(Arrays.asList(Abrar, Ali, Ahmed));

        Student AliRaza = new Student(201, "Ali Raza", 10);
        Student AhmedRaza = new Student(202, "Ahmed Raza", 10);
        Student Asad = new Student(203, "Asad", 9);
        List<Student> studentList = new ArrayList<>(Arrays.asList(AliRaza, AhmedRaza, Asad));

        Saifiya = new School(studentList, teacherList);

        SwingUtilities.invokeLater(Main::createAndShowGUI);
    }

    private static void createAndShowGUI() {
        JFrame frame = new JFrame("School Management System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700, 500);
        frame.setLocationRelativeTo(null);

        JTabbedPane tabs = new JTabbedPane();

        // Students Panel
        JPanel studentPanel = new JPanel(new BorderLayout());
        JTextArea studentArea = new JTextArea(15, 50);
        studentArea.setEditable(false);
        JButton refreshStudents = new JButton("Refresh List");
        refreshStudents.addActionListener(e -> studentArea.setText(getStudentList()));
        studentPanel.add(new JScrollPane(studentArea), BorderLayout.CENTER);
        studentPanel.add(refreshStudents, BorderLayout.SOUTH);

        // Add Student Panel
        JPanel addStudentPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        JTextField sidField = new JTextField();
        JTextField snameField = new JTextField();
        JTextField sgradeField = new JTextField();
        JButton addStudentBtn = new JButton("Add Student");
        JLabel addStudentMsg = new JLabel();
        addStudentPanel.add(new JLabel("Student ID:"));
        addStudentPanel.add(sidField);
        addStudentPanel.add(new JLabel("Name:"));
        addStudentPanel.add(snameField);
        addStudentPanel.add(new JLabel("Grade:"));
        addStudentPanel.add(sgradeField);
        addStudentPanel.add(new JLabel());
        addStudentPanel.add(addStudentBtn);
        addStudentPanel.add(addStudentMsg);

        addStudentBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(sidField.getText());
                String name = snameField.getText();
                int grade = Integer.parseInt(sgradeField.getText());
                Saifiya.getStudents().add(new Student(id, name, grade));
                addStudentMsg.setText("Student added!");
            } catch (Exception ex) {
                addStudentMsg.setText("Invalid input.");
            }
        });

        // Teachers Panel
        JPanel teacherPanel = new JPanel(new BorderLayout());
        JTextArea teacherArea = new JTextArea(15, 50);
        teacherArea.setEditable(false);
        JButton refreshTeachers = new JButton("Refresh List");
        refreshTeachers.addActionListener(e -> teacherArea.setText(getTeacherList()));
        teacherPanel.add(new JScrollPane(teacherArea), BorderLayout.CENTER);
        teacherPanel.add(refreshTeachers, BorderLayout.SOUTH);

        // Add Teacher Panel
        JPanel addTeacherPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        JTextField tidField = new JTextField();
        JTextField tnameField = new JTextField();
        JTextField tsalaryField = new JTextField();
        JButton addTeacherBtn = new JButton("Add Teacher");
        JLabel addTeacherMsg = new JLabel();
        addTeacherPanel.add(new JLabel("Teacher ID:"));
        addTeacherPanel.add(tidField);
        addTeacherPanel.add(new JLabel("Name:"));
        addTeacherPanel.add(tnameField);
        addTeacherPanel.add(new JLabel("Salary:"));
        addTeacherPanel.add(tsalaryField);
        addTeacherPanel.add(new JLabel());
        addTeacherPanel.add(addTeacherBtn);
        addTeacherPanel.add(addTeacherMsg);

        addTeacherBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(tidField.getText());
                String name = tnameField.getText();
                int salary = Integer.parseInt(tsalaryField.getText());
                Saifiya.getTeachers().add(new Teacher(id, salary, name));
                addTeacherMsg.setText("Teacher added!");
            } catch (Exception ex) {
                addTeacherMsg.setText("Invalid input.");
            }
        });

        // Pay Fees Panel
        JPanel payFeesPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        JTextField paySidField = new JTextField();
        JTextField feeAmountField = new JTextField();
        JButton payFeesBtn = new JButton("Pay Fees");
        JLabel payFeesMsg = new JLabel();
        payFeesPanel.add(new JLabel("Student ID:"));
        payFeesPanel.add(paySidField);
        payFeesPanel.add(new JLabel("Fee Amount:"));
        payFeesPanel.add(feeAmountField);
        payFeesPanel.add(new JLabel());
        payFeesPanel.add(payFeesBtn);
        payFeesPanel.add(payFeesMsg);

        payFeesBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(paySidField.getText());
                int amount = Integer.parseInt(feeAmountField.getText());
                Student found = null;
                for (Student s : Saifiya.getStudents()) {
                    if (s.getId() == id) {
                        found = s;
                        break;
                    }
                }
                if (found != null) {
                    found.payfees(amount);
                    payFeesMsg.setText("Fees paid.");
                } else {
                    payFeesMsg.setText("Student not found.");
                }
            } catch (Exception ex) {
                payFeesMsg.setText("Invalid input.");
            }
        });

        // Pay Salary Panel
        JPanel paySalaryPanel = new JPanel(new GridLayout(5, 2, 5, 5));
        JTextField payTidField = new JTextField();
        JButton paySalaryBtn = new JButton("Pay Salary");
        JLabel paySalaryMsg = new JLabel();
        paySalaryPanel.add(new JLabel("Teacher ID:"));
        paySalaryPanel.add(payTidField);
        paySalaryPanel.add(new JLabel());
        paySalaryPanel.add(paySalaryBtn);
        paySalaryPanel.add(paySalaryMsg);

        paySalaryBtn.addActionListener(e -> {
            try {
                int id = Integer.parseInt(payTidField.getText());
                Teacher found = null;
                for (Teacher t : Saifiya.getTeachers()) {
                    if (t.getId() == id) {
                        found = t;
                        break;
                    }
                }
                if (found != null) {
                    found.receiveSalary(found.getSalary());
                    paySalaryMsg.setText("Salary paid to " + found.getName());
                } else {
                    paySalaryMsg.setText("Teacher not found.");
                }
            } catch (Exception ex) {
                paySalaryMsg.setText("Invalid input.");
            }
        });

        // Finances Panel
        JPanel financesPanel = new JPanel(new BorderLayout());
        JTextArea financesArea = new JTextArea(8, 50);
        financesArea.setEditable(false);
        JButton refreshFinances = new JButton("Refresh Finances");
        refreshFinances.addActionListener(e -> financesArea.setText(getFinances()));
        financesPanel.add(new JScrollPane(financesArea), BorderLayout.CENTER);
        financesPanel.add(refreshFinances, BorderLayout.SOUTH);

        // Add tabs
        tabs.addTab("Students", studentPanel);
        tabs.addTab("Add Student", addStudentPanel);
        tabs.addTab("Teachers", teacherPanel);
        tabs.addTab("Add Teacher", addTeacherPanel);
        tabs.addTab("Pay Fees", payFeesPanel);
        tabs.addTab("Pay Salary", paySalaryPanel);
        tabs.addTab("Finances", financesPanel);

        frame.add(tabs);
        frame.setVisible(true);
    }

    private static String getStudentList() {
        StringBuilder sb = new StringBuilder();
        for (Student s : Saifiya.getStudents()) {
            sb.append(s).append(", Remaining Fees: ").append(s.getRemainingFees()).append("\n");
        }
        return sb.toString();
    }

    private static String getTeacherList() {
        StringBuilder sb = new StringBuilder();
        for (Teacher t : Saifiya.getTeachers()) {
            sb.append(t).append("\n");
        }
        return sb.toString();
    }

    private static String getFinances() {
        return "Total Money Earned: " + Saifiya.getTotalMoneyEarned() + "\n"
                + "Total Money Spent: " + Saifiya.getTotalMoneySpent() + "\n"
                + "Net Balance: " + (Saifiya.getTotalMoneyEarned() - Saifiya.getTotalMoneySpent());
    }
}