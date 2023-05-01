package com.eap.ge5;

import java.util.Random;

public class Student extends Human implements IGrade{
    private String email;
    private String department;
    private float average;

    public void setAverage(float average) {
        this.average = average;
    }

    public float getAverage() {
        return average;
    }

    // constructor
    public Student(String amka, String fullName, String email, String department) {
        super(amka, fullName);
        this.email = email;
        this.department = department;
    }

    @Override // επιστρέφει 1 τυχαίο αριθμό 0-10
    public float showAverage() {
        Random r = new Random();
        return r.nextFloat(10);
    }

    @Override //εκτυπώνει μορφοποιημένο το μέσο όρο
    public String toString() {
        return String.format("%.1f", average);
    }
}
