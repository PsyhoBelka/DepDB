package ua.rozhkov.springdepdb.FormDTO.college;

import ua.rozhkov.springdepdb.DAO.entity.OwnerShip;
import ua.rozhkov.springdepdb.DAO.entity.Specialty;

import java.util.List;

public class AddCollegeForm {
    private String name;
    private String address;
    private String director;
    private String phone;
    private OwnerShip ownerShip;
    private String[] selectedSpecialties;
    private List<Specialty> specialties;

    public AddCollegeForm() {

    }

    public AddCollegeForm(String name, String address, String director, String phone, OwnerShip ownerShip) {
        this.name = name;
        this.address = address;
        this.director = director;
        this.phone = phone;
        this.ownerShip = ownerShip;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public OwnerShip getOwnerShip() {
        return ownerShip;
    }

    public void setOwnerShip(OwnerShip ownerShip) {
        this.ownerShip = ownerShip;
    }

    public String[] getSelectedSpecialties() {
        return selectedSpecialties;
    }

    public void setSelectedSpecialties(String[] selectedSpecialties) {
        this.selectedSpecialties = selectedSpecialties;
    }

    public List<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(List<Specialty> specialties) {
        this.specialties = specialties;
    }
}
