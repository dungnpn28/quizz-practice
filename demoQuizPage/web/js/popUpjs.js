/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
//xuất hiện popup
document.getElementById("forgotPasswordLink").addEventListener("click", function (event) {
    event.preventDefault();
    document.getElementById("forgotPasswordModal").style.display = "block";
});

document.getElementsByClassName("close")[0].addEventListener("click", function () {
    document.getElementById("forgotPasswordModal").style.display = "none";
});
//làm thông báo hiện ngay trên popup
$(document).ready(function () {
    $('#forgotPasswordLink').click(function (event) {
        event.preventDefault();

        $('#forgotPasswordModal').modal('show');
        $('#forgotPasswordForm').submit(function (event) {
            event.preventDefault();

            var pass1 = $('#pass1').val();
            var pass2 = $('#pass2').val();
            if (pass1 !== pass2) {
                $('#popupMessage').text('Mật khẩu và nhập lại mật khẩu không khớp').show();
                return;
            }
            // Gửi yêu cầu Ajax khi cửa sổ pop-up được hiển thị
            $.ajax({
                url: 'changePassword',
                type: 'POST',
                data: {password: password},
                success: function (response) {
                    if (response.error) {
                        $('#popupMessage').text(response).show(); // Hiển thị thông báo từ servlet trong cửa sổ pop-up
                    } else {
                        $('#popupMessage').hide();
                    }
                },
                error: function () {
                    $('#popupMessage').text('Có lỗi xảy ra').show(); // Hiển thị thông báo lỗi nếu yêu cầu không thành công
                }
            });
        });
    });
});


