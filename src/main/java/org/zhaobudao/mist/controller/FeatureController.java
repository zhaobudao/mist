package org.zhaobudao.mist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.zhaobudao.mist.model.Feature;

@Controller
@RequestMapping("/feature")
public class FeatureController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String list() {
        return "feature/list";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String show(@PathVariable int id) {
        return "feature/show";
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String create() {
        return "feature/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String create(Feature feature) {
        return "feature/create";
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.GET)
    public String edit() {
        return "feature/modify";
    }

    @RequestMapping(value = "/{id}/modify", method = RequestMethod.PUT)
    public String edit(Feature feature) {
        return "feature/modify";
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String delete(Feature feature) {
        return "feature/delete";
    }

}
