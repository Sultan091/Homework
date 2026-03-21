package Lesson6.Students;

import java.util.Iterator;
import java.util.Set;

public class StudentService {

    // Удаление студентов со средним баллом < 3
    public static void removeBadStudents(Set<Student> students) {
        Iterator<Student> iterator = students.iterator();

        while (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getAverage() < 3) {
                iterator.remove();
            }
        }
    }

    // Перевод на следующий курс
    public static void promoteStudents(Set<Student> students) {
        for (Student student : students) {
            if (student.getAverage() >= 3) {
                student.setCourse(student.getCourse() + 1);
            }
        }
    }

    // Вывод студентов по курсу
    public static void printStudents(Set<Student> students, int course) {
        for (Student student : students) {
            if (student.getCourse() == course) {
                System.out.println(student.getName());
            }
        }
    }
}