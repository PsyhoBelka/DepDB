package ua.rozhkov.springdepdb.FormDTO;

import ua.rozhkov.springdepdb.DAO.entity.College;
import ua.rozhkov.springdepdb.DAO.entity.Specialty;

import java.util.ArrayList;
import java.util.List;

public class GeneralInfoDTO {
    private College selectedCollege;
    private List<Specialty> specialtiesInCollege = new ArrayList<>();

    private List<GeneralInfoSpecialtyDTO> generalInfoSpecialtyDTO = new ArrayList<>();

    private int licenseCapacitySum;
    private int regionOrderCapacitySum;
    private int realCapacitySum;
    private int graduatedSum;

    public GeneralInfoDTO(College selectedColege) {
        this.selectedCollege = selectedColege;
        this.specialtiesInCollege = selectedCollege.getSpecialties();
        for (Specialty specialty :
                specialtiesInCollege) {
            generalInfoSpecialtyDTO.add(new GeneralInfoSpecialtyDTO(specialty));
        }
        getSummary();
    }

    private void getSummary() {
        for (GeneralInfoSpecialtyDTO specInfo :
                generalInfoSpecialtyDTO) {
            licenseCapacitySum += specInfo.getLicenseCapacitySum();
            regionOrderCapacitySum += specInfo.getRegionOrderSum();
            realCapacitySum += specInfo.getRealCapacitySum();
            graduatedSum += specInfo.getGraduatedSum();
        }
    }

    public College getSelectedCollege() {
        return selectedCollege;
    }

    public void setSelectedCollege(College selectedCollege) {
        this.selectedCollege = selectedCollege;
    }

    public List<Specialty> getSpecialtiesInCollege() {
        return specialtiesInCollege;
    }

    public void setSpecialtiesInCollege(List<Specialty> specialtiesInCollege) {
        this.specialtiesInCollege = specialtiesInCollege;
    }

    public List<GeneralInfoSpecialtyDTO> getGeneralInfoSpecialtyDTO() {
        return generalInfoSpecialtyDTO;
    }

    public void setGeneralInfoSpecialtyDTO(List<GeneralInfoSpecialtyDTO> generalInfoSpecialtyDTO) {
        this.generalInfoSpecialtyDTO = generalInfoSpecialtyDTO;
    }

    public int getLicenseCapacitySum() {
        return licenseCapacitySum;
    }

    public void setLicenseCapacitySum(int licenseCapacitySum) {
        this.licenseCapacitySum = licenseCapacitySum;
    }

    public int getRegionOrderCapacitySum() {
        return regionOrderCapacitySum;
    }

    public void setRegionOrderCapacitySum(int regionOrderCapacitySum) {
        this.regionOrderCapacitySum = regionOrderCapacitySum;
    }

    public int getRealCapacitySum() {
        return realCapacitySum;
    }

    public void setRealCapacitySum(int realCapacitySum) {
        this.realCapacitySum = realCapacitySum;
    }

    public int getGraduatedSum() {
        return graduatedSum;
    }

    public void setGraduatedSum(int graduatedSum) {
        this.graduatedSum = graduatedSum;
    }
}
