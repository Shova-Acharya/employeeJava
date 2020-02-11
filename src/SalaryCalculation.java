import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "SalaryCalculation")
public class SalaryCalculation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        DatabaseMethods dm = new DatabaseMethods();

        String uid = request.getParameter("empid");
        try {
            int salary = dm.getSalary(uid);
            int workingDays = dm.getWorkingDays(uid);
            int sickDays = dm.getSickDays(uid);
            int paidLeave = dm.getPaidLeave(uid);
            int unpaidLeave = dm.getUnpaidLeave(uid);
            if((salary == -999) ||(workingDays == -999) ||(sickDays == -999) ||(paidLeave == -999) ||(unpaidLeave == -999))
            {
                out.println("Sorry! Employee ID doesn't exist.");
            } else {
                String employeeName = dm.getEmployeeName(uid);
                int calculatedSalary = (salary / workingDays) * (workingDays - unpaidLeave);
                out.println(String.format("<h1>Calculated salary for %s is Rs.%d</h1>",employeeName,calculatedSalary));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        out.println("<body><br/><br/>");
        out.println("<button><a href=\"home.jsp\">Home Page</a></button>\n" +
                "<button><a href = \"logout.jsp\">Logout</a></button></body>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
