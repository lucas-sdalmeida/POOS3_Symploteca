package br.edu.ifsp.aluno.poos3.domain.entities.user;

public abstract class User {
    private String institutionalId;
    private Integer numberOfCheckedOutBooks;
    private String name;
    private String email;
    private String phone;

    public User() {
    }

    public User(String institutionalId, Integer numberOfCheckedOutBooks,
                String name, String email, String phone) {
        this.institutionalId = institutionalId;
        this.numberOfCheckedOutBooks = numberOfCheckedOutBooks;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }

    public abstract int getLimitOfBooksToCheckOut();

    public abstract int getCheckOutTimeLimitInDays();

    public boolean isAbleToCheckOut() {
        return numberOfCheckedOutBooks < getNumberOfCheckedOutBooks();
    }

    public void increaseNumberOfCheckedOutBooks() {
        if (!isAbleToCheckOut())
            throw new IllegalNumberOfCheckedOutBooks("User cannot check out any other book!");
        numberOfCheckedOutBooks++;
    }

    public void decreaseNumberOfCheckedOutBooks() {
        if (numberOfCheckedOutBooks <= 0)
            throw new IllegalNumberOfCheckedOutBooks("User has not checked out any book!");
        numberOfCheckedOutBooks--;
    }

    public String getInstitutionalId() {
        return institutionalId;
    }

    public void setInstitutionalId(String institutionalId) {
        this.institutionalId = institutionalId;
    }

    public Integer getNumberOfCheckedOutBooks() {
        return numberOfCheckedOutBooks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "User{" +
                "institutionalId='" + institutionalId + '\'' +
                ", numberOfCheckedOutBooks=" + numberOfCheckedOutBooks +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
