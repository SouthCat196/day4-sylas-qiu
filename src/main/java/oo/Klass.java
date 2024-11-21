package oo;

import oo.subject.ClassLeaderSubject;

import java.util.Objects;

public class Klass extends ClassLeaderSubject {

    private Integer number;

    private Student assignLeader;

    public Klass(Integer number) {
        this.number = number;
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
        if (student.isIn(this)) {
            this.assignLeader = student;
            noticeAllObserver(this);
        } else {
            System.out.print("It is not one of us.");
        }
    }

    public Student getAssignLeader() {
        return assignLeader;
    }

}
