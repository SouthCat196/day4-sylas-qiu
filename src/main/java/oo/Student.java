package oo;

import oo.observer.ClassLeaderObserver;
import oo.observer.SchoolObserver;

public class Student extends Person implements ClassLeaderObserver, SchoolObserver {

    private Klass klass;

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return super.introduce()
                .concat(" I am a student.")
                .concat(getKlassInfo());
    }

    private String getKlassInfo() {
        return klass != null ? " I am in class " + klass + "." : "";
    }

    public boolean isIn(Klass klass) {
        return this.klass == klass;
    }

    public void join(Klass klass) {
        this.klass = klass;
    }

    @Override
    public void noticeKlassLeaderUpdate(Klass klass) {
        System.out.println(String.format("I am %s, student of Class %s. I know %s become Leader.", getName(), klass, klass.getAssignLeader().getName()));
    }

    @Override
    public void noticeSchoolStart() {
        System.out.println(introduce());
    }
}
