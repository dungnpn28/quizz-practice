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
function openConfirmationDialogSubjectRegisted(subjectId) {

    var modal = document.getElementById("confirmation-dialog-" + subjectId);
    var confirmYesBtn = document.getElementById("confirm-yes-" + subjectId);
    var confirmNoBtn = document.getElementById("confirm-no-" + subjectId);

    // Show the modal dialog
    modal.style.display = "block";

    // Event handler for "Yes" button
    var form = document.getElementById("subjectregisted-" + subjectId);
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
function validateSubjectRegistedForm() {
    // Lấy giá trị từ các trường input
    var name = document.forms["subjectRegisted"]["name"].value;
    var email = document.forms["subjectRegisted"]["email"].value;
    var phone = document.forms["subjectRegisted"]["phone"].value;


    // Kiểm tra tính hợp lệ của các trường
    if (name === "") {
        alert("Vui lòng nhập tên");
        return false;
    }
    if (email === "") {
        alert("Vui lòng nhập email");
        return false;
    }
    if(phone === "") {
        alert("Vui long nhap so dien thoai");
        return false;
    }
}
$(document).ready(function () {
    $('#sidebarCollapse').on('click', function () {
        $('#sidebar').toggleClass('active');
    });
});