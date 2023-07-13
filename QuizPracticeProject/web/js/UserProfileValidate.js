/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function validateForm() {
        var phoneInput = document.forms["userProfileForm"]["phonenum"];
        var dobInput = document.forms["userProfileForm"]["dob"];

        // Phone number validation
        var phoneRegex = /^0\d{9}$/;
        if (!phoneRegex.test(phoneInput.value)) {
            alert("Phone number must be 10 digits starting with 0.");
            return false;
        }

        // Date of birth validation
        var dob = new Date(dobInput.value);
        var today = new Date();
        var age = today.getFullYear() - dob.getFullYear();
        var monthDiff = today.getMonth() - dob.getMonth();
        if (monthDiff < 0 || (monthDiff === 0 && today.getDate() < dob.getDate())) {
            age--;
        }
        if (age < 16) {
            alert("You must be at least 16 years old.");
            return false;
        }

        return true;
        
    }

    document.getElementById("userProfileForm").addEventListener("submit", function (event) {
        if (!validateForm()) {
            event.preventDefault();
        }
        alert("Update profile successfully");
    });
