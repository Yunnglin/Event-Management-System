window,onload = function () {
    var login_main = document.getElementById("login_main");
    login_main.onmouseover = function () {
        var surface = document.getElementById("surface");
        var black = document.getElementById("black");
        surface.style.webkitFilter = "blur(10px)";
        surface.style.filter = "blur(10px)";
        black.style.display = 'block';
    }
    login_main.onmouseout = function () {
        var surface = document.getElementById("surface");
        var black = document.getElementById("black");
        surface.style.webkitFilter = "blur(0px)";
        surface.style.filter = "blur(0px)";
        black.style.display = 'none';
    }
}
function loginLeader () {
    document.getElementById("user_type").value="leader";
    document.forms[0].submit();
}
function loginAdmin() {
    document.getElementById("user_type").value="admin";
    document.forms[0].submit();
}
function loginCoach() {
    document.getElementById("user_type").value="coach";
    document.forms[0].submit();
}
