package org.zhaobudao.mist.service;

import java.util.Calendar;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zhaobudao.mist.model.Module;
import org.zhaobudao.mist.service.ModuleService;
import org.zhaobudao.mist.util.ConstantsTest;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(ConstantsTest.CONTEXT)
public class ModuleServiceTest {

    @Autowired
    private ModuleService moduleService;
    private int id;

    @Before
    public void setUp() {
        Module m = new Module();
        m.setName("xx模块");
        m.setProjectId(1);
        m.setCreateBy(2);
        m.setCreateDate(Calendar.getInstance().getTime());
        id = moduleService.save(m);
    }

    @Test
    @Rollback
    public void testSave() {
        Module m = new Module();
        m.setName("xx模块2");
        m.setProjectId(1);
        m.setCreateBy(2);
        m.setCreateDate(Calendar.getInstance().getTime());
        moduleService.save(m);
    }

    @Test
    public void testGet() {
        moduleService.get(id);
    }

    @Test
    public void testFindByProject() {
        moduleService.findByProject(1);
    }

    @Test
    public void testModify() {
        Module m = new Module();
        m.setId(id);
        m.setName("xx模块修改");
        m.setModifyBy(1);
        moduleService.modify(m);
    }

    @Test
    public void testDelete() {
        moduleService.deleteById(id);
    }
}
