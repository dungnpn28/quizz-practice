/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function openAddForm() {
    document.getElementById("add-pricePackage").style.display = "block";
}

function closeAddForm() {
    document.getElementById("add-pricePackage").style.display = "none";
}

function openEditForm(editForm) {
    document.getElementById("edit-pricePackage-" + editForm ).style.display = "block";
}

function closeEditForm(editForm) {
    document.getElementById("edit-pricePackage-" + editForm).style.display = "none";
}