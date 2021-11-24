/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpn.filters;

import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import longpn.DBUtils.PropertiesFileHelper;

/**
 * Web application lifecycle listener.
 *
 * @author tunbe
 */
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {

        try {
            ServletContext context = sce.getServletContext();
            String siteMapLocation = context.getInitParameter("SITE_MAP_LOCATION");
//            String authenticationPropertiesLocation = context.getInitParameter("AUTHENTICATION_PROPERTIES_FILE_LOCATION");
            Properties siteMapProperty = PropertiesFileHelper.getProperties(context, siteMapLocation);
            Properties authenticationProperty = PropertiesFileHelper.getProperties(context, siteMapLocation);

            context.setAttribute("SITE_MAP", siteMapProperty);
//            context.setAttribute("AUTHENTICATION_LIST", authenticationProperty);
        } catch (IOException ex) {
            Logger.getLogger(ContextListener.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
    }
}
