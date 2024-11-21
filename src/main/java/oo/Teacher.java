package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person implements ClassLeaderChangeObserver {

    public static final String DELIMITER = ", ";
    public static final String TEACHER_INFO = " I am a teacher.";
    public static final String CLASS_INFO_PREFIX = " I teach Class ";
    public static final String DOT = ".";
    private List<Klass> klasses;

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
        klasses = new ArrayList<>();
    }

    @Override
    public String introduce() {
        return super.introduce()
                .concat(TEACHER_INFO)
                .concat(getKlassesInfo());
    }

    private String getKlassesInfo() {
        return klasses == null || klasses.isEmpty()
                ? ""
                : klasses.stream()
                .map(Klass::toString)
                .collect(Collectors.joining(DELIMITER, CLASS_INFO_PREFIX, DOT));
    }

    public boolean belongsTo(Klass klass) {
        return klasses.stream()
                .anyMatch(teachingKlass -> teachingKlass == klass);
    }

    public void assignTo(Klass klass) {
        this.klasses.add(klass);
    }

    public boolean isTeaching(Student student) {
        return klasses.stream()
                .anyMatch(klass -> student.isIn(klass));
    }

    @Override
    public void noticeKlassLeaderUpdate(Klass klass) {
        System.out.println(String.format("I am %s, teacher of Class %s. I know %s become Leader.", getName(), klass, klass.getAssignLeader().getName()));
    }
}
