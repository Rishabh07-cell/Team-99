// validation.js
document.getElementById("loginForm").addEventListener("submit", function (event) {
    event.preventDefault(); // Prevent form submission

    // Get form values
    const userId = document.getElementById("userId").value;
    const password = document.getElementById("password").value;

    // Error elements
    const userIdError = document.getElementById("userIdError");
    const passwordError = document.getElementById("passwordError");

    // Clear previous errors
    userIdError.textContent = "";
    passwordError.textContent = "";

    let isValid = true;

    // Validate User ID
    if (!validateUserId(userId)) {
        userIdError.textContent = "User ID must be 5-15 alphanumeric characters.";
        isValid = false;
    }

    // Validate Password
    if (!validatePassword(password)) {
        passwordError.textContent = "Password must be at least 8 characters long, with uppercase, lowercase, number, and special character.";
        isValid = false;
    }

    // Submit form if valid
    if (isValid) {
        alert("Login successful!");
        this.submit();
    }
});

// Function to validate User ID
function validateUserId(userId) {
    const userIdRegex = /^[a-zA-Z0-9]{5,15}$/; // Alphanumeric, 5-15 chars
    return userIdRegex.test(userId);
}

// Function to validate Password
function validatePassword(password) {
    const passwordRegex = /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[@$!%*?&])[A-Za-z\d@$!%*?&]{8,}$/;
    return passwordRegex.test(password);
}
