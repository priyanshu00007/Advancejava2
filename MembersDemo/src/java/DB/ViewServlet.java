/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

/**
 *
 * @author madhvibera
 */
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String Username = request.getParameter("username");

        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/JSP_DB", "root", "root");

            PreparedStatement ps = con.prepareStatement("select * from Members where uname =?");
            ps.setString(1, Username);
            ResultSet rs = ps.executeQuery();

            ResultSetMetaData rsmd = rs.getMetaData();
            int total = rsmd.getColumnCount();
            
            out.print("<table border='1' width='50%' align = 'center'");
            out.print("<tr>");
            
            for (int i = 1; i <= total; i++) {
                out.print("<th>" + rsmd.getColumnName(i) + "</th>");
            }
            out.println("<th> Edit </th> <th> Delete </th>");
            out.print("</tr>");

            /* Printing result */
            while (rs.next()) {
                out.println("<tr><td>" + rs.getString(1)
                        + "</td><td>" + rs.getString(2)
                        + "</td > <td>" + rs.getString(3)
                        + "</td > <td>" + rs.getString(4)
                        + "</td > <td>" + rs.getString(5)
                        + "</td > <td>" + rs.getString(6)
                        + "</td > <td>" + rs.getString(7)
                        + "</td >"
                        + "<td><a href='EditServlet?username=" + rs.getString(2) + "'>EDIT</a></td>"
                        +"<td><a href='DeleteServlet?username=" + rs.getString(2) + "'>DELETE</a></td></tr>");

            }

            out.print("</table>");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
