import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/viewGrades")
public class ViewGradesServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(false);
        if (session != null && session.getAttribute("student") != null) {
            Student student = (Student) session.getAttribute("student");
            request.setAttribute("student", student);
            request.getRequestDispatcher("viewGrades.jsp").forward(request, response);
        } else {
            response.sendRedirect("login.jsp");
        }
    }
}
