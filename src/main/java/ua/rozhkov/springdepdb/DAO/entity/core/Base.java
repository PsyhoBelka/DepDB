package ua.rozhkov.springdepdb.DAO.entity.core;

public enum Base {
    NINE_CLASS("9 клас"),
    ELEV_CLASS("11 клас"),
    KVAL_ORB("кваліфікований робітник");

    private String string;

    private Base(String s) {
        string = s;
    }

    public String getString() {
        return string;
    }
}
