package org.zhaobudao.mist.model;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.zhaobudao.mist.model.Feature;

public class FeatureTest {

    private Feature feature;

    @Before
    public void setUp() throws Exception {
        feature = new Feature();
    }

    @Test
    public void testFeature() {
        feature.getId();
        feature.getVersionId();
        feature.getModuleId();
        feature.getCheckpoint();
        feature.getReason();
        feature.getType();
        feature.getHide();
        feature.getAlpha();
        feature.getAlphaBy();
        feature.getAlphaDate();
        feature.getBeta();
        feature.getBetaBy();
        feature.getBetaDate();
        feature.getUat();
        feature.getUatBy();
        feature.getUatDate();
        feature.getDmlUpgrade();
        feature.getDmlRollback();
        feature.getDdlUpgrade();
        feature.getDdlRollback();
        feature.getCreateBy();
        feature.getCreateDate();
        feature.getModifyBy();
        feature.getModifyDate();

        feature.setId(1);
        feature.setVersionId(1);
        feature.setModuleId(1);
        feature.setCheckpoint("111");
        feature.setReason("11");
        feature.setType(1);
        feature.setHide(1);
        feature.setAlpha(1);
        feature.setAlphaBy(1);
        feature.setAlphaDate(new Date());
        feature.setBeta(1);
        feature.setBetaBy(1);
        feature.setBetaDate(new Date());
        feature.setUat(1);
        feature.setUatBy(1);
        feature.setUatDate(new Date());
        feature.setDmlUpgrade("111");
        feature.setDmlRollback("111");
        feature.setDdlUpgrade("111");
        feature.setDdlRollback("111");
        feature.setCreateBy(1);
        feature.setCreateDate(new Date());
        feature.setModifyBy(1);
        feature.setModifyDate(new Date());

    }

}
