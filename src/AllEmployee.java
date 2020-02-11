import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.http.*;


@WebServlet(name = "AllEmployee")
public class AllEmployee extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        DatabaseMethods dm = new DatabaseMethods();
        try {
            ResultSet rs = dm.allEmployee();
            out.println("<style>\n" +
                    "table, th, td {\n" +
                    "  border: 1px solid black;\n" +
                    "}\n" +
                    "</style>");
            out.println("<body><table>" +
                    "<tr>"+
                    "<th>"+"Employee ID"+"</th>"+
                    "<th>"+"First Name"+"</th>"+
                    "<th>"+"Last Name"+"</th>"+
                    "<th>"+"Address"+"</th>"+
                    "<th>"+"Salary"+"</th>"+
                    "<th>"+"Working Days"+"</th>"+
                    "<th>"+"Sick Leave"+"</th>"+
                    "<th>"+"Paid Leave"+"</th>"+
                    "<th>"+"Unpaid Leave"+"</th>"+
                    "</tr>"
            );
            while(rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getString("userid")+"</td>");
                out.println("<td>"+rs.getString("FirstName")+"</td>");
                out.println("<td>"+rs.getString("LastName")+"</td>");
                out.println("<td>"+rs.getString("Address")+"</td>");
                out.println("<td>"+rs.getString("Salary")+"</td>");
                out.println("<td>"+rs.getString("Working")+"</td>");
                out.println("<td>"+rs.getString("Sick")+"</td>");
                out.println("<td>"+rs.getString("Paid")+"</td>");
                out.println("<td>"+rs.getString("Unpaid")+"</td>");
                out.println("</tr>");
            }
            out.println("</table>");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println("<br/><br/>");
        out.println("<button><a href=\"home.jsp\">Home Page</a></button>\n" +
                "<button><a href = \"logout.jsp\">Logout</a></button></body>");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
