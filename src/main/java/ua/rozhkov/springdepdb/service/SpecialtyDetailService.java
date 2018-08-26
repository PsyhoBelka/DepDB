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

import java.util.Arrays;
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
        return specialtyDetailRepository.findSpecialtyDetailById(id);
    }

    @Override
    public List<SpecialtyDetail> findAll() {
        return specialtyDetailRepository.findAll();
    }

    @Override
    public SpecialtyDetail findByName(String name) {
        return null;
    }

    @Override
    public SpecialtyDetail save(SpecialtyDetail specialtyDetail) {
        return specialtyDetailRepository.save(specialtyDetail);

    }

    @Override
    public void deleteById(Long id) {
        specialtyDetailRepository.deleteById(id);
    }

    public SpecialtyDetailFormDTO prepareSpecialtyDetailFormDTOToAdd(Long idSpecialty) {
        SpecialtyDetailFormDTO specialtyDetailFormDTOToAdd = new SpecialtyDetailFormDTO();
        specialtyDetailFormDTOToAdd.setSpecialtyId(idSpecialty);
        return specialtyDetailFormDTOToAdd;
    }

    public void perfomSpecialtyDetailFormDTOAdd(SpecialtyDetailFormDTO specialtyDetailFormDTOToAdd) {
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
    }

    public GeneralInfoDTO prepareGeneralInfoDTOToList(Long selectedCollegeId) {
        College selectedCollege = collegeService.findById(selectedCollegeId);
        GeneralInfoDTO generalInfoDTO = new GeneralInfoDTO(selectedCollege);
        return generalInfoDTO;
    }

    public SpecialtyDetailFormDTO prepareSpecialtyDetailFormDTOToEdit(Long idSpecialtyDetails) {
        SpecialtyDetailFormDTO specialtyDetailFormDTOToEdit = new SpecialtyDetailFormDTO();
        SpecialtyDetail specialtyDetailToEdit = findById(idSpecialtyDetails);
        specialtyDetailFormDTOToEdit.setSelectedBase(String.valueOf(specialtyDetailToEdit.getBase()));
        specialtyDetailFormDTOToEdit.setSelectedStudyForm(String.valueOf(specialtyDetailToEdit.getStudyForm()));
        specialtyDetailFormDTOToEdit.setAvailableBases(Arrays.asList(Base.values()));
        specialtyDetailFormDTOToEdit.setAvailableStudyForms(Arrays.asList(StudyForm.values()));
        specialtyDetailFormDTOToEdit.setLicenseCapacity(specialtyDetailToEdit.getLicenseCapacity());
        specialtyDetailFormDTOToEdit.setRegionOrder(specialtyDetailToEdit.getRegionOrder());
        specialtyDetailFormDTOToEdit.setRealCapacity(specialtyDetailToEdit.getRealCapacity());
        specialtyDetailFormDTOToEdit.setGraduated(specialtyDetailToEdit.getGraduated());
        return specialtyDetailFormDTOToEdit;
    }

    public void perfomSpecialtyDetailFormDTOEdit(SpecialtyDetailFormDTO specialtyDetailFormDTOToEdit) {
        SpecialtyDetail specialtyDetailToEdit = new SpecialtyDetail();
        specialtyDetailToEdit.setBase(Base.valueOf(specialtyDetailFormDTOToEdit.getSelectedBase()));
        specialtyDetailToEdit.setStudyForm(StudyForm.valueOf(specialtyDetailFormDTOToEdit.getSelectedStudyForm()));
        specialtyDetailToEdit.setLicenseCapacity(specialtyDetailFormDTOToEdit.getLicenseCapacity());
        specialtyDetailToEdit.setRegionOrder(specialtyDetailFormDTOToEdit.getLicenseCapacity());
        specialtyDetailToEdit.setRealCapacity(specialtyDetailFormDTOToEdit.getRealCapacity());
        specialtyDetailToEdit.setGraduated(specialtyDetailFormDTOToEdit.getGraduated());
        specialtyDetailToEdit.setRegionOrder(specialtyDetailFormDTOToEdit.getLicenseCapacity());
        save(specialtyDetailToEdit);
    }
}
