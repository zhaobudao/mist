package org.zhaobudao.mist.service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhaobudao.mist.repository.impl.InviteRepository;
import org.zhaobudao.mist.util.MailSender;


@Service
public class InviteService {

    private Logger log = Logger.getLogger(InviteService.class);

    @Autowired
    private InviteRepository inviteRepository;
    @Autowired
    private MailSender mailSender;

    @Transactional
    public void addInvite(final String email) {
        if (!inviteRepository.checkEmailValid(email)) {
            // TODO 自定义异常
            throw new RuntimeException("邮件已经注册过");
        }
        final String no = UUID.randomUUID().toString().replace("-", "");
        inviteRepository.save(email, no);
        Map<String, Object> model = new HashMap<String, Object>();
        model.put("url", "http://127.0.0.1:8080/bamboo/invite/" + no);
        mailSender.send(email, "bamboo 邀请注册", "mail/invite.html", model);
        log.info("邀请" + email);
    }

    public String findEmailByInviteNo(String inviteNo) {
        String email = inviteRepository.getEmail(inviteNo);
        if (email == null) {
            throw new RuntimeException("无效");
        }
        return email;
    }
}
