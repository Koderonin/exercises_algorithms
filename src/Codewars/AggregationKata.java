package Codewars;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.List;

/*
* Java 8 has introduced a sexy new Stream API which makes it possible to solve some data related problems in just a few lines of code. Let's try it out!
* You have a Student class (see the class declaration below).
* You have an array of students, and you want to get some aggregate data.
*
* THE TASK: get the average grade for every department.
* Implement the method using Java 8 Stream API.
*/

public class AggregationKata {

    public static Map<String, Double> getAverageGradeByDepartment(Stream<Student> students) {
        // La clase Collectors tiene métodos para trabajar con colecciones de datos.
        // En este caso, queremos tomar los valores de una propiedad compartida por cada instancia del objeto, y calcular el promedio de sus valores
        // Por eso, usamos sus métodos groupingBy() (para decir cuál es el atributo por el que queremos agrupar), y el metodo averagingDouble() (para calcular el promedio).
        // El resultado es un Map<String, Double>, y si no hubiéramos añadido el segundo parámetro, nos devolvería un Map<String, List<Student>>.
        return students.collect(Collectors.groupingBy(student -> student.getDepartment(), Collectors.averagingDouble(student -> student.getGrade())));
    }
/*
* THE TASK: get the number of students in each department.
* Implement the method using Java 8 Stream API.
*/
    public static Map<String, Long> getNumberOfStudentsByDepartment(Stream<Student> students) {

        return students.collect(Collectors.groupingBy(student -> student.getDepartment(), Collectors.counting()));
    }

/*
* Éste me lo ha carreao la API de Java:
* The mapping() collectors are most useful when used in a multi-level reduction, such as downstream of a groupingBy or partitioningBy.
* For example, given a stream of Person, to accumulate the set of last names in each city:
*    Map<City, Set<String>> lastNamesByCity
*        = people.stream().collect(groupingBy(Person::getCity, mapping(Person::getLastName, toSet())));
*
*  */
    public static Map<String, List<String>> getStudentNamesByDepartment(Stream<Student> students) {

        return students.collect(Collectors.groupingBy(Student::getDepartment, Collectors.mapping(Student::getName, Collectors.toList())));
    }

    public static Map<String, Map<Student.Gender, Long>> getTheNumberOfStudentsByGenderForEachDepartment(Stream<Student> students) {

        return students.collect(Collectors.groupingBy(Student::getDepartment, Collectors.groupingBy(Student::getGender, Collectors.counting())));
    }

    /*Clase Student*/

    public static class Student {
        private String name;
        private double grade;
        private String department;
        private Gender gender;

        public static final double PASSING_GRADE = 70.0;

        public enum Gender {
            MALE, FEMALE
        }

        public Student(String name, double grade, String department, Gender gender) {
            this.name = name;
            this.grade = grade;
            this.department = department;
            this.gender = gender;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getGrade() {
            return grade;
        }

        public void setGrade(double grade) {
            this.grade = grade;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public Gender getGender() {
            return gender;
        }

        public void setGender(Gender gender) {
            this.gender = gender;
        }
    }

}
