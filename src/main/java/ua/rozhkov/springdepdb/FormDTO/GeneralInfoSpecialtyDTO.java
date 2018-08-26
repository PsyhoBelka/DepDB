package ua.rozhkov.springdepdb.FormDTO;

import ua.rozhkov.springdepdb.DAO.entity.Specialty;
import ua.rozhkov.springdepdb.DAO.entity.SpecialtyDetail;
import ua.rozhkov.springdepdb.DAO.enums.Base;
import ua.rozhkov.springdepdb.DAO.enums.StudyForm;

import java.util.HashMap;
import java.util.Map;

public class GeneralInfoSpecialtyDTO {
    private Specialty specialty;

    private Map<Base, Integer> licenseCapacityDay = new HashMap<>();
    private Map<Base, Integer> realCapacityDay = new HashMap<>();
    private Map<Base, Integer> regionOrderDay = new HashMap<>();
    private Map<Base, Integer> graduatedDay = new HashMap<>();

    private Map<Base, Integer> licenseCapacityEx = new HashMap<>();
    private Map<Base, Integer> realCapacityEx = new HashMap<>();
    private Map<Base, Integer> regionOrderEx = new HashMap<>();
    private Map<Base, Integer> graduatedEx = new HashMap<>();

    private int licenseCapacitySum;
    private int regionOrderSum;
    private int realCapacitySum;
    private int graduatedSum;


    public GeneralInfoSpecialtyDTO(Specialty specialty) {
        this.specialty = specialty;
        for (SpecialtyDetail specialtyDetail :
                this.specialty.getSpecialtyDetails()) {
            licenseCapacitySum += specialtyDetail.getLicenseCapacity();
            realCapacitySum += specialtyDetail.getRealCapacity();
            regionOrderSum += specialtyDetail.getRegionOrder();
            graduatedSum += specialtyDetail.getGraduated();
            processBase(specialtyDetail);
        }
    }

    public String getName(Specialty specialty) {
        return specialty.getName();
    }

    public void processBase(SpecialtyDetail specialtyDetail) {
        if (specialtyDetail.getBase() == Base.NINE_CLASS) {
            if (specialtyDetail.getStudyForm() == StudyForm.DAYTIME) {
                licenseCapacityDay.put(Base.NINE_CLASS, specialtyDetail.getLicenseCapacity());
                realCapacityDay.put(Base.NINE_CLASS, specialtyDetail.getRealCapacity());
                regionOrderDay.put(Base.NINE_CLASS, specialtyDetail.getRegionOrder());
                graduatedDay.put(Base.NINE_CLASS, specialtyDetail.getGraduated());
            } else {
                licenseCapacityEx.put(Base.NINE_CLASS, specialtyDetail.getLicenseCapacity());
                realCapacityEx.put(Base.NINE_CLASS, specialtyDetail.getRealCapacity());
                regionOrderEx.put(Base.NINE_CLASS, specialtyDetail.getRegionOrder());
                graduatedEx.put(Base.NINE_CLASS, specialtyDetail.getGraduated());
            }
        } else if (specialtyDetail.getBase() == Base.ELEV_CLASS) {
            if (specialtyDetail.getStudyForm() == StudyForm.DAYTIME) {
                licenseCapacityDay.put(Base.ELEV_CLASS, specialtyDetail.getLicenseCapacity());
                realCapacityDay.put(Base.ELEV_CLASS, specialtyDetail.getRealCapacity());
                regionOrderDay.put(Base.ELEV_CLASS, specialtyDetail.getRegionOrder());
                graduatedDay.put(Base.ELEV_CLASS, specialtyDetail.getGraduated());
            } else {
                licenseCapacityEx.put(Base.ELEV_CLASS, specialtyDetail.getLicenseCapacity());
                realCapacityEx.put(Base.ELEV_CLASS, specialtyDetail.getRealCapacity());
                regionOrderEx.put(Base.ELEV_CLASS, specialtyDetail.getRegionOrder());
                graduatedEx.put(Base.ELEV_CLASS, specialtyDetail.getGraduated());
            }
        } else {
            if (specialtyDetail.getStudyForm() == StudyForm.DAYTIME) {
                licenseCapacityDay.put(Base.KVAL_ROB, specialtyDetail.getLicenseCapacity());
                realCapacityDay.put(Base.KVAL_ROB, specialtyDetail.getRealCapacity());
                regionOrderDay.put(Base.KVAL_ROB, specialtyDetail.getRegionOrder());
                graduatedDay.put(Base.KVAL_ROB, specialtyDetail.getGraduated());
            } else {
                licenseCapacityEx.put(Base.KVAL_ROB, specialtyDetail.getLicenseCapacity());
                realCapacityEx.put(Base.KVAL_ROB, specialtyDetail.getRealCapacity());
                regionOrderEx.put(Base.KVAL_ROB, specialtyDetail.getRegionOrder());
                graduatedEx.put(Base.KVAL_ROB, specialtyDetail.getGraduated());
            }
        }
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public Map<Base, Integer> getLicenseCapacityDay() {
        return licenseCapacityDay;
    }

    public void setLicenseCapacityDay(Map<Base, Integer> licenseCapacityDay) {
        this.licenseCapacityDay = licenseCapacityDay;
    }

    public Map<Base, Integer> getRealCapacityDay() {
        return realCapacityDay;
    }

    public void setRealCapacityDay(Map<Base, Integer> realCapacityDay) {
        this.realCapacityDay = realCapacityDay;
    }

    public Map<Base, Integer> getRegionOrderDay() {
        return regionOrderDay;
    }

    public void setRegionOrderDay(Map<Base, Integer> regionOrderDay) {
        this.regionOrderDay = regionOrderDay;
    }

    public Map<Base, Integer> getGraduatedDay() {
        return graduatedDay;
    }

    public void setGraduatedDay(Map<Base, Integer> graduatedDay) {
        this.graduatedDay = graduatedDay;
    }

    public Map<Base, Integer> getLicenseCapacityEx() {
        return licenseCapacityEx;
    }

    public void setLicenseCapacityEx(Map<Base, Integer> licenseCapacityEx) {
        this.licenseCapacityEx = licenseCapacityEx;
    }

    public Map<Base, Integer> getRealCapacityEx() {
        return realCapacityEx;
    }

    public void setRealCapacityEx(Map<Base, Integer> realCapacityEx) {
        this.realCapacityEx = realCapacityEx;
    }

    public Map<Base, Integer> getRegionOrderEx() {
        return regionOrderEx;
    }

    public void setRegionOrderEx(Map<Base, Integer> regionOrderEx) {
        this.regionOrderEx = regionOrderEx;
    }

    public Map<Base, Integer> getGraduatedEx() {
        return graduatedEx;
    }

    public void setGraduatedEx(Map<Base, Integer> graduatedEx) {
        this.graduatedEx = graduatedEx;
    }

    public int getLicenseCapacitySum() {
        return licenseCapacitySum;
    }

    public void setLicenseCapacitySum(int licenseCapacitySum) {
        this.licenseCapacitySum = licenseCapacitySum;
    }

    public int getRegionOrderSum() {
        return regionOrderSum;
    }

    public void setRegionOrderSum(int regionOrderSum) {
        this.regionOrderSum = regionOrderSum;
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

    /*  public List<SpecialtyDetail> getDay(List<SpecialtyDetail> specialtyDetailsBase) {
        for (SpecialtyDetail specialtyDetail :
                specialtyDetailsBase) {
            if (specialtyDetail.getStudyForm() == StudyForm.DAYTIME) {
                day.add(specialtyDetail);
            }
        }
        return day;
    }

    public List<SpecialtyDetail> getEx(List<SpecialtyDetail> specialtyDetailsBase) {
        for (SpecialtyDetail specialtyDetail :
                specialtyDetailsBase) {
            if (specialtyDetail.getStudyForm() == StudyForm.EXTRA) {
                ex.add(specialtyDetail);
            }
        }
        return ex;
    }*/

}
