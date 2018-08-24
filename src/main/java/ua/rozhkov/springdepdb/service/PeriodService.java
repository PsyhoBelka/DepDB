package ua.rozhkov.springdepdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.rozhkov.springdepdb.DAO.entity.College;
import ua.rozhkov.springdepdb.DAO.entity.Period;
import ua.rozhkov.springdepdb.DAO.repository.PeriodRepository;
import ua.rozhkov.springdepdb.FormDTO.PeriodFormDTO;

import java.util.ArrayList;
import java.util.List;

//todo add validation
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

    public Period perfomPeriodFormDTOAdd(PeriodFormDTO periodFormDTOToAdd) {
        Period newPeriod=new Period();
        newPeriod.setName(periodFormDTOToAdd.getName());
        newPeriod.setColleges(getCollegesByIdsArray(periodFormDTOToAdd.getSelectedColleges(), periodFormDTOToAdd));
        periodRepository.saveAndFlush(newPeriod);
        return newPeriod;
    }

    public PeriodFormDTO preparePeriodFormDTOToEdit(Period periodToEdit) {
        PeriodFormDTO periodFormDTOToEdit = new PeriodFormDTO();

        periodFormDTOToEdit.setId(periodToEdit.getId());
        periodFormDTOToEdit.setName(periodToEdit.getName());

        periodFormDTOToEdit.setColleges(collegeService.findAll());
        periodFormDTOToEdit.setSelectedColleges(periodToEdit.colegesIdsToStrindArray());
        return periodFormDTOToEdit;
    }

    public Period perfomPeriodFormDTOEdit(PeriodFormDTO periodFormDTOToEdit) {
        Period periodToEdit = new Period();

        periodToEdit.setId(periodFormDTOToEdit.getId());
        periodToEdit.setName(periodFormDTOToEdit.getName());

        periodToEdit.setColleges(getCollegesByIdsArray(periodFormDTOToEdit.getSelectedColleges(), periodFormDTOToEdit));
        periodRepository.saveAndFlush(periodToEdit);
        return periodToEdit;
    }
}
