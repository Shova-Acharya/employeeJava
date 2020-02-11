import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

@WebServlet(name = "Attendance")
public class Attendance extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        DatabaseMethods dm = new DatabaseMethods();
        String uid = request.getParameter("uid");
        int uwork = Integer.parseInt(request.getParameter("work"));
        int usick = Integer.parseInt(request.getParameter("sick"));
        int upaid = Integer.parseInt(request.getParameter("paid"));
        int unpd = Integer.parseInt(request.getParameter("unpaid"));

        try {
            dm.attendance(uid, uwork, usick, upaid, unpd);
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

