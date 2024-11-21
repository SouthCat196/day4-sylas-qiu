package oo;

public class Student extends Person {

    private Klass klass;

    public Student(Integer id, String name, Integer age) {
        super(id, name, age);
    }

    @Override
    public String introduce() {
        return super.introduce() + " I am a student.";
    }

    public boolean isIn(Klass klass){
        return this.klass == klass;
    }
}
