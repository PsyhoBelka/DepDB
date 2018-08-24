package ua.rozhkov.springdepdb.FormDTO;

import ua.rozhkov.springdepdb.DAO.entity.College;

import java.util.LinkedList;
import java.util.List;

public class PeriodFormDTO {
    private Long id;
    private String name;
    private String[] selectedColleges;
    private List<College> colleges=new LinkedList<>();

    public PeriodFormDTO() {
    }

    public PeriodFormDTO(String name, List<College> colleges) {
        this.name = name;
        this.colleges = colleges;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSelectedColleges() {
        return selectedColleges;
    }

    public void setSelectedColleges(String[] selectedColleges) {
        this.selectedColleges = selectedColleges;
    }

    public List<College> getColleges() {
        return colleges;
    }

    public void setColleges(List<College> colleges) {
        this.colleges = colleges;
    }
}
