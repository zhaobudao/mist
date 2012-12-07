package org.zhaobudao.mist.util;

import static org.junit.Assert.*;
import org.junit.Test;
import org.zhaobudao.mist.model.User;
import org.zhaobudao.mist.util.Constants;

public class ConstantsTest {

    public static final String CONTEXT = "classpath:mist-context.xml";
    public static final String SERVLET_CONTEXT = "classpath:mist-servlet-context.xml";
    public static final String WEB_ROOT = "src/main/webapp";
    public static final User USER = new User();

    static {
        USER.setId(-1);
        USER.setEmail("test@email.com");
        USER.setUsername("test");
    }

    @Test
    public void test() {
        //new Constants();
        assertEquals("Mist", Constants.PROJECT_NAME);
    }

}
