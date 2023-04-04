package models;

public class Dealer {

    private String name;
    private Roles role = Roles.ADMIN;

    public Dealer() {
    }

    public Dealer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
