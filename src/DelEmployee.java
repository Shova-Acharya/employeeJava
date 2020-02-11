import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "DelEmployee")
public class DelEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        DatabaseMethods dm = new DatabaseMethods();
        String uid = request.getParameter("empid");
        String first = request.getParameter("fname");
        String last = request.getParameter("lname");

        try {
            dm.delEmployee(uid,first,last);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("<body> Employee Successfully Deleted <br/><br/>");
        out.println("<button><a href=\"home.jsp\">Home Page</a></button>\n" +
                "<button><a href = \"logout.jsp\">Logout</a></button></body>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
