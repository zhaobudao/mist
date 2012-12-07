package org.zhaobudao.mist.service;

import java.security.NoSuchAlgorithmException;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zhaobudao.mist.model.User;
import org.zhaobudao.mist.repository.IUserRepository;
import org.zhaobudao.mist.util.Constants;
import org.zhaobudao.mist.util.CryptoUtil;

@Service
public class UserService {

    @Autowired
    private IUserRepository userRepository;

    @Transactional(readOnly = true)
    public boolean verifyPassword(String email, String password) {
        boolean flag = false;
        String verify = userRepository.getPassword(email);
        if (null != verify && null != password) {
            if (password.equals(verify)) {
                flag = true;
            }
        }
        return flag;
    }

    @Transactional
    public int save(User user) throws NoSuchAlgorithmException {
        Random random = new Random();
        user.setSalt(random.nextInt(Constants.SALT));
        user.setPassword(CryptoUtil.digest(user.getPassword(), user.getSalt()));
        user.setUsername("yonyou");
        return userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User get(String email) {
        return userRepository.get(email);
    }

    @Transactional(readOnly = true)
    public int getSalt(String email) {
        return userRepository.getSalt(email);
    }

}
