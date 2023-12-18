package com.assignment.unit1;

import java.util.Scanner;

public class Student implements IStudent{
    private String id;
    private String firstName;
    private String lastName;
    private boolean gender;

    public Student() {
    }

    public Student(String id, String firstName, String lastName, boolean gender) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        gender = gender;
    }

    @Override
    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập vào ID:");
        id = sc.nextLine();
        System.out.println("Nhập vào Họ:");
        firstName = sc.nextLine();
        System.out.println("Nhập vào Tên:");
        lastName = sc.nextLine();
        System.out.println("Nhập vào giới tính:");
        gender = Boolean.parseBoolean(sc.nextLine());
    }

    @Override
    public void output() {
        System.out.printf("%s %s | Giới tính: %s\n",firstName,lastName,gender?"Nam":"Nữ");
    }
}
