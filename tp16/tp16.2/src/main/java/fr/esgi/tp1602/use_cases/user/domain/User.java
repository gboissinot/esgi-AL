package fr.esgi.tp1602.use_cases.user.domain;

import fr.esgi.tp1602.kernel.Entity;

public final class User implements Entity<UserId> {

    private final UserId id;
    private final String lastname;
    private final String firstname;
    private Address address;

    public User(UserId id, String lastname, String firstname, Address address) {
        this.id = id;
        this.lastname = lastname;
        this.firstname = firstname;
        this.address = address;
    }

    public UserId getId() {
        return id;
    }

    @Override
    public UserId id() {
        return id;
    }

    public void changeAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", lastname='" + lastname + '\'' +
                ", firstname='" + firstname + '\'' +
                ", address=" + address +
                '}';
    }
}
