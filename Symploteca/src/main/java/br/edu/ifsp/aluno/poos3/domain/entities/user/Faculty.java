package br.edu.ifsp.aluno.poos3.domain.entities.user;

public class Faculty extends User {
    private String department;

    public Faculty() {
    }

    public Faculty(String institutionalId, String name, String email, String phone, String department) {
        super(institutionalId, 0, name, email, phone);
        this.department = department;
    }

    public Faculty(String institutionalId, Integer numberOfCheckedOutBooks,
                   String name, String email, String phone, String department) {
        super(institutionalId, numberOfCheckedOutBooks, name, email, phone);
        this.department = department;
    }

    @Override
    public int getLimitOfBooksToCheckOut() {
        return 5;
    }

    @Override
    public int getCheckOutTimeLimitInDays() {
        return 30;
    }

    @Override
    public String toString() {
        return "Faculty{" +
                "department='" + department + '\'' +
                "} => " + super.toString();
    }
}
