package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Teacher extends Person implements ClassLeaderChangeObserver {

    public static final String DELIMITER = ", ";
    private List<Klass> klasses;

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
        klasses = new ArrayList<>();
    }

    @Override
    public String introduce() {
        return super.introduce()
                .concat(" I am a teacher.")
                .concat(String.format(" I teach Class %s.", getAllKlasses()));
    }

    private String getAllKlasses() {
        return klasses.stream()
                .map(klass -> klass.toString())
                .collect(Collectors.joining(DELIMITER));
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
