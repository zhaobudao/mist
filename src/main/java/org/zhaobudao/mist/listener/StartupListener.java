package org.zhaobudao.mist.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;

public class StartupListener implements ServletContextListener {

    private static Logger log = Logger.getLogger(StartupListener.class);

    private ServletContext context;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        context = sce.getServletContext();
        setWebProperty();
    }

    private void setWebProperty() {
        setAttribute("contextPath", context.getContextPath());
    }

    private void setAttribute(String key, Object value) {
        context.setAttribute(key, value);
        log.info("ServletContext add " + key + ":" + value);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // TODO Auto-generated method stub
    }
}
