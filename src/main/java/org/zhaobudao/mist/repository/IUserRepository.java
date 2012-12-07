package org.zhaobudao.mist.repository;

import org.zhaobudao.mist.model.User;

public interface IUserRepository {

    String getPassword(String email);

    User get(String email);

    int getSalt(String email);

    int save(User user);

}
