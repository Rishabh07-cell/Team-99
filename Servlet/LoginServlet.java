import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String studentID = request.getParameter("studentID");
        String password = request.getParameter("password");

        Student student = StudentDatabase.findStudentById(studentID);
        if (student != null && student.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("student", student);
            response.sendRedirect("viewGrades.jsp");
        } else {
            response.sendRedirect("login.jsp?error=Invalid+credentials");
        }
    }
}
