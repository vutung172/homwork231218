package com.assignment.unit1;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Student> lists = new ArrayList<>();

        do {
            String select;
            //Sử dụng List
            do {
                Student st = new Student();
                st.input();
                lists.add(st);
                System.out.println("Bạn có muốn tiếp tục(Y/N)");
                select = sc.nextLine();
            } while (select.equalsIgnoreCase("Y"));

            /*//Sử dụng Set
            SortedSet<String> firstNameLists = new TreeSet<>();
            for (Student student: lists) {
                firstNameLists.add(student.getFirstName());
            }
            for (String s: firstNameLists){
                System.out.println(s);
                for (Student student1:lists
                     ) {
                    checkFirstName(student1,s);
                }
            }*/

            // Dùng Map
            Map<String,List<Student>> firstName = new HashMap<>();

            lists.forEach(student -> {
                String key = student.getFirstName();
                List<Student> sameFirstNames = new ArrayList<>();
                lists.forEach(student1 -> {
                    if (student1.getFirstName().equals(key)){
                       sameFirstNames.add(student1);
                    }
                });
                firstName.put(key,sameFirstNames);
            });
            firstName.forEach((x,y) -> {
                System.out.println(x);
                y.forEach(Student::output);
            });

        }while (true);

    }
    /*public static void checkFirstName(Student st, String firstName){
        if (st.getFirstName().contains(firstName)){
            st.output();
        }
    }*/
}
