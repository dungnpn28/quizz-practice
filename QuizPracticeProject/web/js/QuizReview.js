/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
function openExitPopup() {
    document.getElementById('exit-popup').classList.add('active');
}

function closeExitPopup() {
    document.getElementById('exit-popup').classList.remove('active');
}
function openPopup() {
    document.getElementById('popup').classList.add('active');
}

function closePopup() {
    document.getElementById('popup').classList.remove('active');
}
function openPeekPopup() {
    document.getElementById('peek-popup').classList.add('active');
}

function closePeekPopup() {
    document.getElementById('peek-popup').classList.remove('active');
}
function filterIncorrectAnswer() {
    displayAllQuestion();
    document.querySelectorAll(".correct").forEach(o => rerender(o));
}

function filterCorrectAnswer() {
    displayAllQuestion();
    document.querySelectorAll(".incorrect").forEach(o => rerender(o));
}

function rerender(o) {
    let questNavi = document.querySelector(".question-navigation");
    o.style.display = 'none';
    let tempNode = document.createElement("a");
    tempNode.classList.add("temp");
    questNavi.appendChild(tempNode);
}

function filterMarkedAnswer() {
    displayAllQuestion();
    document.querySelectorAll("#unmarked").forEach(o => rerender(o));
}

function displayAllQuestion() {
    document.querySelectorAll(".temp").forEach(o => o.remove());
    document.querySelectorAll(".correct").forEach(o => o.style.display = null);
    document.querySelectorAll(".incorrect").forEach(o => o.style.display = null);
    document.querySelectorAll("#unmarked").forEach(o => o.style.display = null);
}
