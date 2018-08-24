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

    public PeriodFormDTO preparePeriodFormDTOToAdd() {
        PeriodFormDTO periodFormDTO = new PeriodFormDTO();
        periodFormDTO.setColleges(collegeService.findAll());
//        String[] str={"2"};
//        periodFormDTO.setSelectedColleges(str);
        return periodFormDTO;
    }

    public Period perfomPeriodFormDTO(PeriodFormDTO newPeriodFormDTO) {
        Period newPeriod=new Period();
        newPeriod.setName(newPeriodFormDTO.getName());
        List<College> selectedColleges=new ArrayList<>();
        for (int i = 0; i < newPeriodFormDTO.getSelectedColleges().length; i++) {
            selectedColleges.add(collegeService.findById(Long.parseLong(newPeriodFormDTO.getSelectedColleges()[i])));
        }
        newPeriod.setColleges(selectedColleges);
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
}
