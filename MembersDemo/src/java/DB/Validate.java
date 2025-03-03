package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author madhvibera
 */

public class Validate {

    public static boolean checkUser(String email, String pass) {
        boolean st = false;
        try {

            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/JSP_DB", "root", "root");

            PreparedStatement ps = con.prepareStatement("select * from members where uname=? and pass=?");
            ps.setString(1, email);
            ps.setString(2, pass);
            ResultSet rs = ps.executeQuery();
            st = rs.next();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return st;
    }
}
