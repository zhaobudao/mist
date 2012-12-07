package org.zhaobudao.mist.model;

import org.junit.Before;
import org.junit.Test;
import org.zhaobudao.mist.model.Invite;

public class InviteTest {
    private Invite invite;

    @Before
    public void setUp() throws Exception {
        invite = new Invite();
    }

    @Test
    public void testInvite() {
        invite.getId();
        invite.getNo();
        invite.getEmail();
        invite.getStatus();

        invite.setId(1);
        invite.setNo("no");
        invite.setEmail("ss");
        invite.setStatus(1);
    }

}
