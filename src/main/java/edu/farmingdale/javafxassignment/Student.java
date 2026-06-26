package edu.farmingdale.javafxassignment;

public class Student {

    private int id;
    private String firstName;
    private String lastName;
    private String department;
    private String major;
    private String email;

    public Student(int id, String firstName, String lastName,
                   String department, String major, String email) {

        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.major = major;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public String getMajor() {
        return major;
    }

    public String getEmail() {
        return email;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}