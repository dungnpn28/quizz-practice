/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


// Hiển thị thông báo
document.getElementById("notification").style.display = "block";

// Ẩn thông báo sau 5 giây
setTimeout(function () {
    document.getElementById("notification").style.display = "none";
}, 5000);
