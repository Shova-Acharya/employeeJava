import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "SignIn")
public class SignIn extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String  uname = request.getParameter("firstname");
        String pw = request.getParameter("pass");
        DatabaseMethods dm = new DatabaseMethods();

        try {
            if(dm.checkUsernameLogin(uname,pw))  {
                RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
                rd.forward(request,response);
            } else {
                System.out.println("ohh shit");
                RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
                rd.forward(request,response);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

