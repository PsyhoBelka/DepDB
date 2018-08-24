package ua.rozhkov.springdepdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.rozhkov.springdepdb.DAO.entity.College;
import ua.rozhkov.springdepdb.DAO.entity.Period;
import ua.rozhkov.springdepdb.DAO.repository.PeriodRepository;
import ua.rozhkov.springdepdb.FormDTO.PeriodFormDTO;

import java.util.ArrayList;
import java.util.List;

@Service
public class PeriodService implements BaseService<Period, Long> {
    @Autowired
    private PeriodRepository periodRepository;

    @Autowired
    private CollegeService collegeService;


    @Override
    public Period findById(Long id) {
        return periodRepository.findPeriodById(id);
    }

    @Override
    public List<Period> findAll() {
        return periodRepository.findAll();
    }

    @Override
    public Period findByName(String name) {
        return periodRepository.findPeriodByName(name);
    }

    @Override
    public Period save(Period period) {
        return periodRepository.saveAndFlush(period);
    }

    @Override
    public void deleteById(Long id) {
        periodRepository.deleteById(id);
    }

    public void addColleges(List<College> colleges, Period periodToAdd) {
        for (College college :
                colleges) {
            periodToAdd.addCollege(college);
        }
    }

    private List<College> getCollegesByIdsArray(String[] ids, PeriodFormDTO sourcePeriodFormDTO) {
        List<College> selectedColleges = new ArrayList<>();
        for (int i = 0; i < sourcePeriodFormDTO.getSelectedColleges().length; i++) {
            selectedColleges.add(collegeService.findById(Long.parseLong(sourcePeriodFormDTO.getSelectedColleges()[i])));
        }
        return selectedColleges;
    }

    public PeriodFormDTO preparePeriodFormDTOToAdd() {
        PeriodFormDTO periodFormDTO = new PeriodFormDTO();
        periodFormDTO.setColleges(collegeService.findAll());
        return periodFormDTO;
    }

    public Period perfomPeriodFormDTOAdd(PeriodFormDTO newPeriodFormDTO) {
        Period newPeriod=new Period();
        newPeriod.setName(newPeriodFormDTO.getName());
        newPeriod.setColleges(getCollegesByIdsArray(newPeriodFormDTO.getSelectedColleges(), newPeriodFormDTO));
        periodRepository.saveAndFlush(newPeriod);
        return newPeriod;
    }

    public PeriodFormDTO preparePeriodFormDTOToEdit(Period editPeriodToEdit) {
        PeriodFormDTO periodFormDTOToEdit = new PeriodFormDTO();
        periodFormDTOToEdit.setId(editPeriodToEdit.getId());
        periodFormDTOToEdit.setName(editPeriodToEdit.getName());
        periodFormDTOToEdit.setColleges(collegeService.findAll());
        periodFormDTOToEdit.setSelectedColleges(editPeriodToEdit.colegesIdsToStrindArray());
        return periodFormDTOToEdit;
    }

    public Period perfomPeriodFormDTOEdit(PeriodFormDTO periodFormDTOToUpdate) {
        Period periodToUpdate = new Period();
        periodToUpdate.setId(periodFormDTOToUpdate.getId());
        periodToUpdate.setName(periodFormDTOToUpdate.getName());
        periodToUpdate.setColleges(getCollegesByIdsArray(periodFormDTOToUpdate.getSelectedColleges(), periodFormDTOToUpdate));
        periodRepository.saveAndFlush(periodToUpdate);
        return periodToUpdate;
    }
}
