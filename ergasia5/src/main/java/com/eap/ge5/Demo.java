package com.eap.ge5;

/**
 * @author Vasilis Stamatis
 * PLI24 ergasia 5
 */

import java.util.ArrayList;
import java.util.List;

public class Demo {
    private static final List<IGrade> gradedStudents = new ArrayList<>();
    private static final List<IGrade> studentsWhoPass = new ArrayList<>();
    private static final List<IGrade> studentsWhoFail = new ArrayList<>();

    public static void main(String[] args) {
        // δημιουργεί τους μαθητές
        Student s1 = new Student("123456789", "Luke Skywalker", "luke@gmail.com", "Jedi");
        Student s2 = new Student("987654321", "Han Solo", "han@gmail.com", "Jedi");
        Student s3 = new Student("789456123", "Darth Vader", "darth@gmail.com", "Sith");
        Student s4 = new Student("321654987", "Master Yoda", "yoda@gmail.com", "Jedi");
        Student s5 = new Student("159753258", "Obi-Wan Kenobi", "obi@gmail.com", "Jedi");

        // δίνει στους μαθητές 1 τυχαίο μέσο όρο και τους προσθέτει στη λίστα
        s1.setAverage(s1.showAverage());
        addToList(s1);
        s2.setAverage(s2.showAverage());
        addToList(s2);
        s3.setAverage(s3.showAverage());
        addToList(s3);
        s4.setAverage(s4.showAverage());
        addToList(s4);
        s5.setAverage(s5.showAverage());
        addToList(s5);


        // φιλτράρει τη λίστα
        filterList(gradedStudents);

        // εκτυπώνει τους μέσους όρους
        System.out.println("Οι μέσοι όροι που είναι ίσοι ή μεγαλύτεροι του 5 είναι "+studentsWhoPass.size()+" και είναι οι παρακάτω:");
        System.out.println(studentsWhoPass);
        System.out.println("Οι μέσοι όροι που είναι μικρότεροι του 5 είναι "+studentsWhoFail.size()+ " και είναι οι παρακάτω:");
        System.out.println(studentsWhoFail);

    }


    // προσθέτει ένα αντικείμενο στη λίστα gradedStudents
    private static void addToList(IGrade graded){
        gradedStudents.add(graded);
    }

    // φοιτητές με μέσο όρο ίσο ή πάνω από 5 μπαίνουν στη λίστα studentsWhoPass αλλιώς στη studentsWhoFail
    private static void filterList(List<IGrade> gradedStudents){
        for (IGrade s: gradedStudents){
            Student student = (Student) s;
            if (student.getAverage() >= 5)
                studentsWhoPass.add(s);
            else studentsWhoFail.add(s);
        }
    }
}
