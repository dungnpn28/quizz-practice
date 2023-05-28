/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


$(document).ready(function() {
        var slideIndex = 0;
        showSlide(slideIndex);

        $(".prevButton").on("click", function() {
            showSlide(slideIndex -= 1);
        });

        $(".nextButton").on("click", function() {
            showSlide(slideIndex += 1);
        });

        function showSlide(index) {
            var slides = $(".imageSlider img");
            if (index < 0) {
                slideIndex = slides.length - 1;
            } else if (index >= slides.length) {
                slideIndex = 0;
            }
            slides.hide();
            slides.eq(slideIndex).show();
        }
    });