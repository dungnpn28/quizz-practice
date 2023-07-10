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
function openAddDimensionForms() {
    document.getElementById("add-dimension").style.display = "block";
}

function closeAddDimensionForms() {
    document.getElementById("add-dimension").style.display = "none";
    document.getElementById("add-dimension-close").click();
}

function openEditForms(editForm) {
    document.getElementById("edit-pricePackage-" + editForm).style.display = "block";
}

function closeEditForms(editForm) {
    document.getElementById("edit-pricePackage-" + editForm).style.display = "none";
    document.getElementById("edit-pricePackage-close").click();
}
function openEditDimensionForms(editForm) {
    document.getElementById("edit-dimension-" + editForm).style.display = "block";
}

function closeEditDimensionForms(editForm) {
    document.getElementById("edit-dimension-" + editForm).style.display = "none";
    document.getElementById("edit-dimension-close").click();
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
function abc(dimensionId, subjectId, tag) {
    var isValid = validateDimensionForm(dimensionId);
    if (isValid) {
        var modal = document.getElementById("confirmation-dialog-" + dimensionId);
        var confirmYesBtn = document.getElementById("confirm-yes-" + dimensionId);
        var confirmNoBtn = document.getElementById("confirm-no-" + dimensionId);

        // Show the modal dialog
        modal.style.display = "block";

        // Event handler for "Yes" button
        var form = document.getElementById("edit-dimension-detail-" + dimensionId);
        confirmYesBtn.onclick = function () {
            modal.style.display = "none";  // Hide the modal dialog
            $.ajax({
                type: "post",
                url: form.action,
                data: $(form).serialize(),
                success: function (response) {
                    if (response.trim() === "") {
                        Swal.fire({
                            icon: 'success',
                            title: 'Successfully',
                            text: 'Dimension has been updated successfully!',
                            showConfirmButton: false,
                            timer: 2000
                        }).then(function () {
                            window.location.href = "subjectdetailae?subjectId=" + subjectId + "&indexD=" + tag + "&tab=profile";
                        });
                    }
                },
                error: function () {
                    Swal.fire({
                        icon: 'warning',
                        title: 'Successfully',
                        text: 'Dimension has been updated successfully!',
                        showConfirmButton: false,
                        timer: 2000
                    });
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
function openAddConfirmationDialog(subjectId, tag) {
    var isValid = validateDimensionForms();
    if (isValid) {
        var modal = document.getElementById("confirmation-dialog");
        var confirmYesBtn = document.getElementById("confirm-yes");
        var confirmNoBtn = document.getElementById("confirm-no");

        // Show the modal dialog
        modal.style.display = "block";

        // Event handler for "Yes" button
        var form = document.getElementById("addDimensionForm");
        confirmYesBtn.onclick = function () {
            modal.style.display = "none";  // Hide the modal dialog
            $.ajax({
                type: "post",
                url: form.action,
                data: $(form).serialize(),
                success: function (response) {
                    if (response.trim() === "") {
                        Swal.fire({
                            icon: 'success',
                            title: 'Successfully',
                            text: 'Dimension has been added successfully!',
                            showConfirmButton: false,
                            timer: 2000
                        }).then(function () {
                            window.location.href = "subjectdetailae?subjectId=" + subjectId + "&indexD=" + tag + "&tab=profile";
                        });
                    }
                },
                error: function () {
                    Swal.fire({
                        icon: 'warning',
                        title: 'Successfully',
                        text: 'Dimension has been updated successfully!',
                        showConfirmButton: false,
                        timer: 2000
                    });
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
function openDeleteConfirmation(dimensionId, subjectId, tag) {


    var modal = document.getElementById("confirmation-dialog-" + dimensionId);
    var confirmYesBtn = document.getElementById("confirm-yes-" + dimensionId);
    var confirmNoBtn = document.getElementById("confirm-no-" + dimensionId);

    // Show the modal dialog
    modal.style.display = "block";

    // Event handler for "Yes" button

    confirmYesBtn.onclick = function () {
        modal.style.display = "none";  // Hide the modal dialog
        $.ajax({
            type: "post",
            url: "deletedimension", // Replace with your delete dimension endpoint URL
            data: {dimensionId: dimensionId, subjectId: subjectId},
            success: function (response) {
                // Handle success response
                Swal.fire({
                    icon: 'success',
                    title: 'Successfully',
                    text: 'Dimension has been deleted successfully!',
                    showConfirmButton: false,
                    timer: 2000
                }).then(function () {
                    // Redirect to desired location
                    window.location.href = "subjectdetailae?subjectId=" + subjectId + "&indexD=" + tag + "&tab=profile";
                });
            },
            error: function () {
                // Handle error response
                Swal.fire({
                    icon: 'error',
                    title: 'Error',
                    text: 'Failed to delete dimension.',
                    showConfirmButton: false,
                    timer: 2000
                });
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
function validateNameInput(dimensionId) {
        var name = document.getElementById("name-"+dimensionId).value;
    var nameError = document.getElementById("nameDimensionError-"+dimensionId);

    if (name.trim() === "") {
        nameError.textContent = "Name is required.";
         // Return false to indicate validation failure
    } else {
        nameError.textContent = "";
         // Return true to indicate validation success
    }
}

function validateDescriptionInput(dimensionId) {
var description = document.getElementById("description-"+dimensionId).value;
   
    var descriptionError = document.getElementById("descriptionDimensionError-"+dimensionId);

    if (description.trim() === "") {
        descriptionError.innerText = "Description is required.";
    } else {
        descriptionError.innerText = "";
    }
}

function validateDimensionForm(dimensionId) {
     var nameInput = document.getElementById("name-"+dimensionId).value;
    var descriptionInput = document.getElementById("description-"+dimensionId).value;
    var nameError = document.getElementById("nameDimensionError-"+dimensionId);
    var descriptionError = document.getElementById("descriptionDimensionError-"+dimensionId);

    if(nameInput.trim() === ""){
        nameError.innerHTML = "Name is required";
    
    }else{
        nameError.innerHTML="";
    }
    if(descriptionInput.trim() === ""){
        descriptionError.innerHTML = "description is required";
      
    }else{
        descriptionError.innerHTML="";
    }
    if(nameError.innerHTML.trim() !== "" ||descriptionError.innerHTML.trim() !== "") return false;

   

    // All validations passed, form is valid
    return true;
}
function validateNameInputs() {
        var name = document.getElementById("names").value;


    var nameError = document.getElementById("nameDimensionErrors");

    if (name.trim() === "") {
        nameError.innerText = "Name is required.";
    } else {
        nameError.innerText = "";
    }
}

function validateDescriptionInputs() {
var description = document.getElementById("descriptions").value;
   
    var descriptionError = document.getElementById("descriptionDimensionErrors");

    if (description.trim() === "") {
        descriptionError.innerText = "Description is required.";
    } else {
        descriptionError.innerText = "";
    }
}
function validateDimensionForms() {
    var nameInput = document.getElementById("names").value;
    var descriptionInput = document.getElementById("descriptions").value;
    var nameError = document.getElementById("nameDimensionErrors");
    var descriptionError = document.getElementById("descriptionDimensionErrors");

    if(nameInput.trim() === ""){
        nameError.innerHTML = "Name is required";
    
    }else{
        nameError.innerHTML="";
    }
    if(descriptionInput.trim() === ""){
        descriptionError.innerHTML = "description is required";
      
    }else{
        descriptionError.innerHTML="";
    }
    if(nameError.innerHTML.trim() !== "" ||descriptionError.innerHTML.trim() !== "") return false;

   

    // All validations passed, form is valid
    return true;
//    var subjectName = document.getElementById("subjectName").value;
//    var nameError = document.getElementById("nameError");
//
//    if (subjectName.trim() === "") {
//        nameError.innerHTML = "Please enter a subject name.";
//        return false;
//    } else {
//        nameError.innerHTML = "";
//    }
//
//    // Kiểm tra trường "Description"
//    var description = document.getElementById("description").value;
//    var descriptionError = document.getElementById("descriptionError");
//
//    if (description.trim() === "") {
//        descriptionError.innerHTML = "Please enter a description.";
//        return false;
//    } else {
//        descriptionError.innerHTML = "";
//    }
//
//    // Nếu không có lỗi, cho phép submit form
//    return true;
}

function validateFormPricePackageDetail(pricePackageId) {
    var name = document.forms["editForm-" + pricePackageId]["name"].value;
    var description = document.forms["editForm-" + pricePackageId]["description"].value;
    var duration = document.forms["editForm-" + pricePackageId]["duration"].value;
    var price = document.forms["editForm-" + pricePackageId]["price"].value;
    var sale = document.forms["editForm-" + pricePackageId]["sale"].value;

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
function chooseFile() {
    document.getElementById("fileInput").click();
}

var loadFile = function (event) {
    var output = document.getElementById('imagePreview');
    output.src = URL.createObjectURL(event.target.files[0]);
    output.onload = function () {
        URL.revokeObjectURL(output.src) // free memory
    }
};
function validateFormPricePackageDetail(formId) {
    var form = document.getElementById("editeditPricePackagedetail-" + formId);
    var nameInput = form.elements["name"];
    var descriptionInput = form.elements["description"];
    var durationInput = form.elements["duration"];
    var priceInput = form.elements["price"];
    var saleInput = form.elements["sale"];

    var nameError = document.getElementById("namePackageError-" + formId);
    var descriptionError = document.getElementById("descriptionPackageError-" + formId);
    var durationError = document.getElementById("durationPackageError-" + formId);
    var listPriceError = document.getElementById("listPricePackageError-" + formId);
    var salePriceError = document.getElementById("salePricePackageError-" + formId);

    var isNameValid = true;
    var isDescriptionValid = true;
    var isDurationValid = true;
    var isPriceValid = true;
    var isSaleValid = true;

    // Clear previous error messages
    nameError.innerHTML = "";
    descriptionError.innerHTML = "";
    durationError.innerHTML = "";
    listPriceError.innerHTML = "";
    salePriceError.innerHTML = "";

    // Validate name
    if (nameInput.value.trim() === "") {
        nameError.innerHTML = "Package's Name is required.";
        isNameValid = false;
    } else {
        isNameValid = true;
    }

    // Validate description
    if (descriptionInput.value.trim() === "") {
        descriptionError.innerHTML = "Description is required.";
        isDescriptionValid = false;
    } else {
        isDescriptionValid = true;
    }

    // Validate duration
    if (durationInput.value.trim() === "") {
        durationError.innerHTML = "Duration is required.";
        isDurationValid = false;
    } else {
        var duration = parseInt(durationInput.value);
        if (isNaN(duration) || duration <= 0 || !Number.isInteger(duration)) {
            durationError.innerHTML = "Duration must be a positive integer.";
            isDurationValid = false;
        } else {
            isDurationValid = true;
        }
    }

    // Validate list price
    if (priceInput.value.trim() === "") {
        listPriceError.innerHTML = "List Price is required.";
        isPriceValid = false;
    } else {
        var price = parseInt(priceInput.value);
        if (isNaN(price) || price <= 100 || !Number.isInteger(price)) {
            listPriceError.innerHTML = "List Price must be an integer greater than 100.";
            isPriceValid = false;
        } else {
            isPriceValid = true;
        }
    }

    // Validate sale price
    if (saleInput.value.trim() === "") {
        salePriceError.innerHTML = "Sale Price is required.";
        isSaleValid = false;
    } else {
        var sale = parseInt(saleInput.value);
        if (isNaN(sale) || sale < 0 || sale >= price || !Number.isInteger(sale)) {
            salePriceError.innerHTML = "Sale Price must be a positive integer smaller than List Price.";
            isSaleValid = false;
        } else {
            isSaleValid = true;
        }
    }

    if (isNameValid && isDescriptionValid && isDurationValid && isPriceValid && isSaleValid) {
        // All fields are valid
        return true;
    } else {
        // At least one field is invalid, prevent form submission
        event.preventDefault();
        return false;
    }
}
function goToTab(tab, subjectId) {
    var url = "/QuizPracticeProject/subjectdetailae?subjectId=" + subjectId + "&tab=" + tab;



    window.location.href = url;
}