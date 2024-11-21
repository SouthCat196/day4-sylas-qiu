package oo.step7;

import oo.School;
import oo.Student;
import oo.Teacher;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;

public class SchoolTest {

    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setup() {
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void should_print_message_when_start_school_given_teacher_is_in_the_school() {
        Teacher teacher = new Teacher(1, "Tom", 21);
        School school = new School();
        school.attach(teacher);

        school.startSchool();

        assertThat(systemOut()).contains("My name is Tom. I am 21 years old. I am a teacher.");
    }

    @Test
    void should_print_message_when_start_school_given_student_is_in_the_school() {
        Student student = new Student(1, "Sylas", 16);
        School school = new School();
        school.attach(student);

        school.startSchool();

        assertThat(systemOut()).contains("My name is Sylas. I am 16 years old. I am a student.");
    }

    @Test
    void should_print_message_when_start_school_given_student_and_teacher_is_in_the_school() {
        School school = new School();
        Student student = new Student(1, "Sylas", 16);
        Teacher teacher = new Teacher(1, "Tom", 21);
        school.attach(student);
        school.attach(teacher);

        school.startSchool();

        assertThat(systemOut()).contains("My name is Sylas. I am 16 years old. I am a student.");
        assertThat(systemOut()).contains("My name is Tom. I am 21 years old. I am a teacher.");
    }

    private String systemOut() {
        return outContent.toString();
    }
}
