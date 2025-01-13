@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String dob = request.getParameter("dob");
        String gender = request.getParameter("gender");
        String password = request.getParameter("password");

        // Create a new Student object and save it to the database
        Student newStudent = new Student(firstName, lastName, dob, gender, password);
        boolean isRegistered = StudentDAO.registerStudent(newStudent);

        if (isRegistered) {
            response.sendRedirect("login.jsp");
        } else {
            response.sendRedirect("register.jsp?error=Registration+failed");
        }
    }
}
