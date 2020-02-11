import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "AddEmployee")
public class AddEmployee extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        DatabaseMethods dm = new DatabaseMethods();
        String uid = request.getParameter("empid");
        String first = request.getParameter("fname");
        String last = request.getParameter("lname");
        String address = request.getParameter("address");
        int salary = Integer.parseInt(request.getParameter("salary"));
        int working = Integer.parseInt(request.getParameter("working"));
        int sick = Integer.parseInt(request.getParameter("sick"));
        int paid = Integer.parseInt(request.getParameter("paid"));
        int unpaid = Integer.parseInt(request.getParameter("unpaid"));

        try {
            dm.addEmployee(uid,first,last,address,salary, working, sick, paid, unpaid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        out.println("<body> Employee Successfully Added <br/><br/>");
        out.println("<button><a href=\"home.jsp\">Home Page</a></button>\n" +
                "<button><a href = \"logout.jsp\">Logout</a></button></body>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
