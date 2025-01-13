@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Example: Forwarding request to a JSP to display grades
    RequestDispatcher dispatcher = request.getRequestDispatcher("/grades.jsp");
    dispatcher.forward(request, response);
}
