package org.zhaobudao.mist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.zhaobudao.mist.model.User;
import org.zhaobudao.mist.service.InviteService;
import org.zhaobudao.mist.util.ResponseMsg;

@Controller
@RequestMapping("/invite")
public class InviteController {

    @Autowired
    private InviteService inviteService;

    @RequestMapping(method = RequestMethod.GET)
    public String invite(Model model) {
        User user = new User();
        user.setEmail("lamb@me.com");
        user.setPassword("!#@32中文");
        model.addAttribute("user", user);
        return "inviter";
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public ResponseMsg invite(@RequestParam("email") String email) {
        try {
            inviteService.addInvite(email);
        } catch (Exception e) {
            return new ResponseMsg().error(e.getMessage());
        }
        return new ResponseMsg().success();
    }

    @RequestMapping("/{inviteNo}")
    public ModelAndView register(@PathVariable("inviteNo") String inviteNo, ModelAndView m) {
        // TODO 验证邀请码并找到email放到页面里
        m.addObject("inviteNo", inviteNo);
        m.addObject("email", "at1943@gmail.com");
        m.setViewName("inviteRegist");
        return m;
    }
}
