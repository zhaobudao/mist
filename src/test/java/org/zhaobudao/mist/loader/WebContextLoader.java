package org.zhaobudao.mist.loader;

import org.zhaobudao.mist.util.ConstantsTest;

public class WebContextLoader extends GenericWebContextLoader {

    public WebContextLoader() {
        super(ConstantsTest.WEB_ROOT, false);
    }

}
