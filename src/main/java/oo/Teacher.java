package oo;

import java.util.ArrayList;
import java.util.List;

public class Teacher extends Person {

    private List<Klass> klasses;

    public Teacher(Integer id, String name, Integer age) {
        super(id, name, age);
        klasses = new ArrayList<>();
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a teacher.";
    }

    public boolean belongsTo(Klass klass) {
        return klasses.stream()
                .anyMatch(teachingKlass -> teachingKlass == klass);
    }
}
