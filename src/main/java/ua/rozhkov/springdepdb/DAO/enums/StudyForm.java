package ua.rozhkov.springdepdb.DAO.enums;

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
