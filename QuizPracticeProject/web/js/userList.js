/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function openConfirmationDialog1() {
    var isValid = validateForm();
    if (isValid) {
        var modal = document.getElementById("confirmation-dialog");
        var confirmYesBtn = document.getElementById("confirm-yes");
        var confirmNoBtn = document.getElementById("confirm-no");

        // Show the modal dialog
        modal.style.display = "block";

        // Event handler for "Yes" button
        var form = document.getElementById("addnew");
        confirmYesBtn.onclick = function () {
            modal.style.display = "none";  // Hide the modal dialog
            $.ajax({
                type: "post",
                url: form.action,
                data: $(form).serialize(),
                success: function (response) {
                    if (response.trim() === "") {
                        Swal.fire({
                            icon: 'warning',
                            title: 'Successfully',
                            text: 'An email with new password has been sent to user. He/She need to verify this account before using',
                            showConfirmButton: false,
                            timer: 2000
                        }).then(function () {
                            // Sau khi pop-up thông báo được đóng, bạn có thể thực hiện các hành động khác tại đây
                            // Ví dụ: làm sạch form, cập nhật giao diện, vv.
                            window.location.href = "userlist"; // Chuyển hướng đến trang "userlist"
                        });
                    } else {
                        Swal.fire({
                            icon: 'error',
                            title: 'Error',
                            text: response
                        }).then(function () {
                            // Có lỗi, hiển thị thông báo lỗi trên popup
                            $("#emailError").html(response);
                        });
                    }
                },
                error: function () {
                    $("#emailError").html("Đã xảy ra lỗi. Vui lòng thử lại.");
                }
            });
        };

        // Event handler for "No" button and modal close button
        confirmNoBtn.onclick = modalCloseHandler;
        modal.querySelector(".close").onclick = modalCloseHandler;

        // Function to handle closing of the modal dialog
        function modalCloseHandler(event) {
            event.preventDefault();
            modal.style.display = "none";  // Hide the modal dialog
        }
    }
}
function openConfirmationDialog(userId) {

    var modal = document.getElementById("confirmation-dialog-" + userId);
    var confirmYesBtn = document.getElementById("confirm-yes-" + userId);
    var confirmNoBtn = document.getElementById("confirm-no-" + userId);

    // Show the modal dialog
    modal.style.display = "block";

    // Event handler for "Yes" button
    var form = document.getElementById("changeuser-" + userId);
    confirmYesBtn.onclick = function () {
        modal.style.display = "none";  // Hide the modal dialog
        form.submit();
        Swal.fire({
            icon: 'success',
            title: 'Successfully',
            text: 'Update successfully!',
            showConfirmButton: false,
            timer: 100
        });

    };

    // Event handler for "No" button and modal close button
    confirmNoBtn.onclick = modalCloseHandler;
    modal.querySelector(".close").onclick = modalCloseHandler;

    // Function to handle closing of the modal dialog
    function modalCloseHandler(event) {
        event.preventDefault();
        modal.style.display = "none";  // Hide the modal dialog
    }
}
function validateEmail() {
    var email = document.getElementById("emailInput").value;
    var emailError = document.getElementById("emailError");

    if (email === "") {
        emailError.textContent = "Email field cannot be empty";
    } else {
        var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

        if (!emailRegex.test(email)) {
            emailError.textContent = "Invalid email format";
        } else {
            emailError.textContent = "";
        }
    }
}

function validateName() {
    var name = document.getElementById("nameInput").value;
    var nameError = document.getElementById("nameError");
    var nameRegex = /^[\p{L}\s]+$/u;

    if (name === "") {
        nameError.textContent = "Name field cannot be empty";
    } else if (!nameRegex.test(name)) {
        nameError.textContent = "Name should not contain digits";
    } else {
        nameError.textContent = "";
    }
}

function validateGender() {
    var female = document.getElementById("femaleInput").checked;
    var male = document.getElementById("maleInput").checked;
    var genderError = document.getElementById("genderError");

    if (!female && !male) {
        genderError.textContent = "Please select a gender";
    } else {
        genderError.textContent = "";
    }
}

function validatePhone() {
    var phone = document.getElementById("phoneInput").value;
    var phoneError = document.getElementById("phoneError");

    if (phone === "" || phone.length !== 10 || !phone.startsWith("0")) {
        phoneError.textContent = "Invalid phone number";
    } else {
        phoneError.textContent = "";
    }
}
function validateDob() {
    var dobInput = document.getElementById("dobInput");
    var dobError = document.getElementById("DobError");

    if (dobInput.value === "") {
        dobError.textContent = "Date of birth field cannot be empty";
    } else {
        var today = new Date();
        var selectedDate = new Date(dobInput.value);
        var age = today.getFullYear() - selectedDate.getFullYear();

        if (age < 16) {
            dobError.textContent = "You must be at least 16 years old";
        } else {
            dobError.textContent = "";
        }
    }
}

function validateForm() {
    validateEmail();
    validateName();
    validateGender();
    validatePhone();
    validateDob();
    // Check if any error message exists
    var emailErrorMessage = document.getElementById("emailError").textContent.trim();
    var nameErrorMessage = document.getElementById("nameError").textContent.trim();
    var genderErrorMessage = document.getElementById("genderError").textContent;
    var phoneErrorMessage = document.getElementById("phoneError").textContent.trim();
    var dobErrorMessage = document.getElementById("DobError").textContent.trim(); // Thêm biến này

    // Return false if any error message exists
    if (emailErrorMessage || nameErrorMessage || genderErrorMessage || phoneErrorMessage || dobErrorMessage) {
        return false;
    }

    // All validations passed, form is valid
    return true;
}
function applyFilters() {
    var genderSelect = document.getElementById("gender");
    var roleSelect = document.getElementById("role");
    var statusSelect = document.getElementById("status");
    var searchInput = document.getElementById("searchInput");

    var gender = genderSelect.options[genderSelect.selectedIndex].value;
    var role = roleSelect.options[roleSelect.selectedIndex].value;
    var status = statusSelect.options[statusSelect.selectedIndex].value;
    var search = searchInput.value;




    // Build your base URL
    var baseUrl = "userlist?";

    if (gender !== "all") {
        baseUrl += "gender=" + gender + "&";
    }
    if (role !== "all") {
        baseUrl += "role=" + role + "&";
    }
    if (status !== "all") {
        baseUrl += "status=" + status + "&";
    }
    if (search.trim() !== "") {
        baseUrl += "search=" + encodeURIComponent(search.trim()) + "&";
    }

    baseUrl = baseUrl.slice(0, -1);
    localStorage.setItem("gender", gender);
    localStorage.setItem("role", role);
    localStorage.setItem("status", status);
    localStorage.setItem("search", search);



    // Redirect to the filtered URL
    window.location.href = baseUrl;
}
$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
});