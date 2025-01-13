@Override
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Example: Handling form data for adding a course
    String courseName = request.getParameter("courseName");
    int credits = Integer.parseInt(request.getParameter("credits"));
    double score = Double.parseDouble(request.getParameter("score"));

    // Process and save the data (e.g., in a database or session)
    // Redirect or forward to a confirmation page
    response.sendRedirect("confirmation.jsp");
}
