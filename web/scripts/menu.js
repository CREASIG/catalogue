/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(function () {
    $(document).ready(function () {
        $("#fleche_menu").click(function () {
            // Si flèche droite, ouverture du menu
            if ($("#fleche_menu > img").attr("src") === "/catalogue/images/flechedroite.png") {
                $("#fleche_menu > img").attr("src", "/catalogue/images/flechegauche.png");
                $(".item_menu > a> div").css("display", "inline");
                $(".menu").css("width", "250px");
                $(".item_menu > a> div").css("line-height", "50px");
            } else
            {
                $("#fleche_menu > img").attr("src", "/catalogue/images/flechedroite.png");
                $(".item_menu > a> div").css("display", "none");
                $(".menu ").css("width", "55px");
                $(".item_menu > a> div").css("line-height", "inherit");
            }
        });
    });
});