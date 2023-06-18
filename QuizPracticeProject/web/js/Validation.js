/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function validateInput() {
  var validateName = document.getElementById("input-field");
  if (validateName.value === "") {
    alert("Please enter a value!");
    return false;
  }
  return true;
}

