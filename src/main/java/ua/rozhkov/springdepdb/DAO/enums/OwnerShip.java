package ua.rozhkov.springdepdb.DAO.enums;

public enum OwnerShip {
    COMMUN("ДЕРЖАВНА"),
    GOVEM("КОМУНАЛЬНА");


    private String string;

    private OwnerShip(String s) {
        string = s;
    }

    public String getString() {
        return string;
    }
}
