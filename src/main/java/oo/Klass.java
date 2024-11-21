package oo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Klass {

    private Integer number;

    private Student assignLeader;

    private List<Person> klassMembers;

    public Klass(Integer number) {
        this.number = number;
        this.klassMembers = new ArrayList<>();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Klass klass = (Klass) o;
        return Objects.equals(number, klass.number);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(number);
    }

    @Override
    public String toString() {
        return String.valueOf(number);
    }

    public boolean isLeader(Student student) {
        return assignLeader == student;
    }

    public void assignLeader(Student student) {
        if(student.isIn(this)){
            this.assignLeader = student;
            klassMembers.stream()
                    .forEach(member -> member.noticeKlassLeaderUpdate(this));
        }else {
            System.out.print("It is not one of us.");
        }
    }

    public void attach(Person member) {
        klassMembers.add(member);
    }

    public Student getAssignLeader() {
        return assignLeader;
    }

}
