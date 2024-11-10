// Add an event listener to the login form to handle form submission
document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault(); // Prevents the form from submitting the traditional way
    const studentId = document.getElementById('studentId').value; // Get the entered student ID
    
    // Call a function to fetch grades for the entered student ID
    fetchGrades(studentId);
});

// Function to fetch grades based on student ID
function fetchGrades(studentId) {
    // Simulating fetching data from a server with hard-coded grades
    const grades = {
        'Math': 'A',
        'Science': 'B+',
        'History': 'A-'
    };
    
    //
