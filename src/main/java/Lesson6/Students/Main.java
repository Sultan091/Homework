package Lesson6.Students;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Set<Student> students = new HashSet<>();

        students.add(new Student("Иван", "A1", 1, Arrays.asList(4, 5, 3)));
        students.add(new Student("Петр", "A1", 1, Arrays.asList(2, 2, 3)));
        students.add(new Student("Мария", "B1", 2, Arrays.asList(5, 5, 4)));
        students.add(new Student("Олег", "B1", 2, Arrays.asList(2, 3, 2)));

        System.out.println("До удаления:");
        StudentService.printStudents(students, 1);

        StudentService.removeBadStudents(students);

        System.out.println("\nПосле удаления:");
        StudentService.printStudents(students, 1);

        StudentService.promoteStudents(students);

        System.out.println("\nПосле перевода на следующий курс:");
        StudentService.printStudents(students, 2);
    }
}
