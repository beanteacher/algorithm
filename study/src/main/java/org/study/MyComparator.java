package org.study;

import java.util.Comparator;

public class MyComparator {
    static class Student implements Comparator<Student> {
        int age;
        int classNumber;

        Student(int age, int classNumber) {
            this.age = age;
            this.classNumber = classNumber;
        }
        @Override
        public int compare(Student o1, Student o2) {
            // 비교 구현
            return o1.age - o2.age;
        }
    }

    public static void main(String[] args) {
        Student studentA = new Student(17, 2); // 17살 2반
        Student studentB = new Student(18, 1); // 18살 1반
        Student studentC = new Student(15, 3); // 15살 3반

        studentA.compare(studentA, studentB);
        studentA.compare(studentB, studentC);
        studentA.compare(studentC, studentA);
    }
}
