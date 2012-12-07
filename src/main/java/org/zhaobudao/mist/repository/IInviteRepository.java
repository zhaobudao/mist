package org.zhaobudao.mist.repository;

import org.zhaobudao.mist.model.Invite;

public interface IInviteRepository {

    void save(String email, String no);

    int save(Invite invite);
}
