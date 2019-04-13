window.onload = function () {

}
function selectRole() {
    var LDRPage = document.getElementById("leader_doctor_refereePage");
    var athletePage = document.getElementById("athletePage");
    var coachPage = document.getElementById("coachPage");
    var option = document.getElementById("submit_choose");
    switch (option.value) {
        case "leader":
            LDRPage.style.display = 'block';
            athletePage.style.display = 'none';
            coachPage.style.display = 'none';
            break;
        case "doctor":
            LDRPage.style.display = 'block';
            athletePage.style.display = 'none';
            coachPage.style.display = 'none';
            break;
        case "referee":
            LDRPage.style.display = 'block';
            athletePage.style.display = 'none';
            coachPage.style.display = 'none';
            break;
        case "athlete":
            LDRPage.style.display = 'none';
            athletePage.style.display = 'block';
            coachPage.style.display = 'none';
            break;
        case "coach":
            LDRPage.style.display = 'none';
            athletePage.style.display = 'none';
            coachPage.style.display = 'block';
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
            case "male":
                maleEvent.style.display = 'block';
                femaleEvent.style.display = 'none';
                break;
            case "female":
                maleEvent.style.display = 'none';
                femaleEvent.style.display = 'block';
                break;
            default:
                break;
        }
    }


}