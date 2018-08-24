package ua.rozhkov.springdepdb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.rozhkov.springdepdb.DAO.entity.College;
import ua.rozhkov.springdepdb.DAO.entity.Period;
import ua.rozhkov.springdepdb.DAO.repository.PeriodRepository;
import ua.rozhkov.springdepdb.FormDTO.college.AddPeriodForm;

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

    public AddPeriodForm prepareAddPeriodForm() {
        AddPeriodForm addPeriodForm=new AddPeriodForm();
        addPeriodForm.setColleges(collegeService.findAll());
//        String[] str={"2"};
//        addPeriodForm.setSelectedColleges(str);
        return addPeriodForm;
    }

    public Period perfomAddPeriodForm (AddPeriodForm addPeriodForm) {
        Period newPeriod=new Period();
        newPeriod.setName(addPeriodForm.getName());
        List<College> selectedColleges=new ArrayList<>();
        for (int i = 0; i < addPeriodForm.getSelectedColleges().length; i++) {
            selectedColleges.add(collegeService.findById(Long.parseLong(addPeriodForm.getSelectedColleges()[i])));
        }
        newPeriod.setColleges(selectedColleges);
        periodRepository.saveAndFlush(newPeriod);
        return newPeriod;
    }
}
