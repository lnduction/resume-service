package com.testresume.controller;

import com.testresume.entity.Resume;
import com.testresume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import static com.testresume.controller.EditResumeController.fullResumeData;

@RestController
public class ShowResumeController {

    @Autowired
    private ResumeService resumeService;

    private final String body = "<html><body>" +
        "<input name=\"id\" type=\"hidden\" value=\"${ID}\">" +
        "<h1>${FIRST_NAME}</h1>" +
        "<h1>${LAST_NAME}</h1>" +
        "<h1>${MIDDLE_NAME}</h1>" +
        "<h3>${CITY}</h3>" +
        "<h3>${EMAIL}</h3>" +
        "<h3>${PHONE}</h3>" +
        "<p>${SKILLS}</p>" +
        "<p>${EXPERIENCE}</p>" +
        "<p>${OBJECTIVE}</p>" +
            "<form action=\"/delete/${UID}\" method=\"get\"><button type=\"submit\">delete</button></form>" +
            "<form action=\"/edit/${UID}\" method=\"get\"><button type=\"submit\">edit</button></form>" +
            "</body></html>";

    @RequestMapping(value = { "/show/{uid}" }, method = RequestMethod.GET)
    public String getShowResume(@PathVariable("uid") String uid){ return fullResumeData(uid, resumeService, body); }

    @RequestMapping(value = { "/show" }, method = RequestMethod.POST)
    public RedirectView postShowResume(@RequestParam(name = "uid") String uid){
        return new RedirectView("/show/" + uid);
    }
}
