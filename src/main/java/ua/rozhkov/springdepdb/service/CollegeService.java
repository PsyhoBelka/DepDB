package ua.rozhkov.springdepdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.rozhkov.springdepdb.DAO.entity.College;
import ua.rozhkov.springdepdb.DAO.entity.OwnerShip;
import ua.rozhkov.springdepdb.DAO.entity.Specialty;
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

    public College perfomCollegeFormDTOAdd(CollegeFormDTO newCollegeFormDTO) {
        College newCollege = new College();
        newCollege.setName(newCollegeFormDTO.getName());
        newCollege.setAddress(newCollegeFormDTO.getAddress());
        newCollege.setDirector(newCollegeFormDTO.getDirector());
        newCollege.setPhone(newCollegeFormDTO.getPhone());
        newCollege.setOwnerShip(OwnerShip.valueOf(newCollegeFormDTO.getSelectedOwnerShip()));
        newCollege.setSpecialties(getSpecialtiesByIdsArray(newCollegeFormDTO.getSelectedSpecialties(), newCollegeFormDTO));
        collegeRepository.saveAndFlush(newCollege);
        return newCollege;
    }
}
