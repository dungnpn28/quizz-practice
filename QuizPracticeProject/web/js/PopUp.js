/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

  
$(document).ready(function () {
    $("#changePasswordForm").submit(function (event) {
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
                    $("#errorMessage").html(response);
                }
            },
            error: function () {
                $("#errorMessage").html("Đã xảy ra lỗi. Vui lòng thử lại.");
            }
        });
    });
});
$(document).ready(function () {
    $("#loginform").submit(function (event) {
        event.preventDefault(); // Ngăn chặn việc gửi form mặc định

        var form = $(this);
        var url = form.attr("action");

        $.ajax({
            type: "post",
            url: url,
            data: form.serialize(),
            success: function (response) {
                if (response.trim() === "") {
                    // Không có lỗi, chuyển về trang Home.jsp
                    window.location.href = "cusHome";
                } else {
                    // Có lỗi, hiển thị thông báo lỗi trên popup
                    $("#errorMessage").html(response);
                }
            },
            error: function () {
                $("#errorMessage").html("Đã xảy ra lỗi. Vui lòng thử lại.");
            }
        });
    });
});

document.getElementById("popUpLink").addEventListener("click", function (event) {
    event.preventDefault();
    document.getElementById("popUpModal").style.display = "block";
});
