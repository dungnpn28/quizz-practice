/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function openPopup() {
    document.getElementById('question-import').classList.add('active');
}

function closePopup() {
    document.getElementById('question-import').classList.remove('active');
}
document.getElementById('fileInput').addEventListener('change', function (event) {
    var file = event.target.files[0];
    // display the id=submit
    var allowedType = 'application/vnd.openxmlformats-officedocument.spreadsheetml.sheet';
    if (file.type !== allowedType) {
        document.getElementById('resultContainer').textContent = "Invalid file type. Only XLSX files are allowed.";
        document.getElementById('submit').style.display = 'none';        
        return;
    } else {
        document.getElementById('resultContainer').textContent = "";
        //hide the id=submit
        document.getElementById('submit').style.display = 'block';

    }
});
function chooseFile() {
    var fileInput = document.getElementById('fileInput');
    fileInput.click();
}

// onchange event

