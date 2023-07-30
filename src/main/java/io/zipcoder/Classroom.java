package io.zipcoder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Classroom {
    private Student[] students;
    @@ -20,7 +22,31 @@ public Classroom(Student[] students){
        //Getters Setters and fun stuff beyond this point

        public Student[] getStudents() {
            return students;
            return this.students;
        }
        public void getGradeBook(){
            this.students = getStudentsByScore();
            double percentile = 0.0;
            double length = students.length;
            for (int i = 0; i < students.length; i++){
                percentile = ((length-i)/length) * 100.0;
                if(percentile>=90.0){
                    System.out.println(students[i].getFirstName() + " " + students[i].getLastName() + " has received an A");

                } else if (percentile<=89.9 && percentile>=70.1) {
                    System.out.println(students[i].getFirstName() + " " + students[i].getLastName() + " has received an B");

                }
                else if (percentile<=70 && percentile>= 50) {
                    System.out.println(students[i].getFirstName() + " " + students[i].getLastName() + " has received an C");
                }
                else if (percentile <= 49.9 && percentile>= 11) {
                    System.out.println(students[i].getFirstName() + " " + students[i].getLastName() + " has received an D");
                }
                else if(percentile<= 10.9) {
                    System.out.println(students[i].getFirstName() + " " + students[i].getLastName() + " has received an F");
                }
            }
        }
        public double getAverageExamScore(){
            @@ -65,33 +91,50 @@ public void removeStudent(String firstName, String lastName){
                students = hold;

            }

            public Student[] getStudentsByScore(){
                Student[] newStudents = new Student[students.length];
                for(int x = 0; x < students.length; x++) {
                    for (int i = 0; i < students.length - 1; i++) {
                        if (students[i].getAverageExamScore() < students[i + 1].getAverageExamScore()) {
                            newStudents[0] = students[i];
                            students[i] = students[i + 1];
                            students[i + 1] = newStudents[0];
                        }
                    }
                }
                return students;
            }
            public static void main(String[] args) {
                // : Given
                int maxNumberOfStudents = 4;
                Classroom classroom = new Classroom(maxNumberOfStudents);
                Double[] examScores = { 100.0, 150.0, 250.0, 0.0 };
                Double[] examScores1 = { 100.0, 150.0, 250.0, 10.0 };
                Double[] examScores2 = { 100.0, 150.0, 250.0, 100.0 };
                Double[] examScores3 = { 100.0, 150.0, 250.0, 1000.0 };
                Student student = new Student("Leon", "Hunter", examScores);
                Student student1 = new Student("James", "Jimmithy", examScores);
                Student student2 = new Student("Jame", "JimJim", examScores);
                Student student3 = new Student("Jay", "Jibs", examScores);
                Student student1 = new Student("James", "Jimmithy", examScores1);
                Student student2 = new Student("Jame", "JimJim", examScores2);
                Student student3 = new Student("Jay", "Jibs", examScores3);

                // When
                classroom.addStudent(student);
                classroom.addStudent(student1);
                classroom.addStudent(student2);
                classroom.addStudent(student3);
                Student[] preEnrollment = classroom.getStudents();
                classroom.removeStudent("James", "Jimmithy");
                Student[] postEnrollment = classroom.getStudents();
//        Student[] preEnrollment = classroom.getStudents();
//        Student[] postEnrollment = classroom.getStudentsByScore();

                // Then
                String preEnrollmentAsString = Arrays.toString(preEnrollment);
                String postEnrollmentAsString = Arrays.toString(postEnrollment);
//        String preEnrollmentAsString = Arrays.toString(preEnrollment);
//        String postEnrollmentAsString = Arrays.toString(postEnrollment);

                System.out.println("===========================");
                System.out.println(preEnrollmentAsString);
                System.out.println("===========================");
                System.out.println(postEnrollmentAsString);
//        System.out.println("===========================");
//        System.out.println(preEnrollmentAsString);
//        System.out.println("===========================");
//        System.out.println(postEnrollmentAsString);
                classroom.getGradeBook();
            }

        }
