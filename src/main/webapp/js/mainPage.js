window.onunload = function(){
    var epd=new Date();
    epd.setDate(epd.getDate()+7);
    document.cookie="pg="+document.getElementById("submit_choose").selectedIndex+";expires="+epd.toGMTString();
}
window.onload = function(){
    var i=0;
    var gck = document.cookie.split("; ");
    if(gck[0].split("=")[0]=="pg"){
        i = parseInt(gck[i].split("=")[1]);
    }
    document.getElementById("submit_choose").selectedIndex = i;
    selectRole();
}

// function setGroup() {
//     var age = document.getElementById("a_age");
//     var group = document.getElementById("select_group");
//     var a = age.value;
//     if (a<9){
//         group.v
//     }else if (a>8&&a<11){
//
//     } else if(a>10){
//
//     }
// }

function selectRole() {
    var lPage = document.getElementById("leaderPage");
    var dPage = document.getElementById("doctorPage");
    var rPage = document.getElementById("refereePage");
    var athletePage = document.getElementById("athletePage");
    var coachPage = document.getElementById("coachPage");
    var option = document.getElementById("submit_choose");
    switch (option.value) {
        case "leader":
            lPage.style.display = 'block';
            dPage.style.display = 'none';
            rPage.style.display = 'none';
            athletePage.style.display = 'none';
            coachPage.style.display = 'none';
            break;
        case "doctor":
            dPage.style.display = 'block';
            lPage.style.display = 'none';
            rPage.style.display = 'none';
            athletePage.style.display = 'none';
            coachPage.style.display = 'none';
            break;
        case "referee":
            rPage.style.display = 'block';
            dPage.style.display = 'none';
            lPage.style.display = 'none';
            athletePage.style.display = 'none';
            coachPage.style.display = 'none';
            break;
        case "athlete":
            lPage.style.display = 'none';
            athletePage.style.display = 'block';
            coachPage.style.display = 'none';
            dPage.style.display = 'none';
            rPage.style.display = 'none';
            break;
        case "coach":
            lPage.style.display = 'none';
            athletePage.style.display = 'none';
            coachPage.style.display = 'block';
            dPage.style.display = 'none';
            rPage.style.display = 'none';
            break;
        default:
            break;
    }
}

function selectSex() {
    var sex = document.getElementsByClassName("select_sex")[0];
    var maleEvent = document.getElementById("male_event");
    var femaleEvent = document.getElementById("female_event");
    var option = document.getElementById("submit_choose");
    if (option.value === "athlete") {
        switch (sex.value) {
            case "男":
                maleEvent.style.display = 'block';
                femaleEvent.style.display = 'none';
                break;
            case "女":
                maleEvent.style.display = 'none';
                femaleEvent.style.display = 'block';
                break;
            default:
                break;
        }
    }


}