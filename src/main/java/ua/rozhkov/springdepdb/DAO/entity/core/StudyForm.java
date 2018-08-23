package ua.rozhkov.springdepdb.DAO.entity.core;

public enum StudyForm {
    DAYTIME("ЗАОЧНА"),
    EXTRA("ДЕННА");


    private String string;

    private StudyForm(String s) {
        string = s;
    }

    public String getString() {
        return string;
    }
}
