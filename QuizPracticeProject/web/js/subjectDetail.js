/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function openAddForms() {
    document.getElementById("add-pricePackage").style.display = "block";
}

function closeAddForms() {
    document.getElementById("add-pricePackage").style.display = "none";
    document.getElementById("add-pricePackage-close").click();
}

function openEditForms(editForm) {
    document.getElementById("edit-pricePackage-" + editForm).style.display = "block";
}

function closeEditForms(editForm) {
    document.getElementById("edit-pricePackage-" + editForm).style.display = "none";
    document.getElementById("edit-pricePackage-close").click();
}


function validateSubjectName() {
    var subjectName = document.getElementById("subjectName").value;
    var nameError = document.getElementById("nameError");

    if (subjectName.trim() === "") {
        nameError.innerHTML = "Please enter a subject name.";
        return false;
    } else {
        nameError.innerHTML = "";
        return true;
    }
}

function validateDescription() {
    var description = document.getElementById("description").value;
    var descriptionError = document.getElementById("descriptionError");

    if (description.trim() === "") {
        descriptionError.innerHTML = "Please enter a description.";
        return false;
    } else {
        descriptionError.innerHTML = "";
        return true;
    }
}
function validateForm() {
    // Kiểm tra trường "Subject Name"
    var subjectName = document.getElementById("subjectName").value;
    var nameError = document.getElementById("nameError");

    if (subjectName.trim() === "") {
        nameError.innerHTML = "Please enter a subject name.";
        return false;
    } else {
        nameError.innerHTML = "";
    }

    // Kiểm tra trường "Description"
    var description = document.getElementById("description").value;
    var descriptionError = document.getElementById("descriptionError");

    if (description.trim() === "") {
        descriptionError.innerHTML = "Please enter a description.";
        return false;
    } else {
        descriptionError.innerHTML = "";
    }

    // Nếu không có lỗi, cho phép submit form
    return true;
}
function openConfirmationDialogSubject() {
    var isValid = validateForm();
    if (isValid) {
        var modal = document.getElementById("confirmation-dialog");
        var confirmYesBtn = document.getElementById("confirm-yes");
        var confirmNoBtn = document.getElementById("confirm-no");

        // Show the modal dialog
        modal.style.display = "block";

        // Event handler for "Yes" button
        var form = document.getElementById("editoverview");
        confirmYesBtn.onclick = function () {
            modal.style.display = "none";  // Hide the modal dialog
            
            Swal.fire({
                icon: 'success',
                title: 'Successfully',
                text: 'Update subject successflly',
                showConfirmButton: false,
                timer: 1500
            }).then(function () {
                form.submit();
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
function validateFormPricePackageDetail(pricePackageId) {
    var name = document.forms["editForm-"+pricePackageId]["name"].value;
    var description = document.forms["editForm-"+pricePackageId]["description"].value;
    var duration = document.forms["editForm-"+pricePackageId]["duration"].value;
    var price = document.forms["editForm-"+pricePackageId]["price"].value;
    var sale = document.forms["editForm-"+pricePackageId]["sale"].value;

    var nameError = document.getElementById("namePackageError");
    var descriptionError = document.getElementById("descriptionPackageError");
    var durationError = document.getElementById("durationPackageError");
    var listPriceError = document.getElementById("listPricePackageError");
    var salePriceError = document.getElementById("salePricePackageError");

    // Reset errors
    nameError.innerHTML = "";
    descriptionError.innerHTML = "";
    durationError.innerHTML = "";
    listPriceError.innerHTML = "";
    salePriceError.innerHTML = "";

    // Validate name
    if (name.trim() === "") {
        nameError.innerHTML = "Please enter a name.";
        return false;
    }

    // Validate description
    if (description.trim() === "") {
        descriptionError.innerHTML = "Please enter a description.";
        return false;
    }

    // Validate duration
    if (duration.trim() === "") {
        durationError.innerHTML = "Please enter a duration.";
        return false;
    }

    // Validate price
    if (price.trim() === "") {
        listPriceError.innerHTML = "Please enter a list price.";
        return false;
    }

    // Validate sale price
    if (sale.trim() === "") {
        salePriceError.innerHTML = "Please enter a sale price.";
        return false;
    }

    return true;
}