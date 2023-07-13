/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(document).ready(function () {
    $("form[name^='subjectRegisted']").submit(function (event) {
        event.preventDefault(); // Ngăn chặn việc gửi form mặc định

        var form = $(this);
        var url = form.attr("action");

        $.ajax({
            type: "POST",
            url: url,
            data: form.serialize(),
            success: function (response) {
                if (response.trim() === "") {
                    // Không có lỗi, chuyển về trang Home.jsp
                    window.location.href = "cusHome";
                } else {
                    // Có lỗi, hiển thị thông báo lỗi trên popup
//                    $("#errorMessage").html(response);
                    alert(response);
                }
            },
            error: function () {
                $("#errorMessage").html("Đã xảy ra lỗi. Vui lòng thử lại.");
            }
        });
    });
});

function validateSubjectRegistedForm(id) {
    // Lấy giá trị từ các trường input
    var name = document.forms["subjectRegisted-" + id]["name"].value;
    var email = document.forms["subjectRegisted-" + id]["email"].value;
    var phone = document.forms["subjectRegisted-" + id]["phone"].value;
    var dob = document.forms["subjectRegisted-" + id]["dob"].value;

    // Kiểm tra tính hợp lệ của các trường
    if (name === "") {
        alert("Please enter name");
        return false;
    }
    var nameRegex = /^[\p{L}\s]+$/u;
    if (!nameRegex.test(name)) {
        alert("Name cannot contains digits");
        return false;
    }
    if (email === "") {
        alert("Please enter email");
        return false;
    }
    var emailRegex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;

    if (!emailRegex.test(email)) {
        alert("Email is invalid");
        return false;
    }

    if (phone === "") {
        alert("Please enter phone number");
        return false;
    }
    if (phone === "" || phone.length !== 10 || !phone.startsWith("0")) {
        alert("Phone number is invalid");
        return false;
    }
    if (dob === "") {
        alert("Please enter date of birth");
        return false;
    }
    var today = new Date();
    var selectedDate = new Date(dob.value);
    var age = today.getFullYear() - selectedDate.getFullYear();
    if (age < 16) {
        alert("You must be at least 16 years old");
        return false;
    }
}
$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
});

function hideNotification() {
    var notification = document.getElementById("notification");
    notification.classList.add("hidden");
}

document.addEventListener("DOMContentLoaded", function () {
    var notification = document.getElementById("notification");

    // Hiển thị thông báo
    notification.classList.remove("hidden");

    // Thiết lập nội dung thông báo
    var notificationContent = document.getElementById("notificationContent");
    notificationContent.textContent = "Registed seccessfully";

    // Tạo thanh tiến trình
    var progressBar = document.getElementById("progressBar");

    // Đặt thời gian hiển thị và khoảng thời gian còn lại
    var displayTime = 2000; // Thời gian hiển thị (miligiây)
    var remainingTime = displayTime; // Khoảng thời gian còn lại (ban đầu bằng thời gian hiển thị)

    // Cập nhật thanh tiến trình
    var intervalId = setInterval(function () {
        remainingTime -= 100;
        var progress = (remainingTime / displayTime) * 100;
        progressBar.style.width = progress + "%";

        if (remainingTime <= 0) {
            clearInterval(intervalId);
            notification.classList.add("hidden");
        }
    }, 100);
});

function openSubjectRegistedForm(editForm) {
    document.getElementById("edit-subjectRegister-" + editForm).style.display = "block";
}

function closeSubjectRegistedForm(editForm) {
    document.getElementById("edit-subjectRegister-" + editForm).style.display = "none";
}

