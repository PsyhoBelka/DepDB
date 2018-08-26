package ua.rozhkov.springdepdb.DAO.entity;

import org.hibernate.annotations.GenericGenerator;
import ua.rozhkov.springdepdb.DAO.enums.Base;
import ua.rozhkov.springdepdb.DAO.enums.StudyForm;

import javax.persistence.*;

@Entity
@Table(name = "specialtydetails",
        indexes = {@Index(name = "base_form", columnList = "base, studyForm,specialty_id", unique = true)})
public class SpecialtyDetail {
    private Long id;
    private Base base;
    private StudyForm studyForm;
    private int licenseCapacity;
    private int realCapacity;
    private int regionOrder;
    private int graduated;

    public SpecialtyDetail() {
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "base")
    @Enumerated(EnumType.STRING)

    public Base getBase() {
        return base;
    }

    public void setBase(Base base) {
        this.base = base;
    }

    @Column(name = "studyform")
    @Enumerated(EnumType.STRING)
    public StudyForm getStudyForm() {
        return studyForm;
    }

    public void setStudyForm(StudyForm studyForm) {
        this.studyForm = studyForm;
    }

    @Column(name = "licensecapacity")
    public int getLicenseCapacity() {
        return licenseCapacity;
    }

    public void setLicenseCapacity(int licenseCapacity) {
        this.licenseCapacity = licenseCapacity;
    }

    @Column(name = "realcapacity")
    public int getRealCapacity() {
        return realCapacity;
    }

    public void setRealCapacity(int realCapacity) {
        this.realCapacity = realCapacity;
    }

    @Column(name = "regionOrder")
    public int getRegionOrder() {
        return regionOrder;
    }

    public void setRegionOrder(int regionOrder) {
        this.regionOrder = regionOrder;
    }

    @Column(name = "garduated")
    public int getGraduated() {
        return graduated;
    }

    public void setGraduated(int graduated) {
        this.graduated = graduated;
    }
}
