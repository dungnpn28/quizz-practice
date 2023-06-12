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
$(document).ready(function () {
    $("#registerform").submit(function (event) {
        event.preventDefault(); // Ngăn chặn việc gửi form mặc định

        var form = $(this);
        var url = form.attr("action");

        $.ajax({
            type: "post",
            url: url,
            data: form.serialize(),
            success: function (response) {
                $("#errorMessage2").html(response);
            },
            error: function () {
                $("#errorMessage2").html("Đã xảy ra lỗi. Vui lòng thử lại.");
            }
        });
    });
});
$(document).ready(function () {
    // Event listener for clicking the user info link
    $(".user-info-link").click(function (e) {
        e.preventDefault();

        // Get the user ID from the data attribute
        var userId = $(this).data("user-id");

        // Build the URL with the user ID
        var url = "userinformation?userId=" + userId;

        // Call the showUserInfo function with the URL
        showUserInfo(url);
    });

    // Function to show user information in the modal
    function showUserInfo(url) {
        // Make an AJAX request to fetch user data based on the URL
        $.ajax({
            type: "GET",
            url: url,
           
            success: function (response) {
                // Update the modal body with the user information
                $("#userInfoModalBody").html(response);

                // Show the modal window
                $("#userInfoModal").modal("show");
            },
            error: function () {
                console.log("An error occurred while fetching user information.");
            }
        });
    }
    
});


           


               
// Show the modal window



document.getElementById("popUpLink").addEventListener("click", function (event) {
    event.preventDefault();
    document.getElementById("popUpModal").style.display = "block";
});
document.getElementById("popUpLink2").addEventListener("click", function (event) {
    event.preventDefault();
    document.getElementById("popUpModal2").style.display = "block";
});
