package org.zhaobudao.mist.controller;

import java.util.Calendar;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.zhaobudao.mist.model.Project;
import org.zhaobudao.mist.model.User;
import org.zhaobudao.mist.service.ProjectService;

import static org.zhaobudao.mist.util.Constants.*;

@Controller
@RequestMapping("/project")
@SessionAttributes(SESSION_USER)
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @RequestMapping(method = RequestMethod.GET)
    public String list(Model model) {
        List<Project> projects = projectService.query(new Project(), Project.class);
        model.addAttribute("projects", projects);
        return "project/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable int id, Project query, Model model) {
        Project project = projectService.queryForObject(query, Project.class);
        model.addAttribute("project", project);
        return "project/show";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "project/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(@Valid Project project, BindingResult result, @ModelAttribute(SESSION_USER) User user) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error.getDefaultMessage());
            }
            return "redirect:";
        } else {
            project.setCreateBy(user.getId());
            project.setCreateDate(Calendar.getInstance().getTime());
            return "redirect:" + projectService.save(project);
        }

    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.GET)
    public String modify(@PathVariable int id, Project query, Model model) {
        Project project = projectService.queryForObject(query, Project.class);
        model.addAttribute("project", project);
        return "project/modify";
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.POST)
    public String modify(@PathVariable int id, @Valid Project project, BindingResult result, @ModelAttribute(SESSION_USER) User user) {
        if (result.hasErrors()) {
            List<ObjectError> errors = result.getAllErrors();
            for (ObjectError error : errors) {
                System.out.println(error.getDefaultMessage());
            }
            return "redirect:";
        } else {
            project.setId(id);
            project.setModifyBy(user.getId());
            Project where = new Project();
            where.setId(id);
            projectService.update(where, project);
            return "redirect:";
        }

    }

    @RequestMapping(value = "/{id}/delete", method = RequestMethod.GET)
    public String delete(@PathVariable int id, Project project) {
        project.setId(id);
        projectService.delete(project);
        return "redirect:../";
    }

}
