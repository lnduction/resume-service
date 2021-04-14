package com.testresume.controller;

import com.testresume.entity.Resume;
import com.testresume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import static com.testresume.controller.CreateResumeController.getString;

@RestController
public class EditResumeController {

    private final String body = "<html><body>"+
            "<form id=\"resume\" action=\"/edit\" method=\"post\">\n" +
            "<input type=\"hidden\" class=\"form-control\" maxlength=\"20\" name=\"uid\" value=\"${UID}\">\n</div>" +
            "<div><label>${FIRST_NAME}</label>\n" +
            "<input type=\"hidden\" class=\"form-control\" maxlength=\"20\" name=\"firstName\" value=\"${FIRST_NAME}\">\n</div>" +
            "<div><label>${LAST_NAME}</label>\n" +
            "<input type=\"hidden\" class=\"form-control\"  maxlength=\"20\" name=\"lastName\" value=\"${LAST_NAME}\">\n</div>" +
            "<div><label>${MIDDLE_NAME}</label>\n" +
            "<input type=\"hidden\" class=\"form-control\"  maxlength=\"20\" name=\"middleName\" value=\"${MIDDLE_NAME}\">\n</div>" +
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

    @RequestMapping(value = { "/edit/{uid}" }, method = RequestMethod.GET)
    public String getEditResume(@PathVariable("uid") String uid){
        return fullResumeData(uid, resumeService, body);
    }

    static String fullResumeData(String uid, ResumeService resumeService, String body) {
        Resume resume = resumeService.findResume(uid);
        return getString(resume, body);
    }

    @RequestMapping(value = { "/edit" }, method = RequestMethod.POST)
    public RedirectView postEditResume(@ModelAttribute("resume") Resume resume){
        resumeService.removeResume(resume.getUid());
        resumeService.saveResume(resume);
        return new RedirectView("/resume");
    }

}
