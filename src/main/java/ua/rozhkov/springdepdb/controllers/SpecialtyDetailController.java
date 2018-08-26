package ua.rozhkov.springdepdb.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import ua.rozhkov.springdepdb.DAO.entity.College;
import ua.rozhkov.springdepdb.DAO.entity.Period;
import ua.rozhkov.springdepdb.DAO.entity.Specialty;
import ua.rozhkov.springdepdb.FormDTO.SpecialtyDetailFormDTO;
import ua.rozhkov.springdepdb.service.CollegeService;
import ua.rozhkov.springdepdb.service.PeriodService;
import ua.rozhkov.springdepdb.service.SpecialtyDetailService;
import ua.rozhkov.springdepdb.service.SpecialtyService;

import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/detail")
public class SpecialtyDetailController {

    @Autowired
    private CollegeService collegeService;

    @Autowired
    private SpecialtyService specialtyService;

    @Autowired
    private PeriodService periodService;

    @Autowired
    private SpecialtyDetailService specialtyDetailService;

    @RequestMapping("/selectperiod")
    public String showPeriodSelectionPage(Model model) {
        model.addAttribute("periods", periodService.findAll());
        return "detail/selectPeriodDetail";
    }

    @RequestMapping("/period/{id}")
    public String showCollegeSelectionPage(@PathVariable Long id, Model model, HttpSession httpSession) {
        Period selectedPeriod = periodService.findById(id);
        httpSession.setAttribute("periodId", selectedPeriod.getId());
        model.addAttribute("colleges", selectedPeriod.getColleges());
        return "detail/selectCollegeDetail";
    }

    @RequestMapping("/college/{id}")
    public String showGeneralDetailsPage(@PathVariable Long id, Model model, HttpSession httpSession) {
        College selectedCollege = collegeService.findById(id);
        model.addAttribute("selectedCollege", selectedCollege);
        /*List<Specialty> specialtyInCollege=selectedCollege.getSpecialties();
        for (Specialty specialty :
                specialtyInCollege) {
            specialty.getSpecialtyDetails();
        }*/

//        model.addAttribute("specialties",selectedCollege.getSpecialties());
        httpSession.setAttribute("collegeId", selectedCollege.getId());
        model.addAttribute("generalInfoDTO", specialtyDetailService.prepareGeneralInfoDTOToList(id));
        return "detail/listGeneralDetails";
    }

    @RequestMapping("/editDetailsFromSpecialty/{id}")
    public String showListSpecialtyDetailsFromSpeciality(@PathVariable Long id, Model model) {
        Specialty specialty = specialtyService.findById(id);
        specialty.setId(id);
        model.addAttribute("specialtyDetails", specialty.getSpecialtyDetails());
//        model.addAttribute("specialtyId",specialty.getId());
        model.addAttribute("specialtyWithDetails", specialty);
        return "detail/listDetailsFromSpecialty";
    }

    //todo
    @RequestMapping("/addSpecialtyDetail/{id}")//id - id specialty
    public String showAddSpecialtyDetailPage(@PathVariable Long id, Model model) {
        model.addAttribute("specialtyDetailFormDTOToAdd", specialtyDetailService.prepareSpecialtyDetailFormDTOToAdd(id));
        return "detail/addSpecialtyDetail";
    }

    //todo org.h2.jdbc.JdbcSQLException при добавлении не уникальной пары
    @RequestMapping("/specialtyDetailAdd")
    public String addSpecialtyDetail(@ModelAttribute SpecialtyDetailFormDTO specialtyDetailFormDTOToAdd) {
        specialtyDetailService.perfomSpecialtyDetailFormDTOToAdd(specialtyDetailFormDTOToAdd);
        return "redirect:/detail/editDetailsFromSpecialty/" + specialtyDetailFormDTOToAdd.getSpecialtyId();
    }

    //todo editSpecialtyDetail/{id}

    //todo deleteSpecialtyDetail

    //todo deleteDetailsFromSpecialty
}
