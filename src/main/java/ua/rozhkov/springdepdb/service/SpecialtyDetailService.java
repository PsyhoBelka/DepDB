package ua.rozhkov.springdepdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.rozhkov.springdepdb.DAO.entity.College;
import ua.rozhkov.springdepdb.DAO.entity.Specialty;
import ua.rozhkov.springdepdb.DAO.entity.SpecialtyDetail;
import ua.rozhkov.springdepdb.DAO.enums.Base;
import ua.rozhkov.springdepdb.DAO.enums.StudyForm;
import ua.rozhkov.springdepdb.DAO.repository.SpecialtyDetailRepository;
import ua.rozhkov.springdepdb.FormDTO.GeneralInfoDTO;
import ua.rozhkov.springdepdb.FormDTO.SpecialtyDetailFormDTO;

import java.util.List;

@Service
public class SpecialtyDetailService implements BaseService<SpecialtyDetail, Long> {

    @Autowired
    private SpecialtyDetailRepository specialtyDetailRepository;
    @Autowired
    private SpecialtyService specialtyService;
    @Autowired
    private CollegeService collegeService;


    @Override
    public SpecialtyDetail findById(Long id) {
        return null;
    }

    @Override
    public List<SpecialtyDetail> findAll() {
        return null;
    }

    @Override
    public SpecialtyDetail findByName(String name) {
        return null;
    }

    @Override
    public SpecialtyDetail save(SpecialtyDetail specialtyDetail) {
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    public SpecialtyDetailFormDTO prepareSpecialtyDetailFormDTOToEdit(Specialty specialty) {
        SpecialtyDetailFormDTO specialtyDetailFormDTOToEdit = new SpecialtyDetailFormDTO();
        specialtyDetailFormDTOToEdit.setSpecialtyId(specialty.getId());
//        SpecialtyDetail specialtyDetail=specialty.
//        specialtyDetailFormDTOToEdit.setSelectedBase(specialty.ge);
        return null;
    }

    public SpecialtyDetailFormDTO prepareSpecialtyDetailFormDTOToAdd(Long idSpecialty) {
        SpecialtyDetailFormDTO specialtyDetailFormDTOToAdd = new SpecialtyDetailFormDTO();
        specialtyDetailFormDTOToAdd.setSpecialtyId(idSpecialty);
        return specialtyDetailFormDTOToAdd;
    }

    public SpecialtyDetail perfomSpecialtyDetailFormDTOToAdd(SpecialtyDetailFormDTO specialtyDetailFormDTOToAdd) {
        Specialty specialty = specialtyService.findById(specialtyDetailFormDTOToAdd.getSpecialtyId());
        SpecialtyDetail specialtyDetailToAdd = new SpecialtyDetail();
        specialtyDetailToAdd.setBase(Base.valueOf(specialtyDetailFormDTOToAdd.getSelectedBase()));
        specialtyDetailToAdd.setStudyForm(StudyForm.valueOf(specialtyDetailFormDTOToAdd.getSelectedStudyForm()));
        specialtyDetailToAdd.setLicenseCapacity(specialtyDetailFormDTOToAdd.getLicenseCapacity());
        specialtyDetailToAdd.setRegionOrder(specialtyDetailFormDTOToAdd.getLicenseCapacity());
        specialtyDetailToAdd.setRealCapacity(specialtyDetailFormDTOToAdd.getRealCapacity());
        specialtyDetailToAdd.setGraduated(specialtyDetailFormDTOToAdd.getGraduated());
        specialtyDetailToAdd.setRegionOrder(specialtyDetailFormDTOToAdd.getLicenseCapacity());
        specialty.getSpecialtyDetails().add(specialtyDetailToAdd);
        specialtyService.save(specialty);
        return specialtyDetailToAdd;
    }

    public GeneralInfoDTO prepareGeneralInfoDTOToList(Long selectedCollegeId) {
        College selectedCollege = collegeService.findById(selectedCollegeId);
        GeneralInfoDTO generalInfoDTO = new GeneralInfoDTO(selectedCollege);
        return generalInfoDTO;
    }
}
