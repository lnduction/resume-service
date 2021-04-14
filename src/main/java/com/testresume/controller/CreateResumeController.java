package com.testresume.controller;

import com.testresume.entity.Resume;
import com.testresume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class CreateResumeController {

    private final String body = "<html><body>" +
            "<form id=\"resume\" action=\"/edit\" method=\"post\">\n" +
            "<div><label for=\"firstName\">First name</label>\n" +
            "<input type=\"text\" class=\"form-control\" id=\"firstName\" maxlength=\"20\" name=\"firstName\" value=\"${FIRST_NAME}\" placeholder=\"First name\">\n</div>" +
            "<div><label for=\"lastName\">Last name</label>\n" +
            "<input type=\"text\" class=\"form-control\" id=\"lastName\" maxlength=\"20\" name=\"lastName\" value=\"${LAST_NAME}\" placeholder=\"Last name\">\n</div>" +
            "<div><label for=\"middleName\">Middle name</label>\n" +
            "<input type=\"text\" class=\"form-control\" id=\"middleName\" maxlength=\"20\" name=\"middleName\" name=\"middleName\" value=\"${MIDDLE_NAME}\" placeholder=\"Middle name\">\n</div>" +
            "<div><label for=\"city\">City</label>\n" +
            "<input type=\"text\" class=\"form-control\" id=\"city\" maxlength=\"20\" name=\"city\" value=\"${CITY}\" placeholder=\"City\">\n</div>" +
            "<div><label for=\"email\">Email</label>\n" +
            "<input type=\"text\" class=\"form-control\" id=\"email\" maxlength=\"20\" name=\"email\" value=\"${EMAIL}\" placeholder=\"Email\">\n</div>" +
            "<div><label for=\"phone\">Phone</label>\n" +
            "<input type=\"text\" class=\"form-control\" id=\"phone\" maxlength=\"20\" name=\"phone\" value=\"${PHONE}\" placeholder=\"Phone\">\n</div>" +
            "<div><label for=\"skills\">Skills</label>\n" +
            "<textarea placeholder=\"Skills\" id=\"skills\" name=\"skills\">${SKILLS}</textarea></div>\n" +
            "<div><label for=\"experience\">Experience</label>\n" +
            "<textarea placeholder=\"Experience\" id=\"experience\" name=\"experience\" >${EXPERIENCE}</textarea></div>\n" +
            "<div><label for=\"objective\">Objective</label>\n" +
            "<textarea placeholder=\"Objective\" id=\"objective\" name=\"objective\">${OBJECTIVE}</textarea></div>\n" +
            "<button type=\"submit\">Submit</button>" +
            "</form></body></html>";

    @Autowired
    private ResumeService resumeService;

    @RequestMapping(value = { "/create" }, method = RequestMethod.GET)
    public String getCreateResume(){
        Resume resume = new Resume("","","","","","","","","");
        resume.setUid("");
        return getString(resume, body);
    }

    static String getString(Resume resume, String body) {
        return body.replace("${FIRST_NAME}", resume.getFirstName()).
                replace("${LAST_NAME}", resume.getLastName()).
                replace("${MIDDLE_NAME}", resume.getMiddleName()).
                replace("${CITY}", resume.getCity()).
                replace("${EMAIL}", resume.getEmail()).
                replace("${PHONE}", resume.getPhone()).
                replace("${SKILLS}", resume.getSkills()).
                replace("${EXPERIENCE}", resume.getExperience()).
                replace("${OBJECTIVE}", resume.getObjective()).
                replace("${UID}", resume.getUid());
    }
}
