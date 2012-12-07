package org.zhaobudao.mist.model;

import java.util.Date;
import org.junit.Before;
import org.junit.Test;
import org.zhaobudao.mist.model.Module;

public class ModuleTest {

    private Module module;

    @Before
    public void setUp() throws Exception {
        module = new Module();
    }

    @Test
    public void testModule() {
        module.getId();
        module.getProjectId();
        module.getName();
        module.getCreateBy();
        module.getCreateDate();
        module.getModifyBy();
        module.getModifyDate();

        module.setId(1);
        module.setProjectId(1);
        module.setName("name");
        module.setCreateBy(-1);
        module.setCreateDate(new Date());
        module.setModifyBy(-1);
        module.setModifyDate(new Date());
    }

}
