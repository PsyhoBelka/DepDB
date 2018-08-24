package ua.rozhkov.springdepdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.rozhkov.springdepdb.DAO.entity.Period;
import ua.rozhkov.springdepdb.FormDTO.PeriodFormDTO;
import ua.rozhkov.springdepdb.service.CollegeService;
import ua.rozhkov.springdepdb.service.PeriodService;

@Controller
@RequestMapping("/period")
public class PeriodController {
    @Autowired
    private PeriodService periodService;
    @Autowired
    private CollegeService collegeService;

    @RequestMapping("/list")
    public String showListPeriodsPage(Model model) {
        model.addAttribute("periods", periodService.findAll());
        return "period/listPeriod";
    }

    @RequestMapping("/add")
    public String showAddPeriodPage(Model model) {
        model.addAttribute("periodFormDTOToAdd", periodService.preparePeriodFormDTOToAdd());
        return "period/addPeriod";
    }

    @RequestMapping("/addNewPeriod")
    public String addNewPeriod(@ModelAttribute PeriodFormDTO periodFormDTOToAdd) {
        periodService.perfomPeriodFormDTO(periodFormDTOToAdd);
//        periodService.addColleges(checkedColleges, newPeriod);
//        periodService.save(newPeriod);
        return "redirect:/period/list";
    }

    @RequestMapping("/edit/{id}")
    public String showEditPage(@PathVariable long id, Model model) {
        Period periodToUpdate = periodService.findById(id);
        model.addAttribute("periodToUpdate", periodService.preparePeriodFormDTOToEdit(periodToUpdate));
        return "period/editPeriod";
    }

    //todo
    @RequestMapping("/updatePeriod")
    public String updatePeriod(@ModelAttribute Period periodToUpdate) {
        periodService.save(periodToUpdate);
        return "redirect:/period/list";
    }

    @RequestMapping("/delete/{id}")
    public String deletePeriod(@PathVariable long id) {
        periodService.deleteById(id);
        return "redirect:/period/list";
    }
}
