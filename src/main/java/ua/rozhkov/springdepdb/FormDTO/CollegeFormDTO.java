package ua.rozhkov.springdepdb.FormDTO;

import ua.rozhkov.springdepdb.DAO.entity.Specialty;
import ua.rozhkov.springdepdb.DAO.enums.OwnerShip;

import java.util.Arrays;
import java.util.List;

public class CollegeFormDTO {
    private Long id;
    private String name;
    private String address;
    private String director;
    private String phone;
    private String selectedOwnerShip;       //selected ownership
    private List<OwnerShip> ownerShips;     //all available ownerships
    private String[] selectedSpecialties;   //selected specialty
    private List<Specialty> specialties;    //all available specialties

    public CollegeFormDTO() {
        ownerShips = Arrays.asList(OwnerShip.values());
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

    public String getSelectedOwnerShip() {
        return selectedOwnerShip;
    }

    public void setSelectedOwnerShip(String selectedOwnerShip) {
        this.selectedOwnerShip = selectedOwnerShip;
    }

    public List<OwnerShip> getOwnerShips() {
        return ownerShips;
    }

    public void setOwnerShips(List<OwnerShip> ownerShips) {
        this.ownerShips = ownerShips;
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
