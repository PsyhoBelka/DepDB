package ua.rozhkov.springdepdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.rozhkov.springdepdb.DAO.entity.College;
import ua.rozhkov.springdepdb.DAO.entity.Specialty;
import ua.rozhkov.springdepdb.DAO.enums.OwnerShip;
import ua.rozhkov.springdepdb.DAO.repository.CollegeRepository;
import ua.rozhkov.springdepdb.FormDTO.CollegeFormDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class CollegeService implements BaseService<College, Long> {
    @Autowired
    private CollegeRepository collegeRepository;

    @Autowired
    private SpecialtyService specialtyService;

    @Override
    public College findById(Long id) {
        return collegeRepository.findCollegeById(id);
    }

    @Override
    public List<College> findAll() {
        return collegeRepository.findAll();
    }

    @Override
    public College findByName(String name) {
        return collegeRepository.findCollegeByName(name);
    }

    @Override
    public void deleteById(Long id) {
        collegeRepository.deleteById(id);
    }

    @Override
    public College save(College college) {
        return collegeRepository.saveAndFlush(college);
    }

    private List<Specialty> getSpecialtiesByIdsArray(String[] ids, CollegeFormDTO sourceCollegeFormDTO) {
        List<Specialty> selectedSpecialties = new ArrayList<>();
        for (int i = 0; i < sourceCollegeFormDTO.getSelectedSpecialties().length; i++) {
            selectedSpecialties.add(specialtyService.findById(Long.parseLong(sourceCollegeFormDTO.getSelectedSpecialties()[i])));
        }
        return selectedSpecialties;
    }

    public CollegeFormDTO prepareCollegeFormDTOToAdd() {
        CollegeFormDTO collegeFormDTOToAdd = new CollegeFormDTO();
        collegeFormDTOToAdd.setSpecialties(specialtyService.findAll());
        return collegeFormDTOToAdd;
    }

    public College perfomCollegeFormDTOAdd(CollegeFormDTO collegeFormDTOToAdd) {
        College newCollege = new College();

        newCollege.setName(collegeFormDTOToAdd.getName());
        newCollege.setAddress(collegeFormDTOToAdd.getAddress());
        newCollege.setDirector(collegeFormDTOToAdd.getDirector());
        newCollege.setPhone(collegeFormDTOToAdd.getPhone());
        newCollege.setOwnerShip(OwnerShip.valueOf(collegeFormDTOToAdd.getSelectedOwnerShip()));
        newCollege.setSpecialties(getSpecialtiesByIdsArray(collegeFormDTOToAdd.getSelectedSpecialties(), collegeFormDTOToAdd));

        collegeRepository.saveAndFlush(newCollege);
        return newCollege;
    }

    public CollegeFormDTO prepareCollegeFormDTOToEdit(College collegeToEdit) {
        CollegeFormDTO collegeFormDTOToEdit = new CollegeFormDTO();

        collegeFormDTOToEdit.setId(collegeToEdit.getId());
        collegeFormDTOToEdit.setName(collegeToEdit.getName());
        collegeFormDTOToEdit.setAddress(collegeToEdit.getAddress());
        collegeFormDTOToEdit.setDirector(collegeToEdit.getDirector());
        collegeFormDTOToEdit.setPhone(collegeToEdit.getPhone());
        collegeFormDTOToEdit.setSelectedOwnerShip(collegeToEdit.getOwnerShip().toString());

        collegeFormDTOToEdit.setSpecialties(specialtyService.findAll());
        collegeFormDTOToEdit.setSelectedSpecialties(collegeToEdit.specialitiesIdsToStringArray());
        return collegeFormDTOToEdit;
    }

    public College perfomCollegeFormDTOEdit(CollegeFormDTO collegeFormDTOToEdit) {
        College collegeToEdit = new College();

        collegeToEdit.setId(collegeFormDTOToEdit.getId());
        collegeToEdit.setName(collegeFormDTOToEdit.getName());
        collegeToEdit.setAddress(collegeFormDTOToEdit.getAddress());
        collegeToEdit.setDirector(collegeFormDTOToEdit.getDirector());
        collegeToEdit.setPhone(collegeFormDTOToEdit.getPhone());
        collegeToEdit.setOwnerShip(OwnerShip.valueOf(collegeFormDTOToEdit.getSelectedOwnerShip()));
        collegeToEdit.setSpecialties(getSpecialtiesByIdsArray(collegeFormDTOToEdit.getSelectedSpecialties(), collegeFormDTOToEdit));

        collegeRepository.saveAndFlush(collegeToEdit);
        return collegeToEdit;
    }
}
