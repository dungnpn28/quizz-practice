/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function validatePassword() {
    var password = document.getElementById("password").value;
    var passwordError = document.getElementById("passwordError");

    if (password.length < 6 || password.length > 20) {
        passwordError.textContent = "Password should be at between 6 and 20 characters long.";
    } else if (!/[!@#$%^&*(),.?":{}|<>]/.test(password) && !/[A-Z]/.test(password)) {
        passwordError.textContent = "Password should contain at least one special character or one uppercase letter.";
    } else {
        passwordError.textContent = "";
    }

    enableOrDisableSubmitButton();
}

function validateRepassword() {
    var password = document.getElementById("password").value;
    var repassword = document.getElementById("repassword").value;
    var repasswordError = document.getElementById("repasswordError");

    if (repassword.length < 6 || repassword.length > 20) {
        repasswordError.textContent = "Password should be at between 6 and 20 characters long.";
    } else if (!/[!@#$%^&*(),.?":{}|<>]/.test(repassword) && !/[A-Z]/.test(repassword)) {
        repasswordError.textContent = "Password should contain at least one special character or one uppercase letter.";
    } else if (password !== repassword) {
        repasswordError.textContent = "Passwords do not match.";
    } else {
        repasswordError.textContent = "";
    }

    enableOrDisableSubmitButton();
}

function enableOrDisableSubmitButton() {
    var passwordError = document.getElementById("passwordError").textContent;
    var repasswordError = document.getElementById("repasswordError").textContent;
    var submitButton = document.getElementById("submitButton");

    if (passwordError === "" && repasswordError === "") {
        submitButton.disabled = false;
    } else {
        submitButton.disabled = true;
    }
}

function validateForm() {
    var password = document.getElementById("password").value;
    var repassword = document.getElementById("repassword").value;
    var passwordError = document.getElementById("passwordError");
    var repasswordError = document.getElementById("repasswordError");

    if (password.length < 6 || password.length > 20) {
        passwordError.textContent = "Password should be at between 6 and 20 characters long.";
        return false;
    } else if (!/[!@#$%^&*(),.?":{}|<>]/.test(password) && !/[A-Z]/.test(password)) {
        passwordError.textContent = "Password should contain at least one special character or one uppercase letter.";
        return false;
    } else {
        passwordError.textContent = "";
    }

    if (repassword.length < 6 || repassword.length > 20) {
        repasswordError.textContent = "Password should be at between 6 and 20 characters long.";
        return false;
    } else if (!/[!@#$%^&*(),.?":{}|<>]/.test(repassword) && !/[A-Z]/.test(repassword)) {
        repasswordError.textContent = "Password should contain at least one special character or one uppercase letter.";
        return false;
    } else if (password !== repassword) {
        repasswordError.textContent = "Passwords do not match.";
        return false;
    } else {
        repasswordError.textContent = "";
    }

    return true;
}
        