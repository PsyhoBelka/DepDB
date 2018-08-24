package ua.rozhkov.springdepdb.DAO.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "licenses")
public class LicenseCapacity {
    private Long id;
    private StudyForm studyForm;
    private int capacity;

    public LicenseCapacity() {
    }

    public LicenseCapacity(StudyForm studyForm, int capacity) {
        this.studyForm = studyForm;
        this.capacity = capacity;
    }

    @Id
    @Column(name = "license_id")
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "studyform")
    @Enumerated(EnumType.STRING)
    public StudyForm getStudyForm() {
        return studyForm;
    }

    public void setStudyForm(StudyForm studyForm) {
        this.studyForm = studyForm;
    }

    @Column(name = "capacity")
    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "LicenseCapacity{" +
                "studyForm=" + studyForm +
                ", capacity=" + capacity +
                '}';
    }
}
