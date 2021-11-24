
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Web application lifecycle listener.
 *
 * @author tunbe
 */
public class NewServletListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.log("Deploying...");
        String siteMapLocation = context.getInitParameter("SITE_MAP_LOCATION");
        InputStream is = null;

        if (siteMapLocation != null) {
            Properties propertis = new Properties();
            is = context.getResourceAsStream(siteMapLocation);
            try {
                propertis.load(is);

                context.setAttribute("SITEMAP", propertis);
            } catch (IOException ex) {

            }
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        ServletContext context = sce.getServletContext();
        context.log("Destroying...");
    }

}
