package fr.esgi.tp1601.domain;

public final class User {

    private final UserId id;
    private final String lastname;
    private final String firstname;
    private String password;

    public User(UserId id, String lastname, String firstname, String password) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.password = password;
    }

    public UserId getId() {
        return id;
    }

    public void changePassword(String newPassword) {
        this.password = newPassword;
    }

}
