/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package longpn.DBUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import javax.servlet.ServletContext;

/**
 *
 * @author tunbe
 */
public class PropertiesFileHelper {

    public static Properties getProperties(ServletContext context, String fileRelativePath) throws IOException {
        InputStream input = context.getResourceAsStream(fileRelativePath);
        Properties prop = null;
        try {
            prop = new Properties();
            prop.load(input);
        } catch (IOException ex) {

        }
        return prop;
    }
}
