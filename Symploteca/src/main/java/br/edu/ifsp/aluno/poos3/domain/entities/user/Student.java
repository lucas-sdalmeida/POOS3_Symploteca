package br.edu.ifsp.aluno.poos3.domain.entities.user;

public class Student extends User{
    private String course;

    public Student() {
        super();
    }

    public Student(String institutionalId, String name, String email, String phone,
                   String course) {
        super(institutionalId, 0, name, email, phone);
        this.course = course;
    }

    public Student(String institutionalId, Integer numberOfCheckedOutBooks,
                   String name, String email, String phone, String course) {
        super(institutionalId, numberOfCheckedOutBooks, name, email, phone);
        this.course = course;
    }

    @Override
    public int getLimitOfBooksToCheckOut() {
        return 3;
    }

    @Override
    public int getCheckOutTimeLimitInDays() {
        return 7;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student{" +
                "course='" + course + '\'' +
                "} => " + super.toString();
    }
}
