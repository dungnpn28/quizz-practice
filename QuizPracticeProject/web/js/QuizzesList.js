/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */

function clearFilters() {
    
    window.location.href = "quizlist";
}
function applyFilters() {
    var categorySelect = document.getElementById("filter1");

    var search_bar = document.getElementById("search-bar");

    var category = categorySelect.options[categorySelect.selectedIndex].value;

    var search = search_bar.value;




    // Build your base URL
    var baseUrl = "quizlist?";

    if (category !== "all") {
        baseUrl += "category=" + category + "&";
    }

    if (search.trim() !== "") {
        baseUrl += "search=" + encodeURIComponent(search.trim()) + "&";
    }

    baseUrl = baseUrl.slice(0, -1);

    localStorage.setItem("category", category);
    localStorage.setItem("search", search);



    // Redirect to the filtered URL
    window.location.href = baseUrl;
}
