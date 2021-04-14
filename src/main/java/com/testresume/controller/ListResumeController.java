package com.testresume.controller;

import com.testresume.entity.Resume;
import com.testresume.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class ListResumeController {

    private final String header = "<html><body>" +
            "<h1>Resume list</h1>" +
            "<div><table border=\"1\">${TABLE}</table></div>" +
            "<form action=\"/show\" method=\"post\">" +
            "<div><label for=\"uid\">UID</label>" +
            "<input type=\"text\" class=\"form-control\" id=\"uid\" maxlength=\"60\" name=\"uid\" placeholder=\"UID\">\n</div>" +
            "<button type=\"submit\">show</button></form>" +
            "<form action=\"/create\" method=\"get\"><button type=\"submit\">create</button></form>" +
            "</body></html>";

    @Autowired
    private ResumeService resumeService;

    @RequestMapping(value = { "/resume" }, method = RequestMethod.GET)
    public String getResume() {
        return header.replace("${TABLE}", addTableOfResume(resumeService.getResume()));
    }

    private String addTableOfResume(List<Resume> resumeList) {
        StringBuilder model = new StringBuilder();
        model.append("<tr>")
                .append("<th>UID</th>")
                .append("<th>First Name</th>")
                .append("<th>Last Name</th>")
                .append("<th>Middle Name</th>")
                .append("<th>City</th>")
                .append("<th>Email</th>")
                .append("<th>Phone</th>")
                .append("<th>Skills</th>")
                .append("<th>Experience</th>")
                .append("<th>Objective</th>")
            .append("/<tr>");

        resumeList.forEach(resume ->
            model.append("<tr>")
                .append("<td>").append(resume.getUid()).append("</td>")
                .append("<td>").append(resume.getFirstName()).append("</td>")
                .append("<td>").append(resume.getLastName()).append("</td>")
                .append("<td>").append(resume.getMiddleName()).append("</td>")
                .append("<td>").append(resume.getCity()).append("</td>")
                .append("<td>").append(resume.getEmail()).append("</td>")
                .append("<td>").append(resume.getPhone()).append("</td>")
                .append("<td>").append(resume.getSkills()).append("</td>")
                .append("<td>").append(resume.getExperience()).append("</td>")
                .append("<td>").append(resume.getObjective()).append("</td>")
            .append("</tr>"));
        return model.toString();
    }

    @RequestMapping(value = { "/delete/{uid}" }, method = RequestMethod.GET)
    public RedirectView getDeleteResume(@PathVariable("uid") String uid){
        resumeService.removeResume(uid);
        return new RedirectView("/resume");
    }

}
