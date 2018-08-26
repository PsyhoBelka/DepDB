package ua.rozhkov.springdepdb.FormDTO;

import ua.rozhkov.springdepdb.DAO.enums.Base;
import ua.rozhkov.springdepdb.DAO.enums.StudyForm;

import java.util.Arrays;
import java.util.List;

public class SpecialtyDetailFormDTO {
    private Long id;
    private Base base;
    private StudyForm studyForm;
    private int licenseCapacity;
    private int regionOrder;
    private int realCapacity;
    private int graduated;

    private Long specialtyId;
    private String selectedBase;
    private String selectedStudyForm;

    private List<Base> availableBases;
    private List<StudyForm> availableStudyForms;

    public SpecialtyDetailFormDTO() {
        availableBases = Arrays.asList(Base.values());
        availableStudyForms = Arrays.asList(StudyForm.values());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSpecialtyId() {
        return specialtyId;
    }

    public void setSpecialtyId(Long specialtyId) {
        this.specialtyId = specialtyId;
    }

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    public StudyForm getStudyForm() {
        return studyForm;
    }

    public void setStudyForm(StudyForm studyForm) {
        this.studyForm = studyForm;
    }

    public int getLicenseCapacity() {
        return licenseCapacity;
    }

    public void setLicenseCapacity(int licenseCapacity) {
        this.licenseCapacity = licenseCapacity;
    }

    public int getRealCapacity() {
        return realCapacity;
    }

    public void setRealCapacity(int realCapacity) {
        this.realCapacity = realCapacity;
    }

    public String getSelectedBase() {
        return selectedBase;
    }

    public void setSelectedBase(String selectedBase) {
        this.selectedBase = selectedBase;
    }

    public String getSelectedStudyForm() {
        return selectedStudyForm;
    }

    public void setSelectedStudyForm(String selectedStudyForm) {
        this.selectedStudyForm = selectedStudyForm;
    }

    public List<Base> getAvailableBases() {
        return availableBases;
    }

    public void setAvailableBases(List<Base> availableBases) {
        this.availableBases = availableBases;
    }

    public List<StudyForm> getAvailableStudyForms() {
        return availableStudyForms;
    }

    public void setAvailableStudyForms(List<StudyForm> availableStudyForms) {
        this.availableStudyForms = availableStudyForms;
    }

    public int getRegionOrder() {
        return regionOrder;
    }

    public void setRegionOrder(int regionOrder) {
        this.regionOrder = regionOrder;
    }

    public int getGraduated() {
        return graduated;
    }

    public void setGraduated(int graduated) {
        this.graduated = graduated;
    }
}
