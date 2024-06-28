// 모든 함수 호출
var a = 0;
function allFun() {
    a = id();
    a += pw();
    a +=pwCheck();
    a +=mail();
    a +=name();
    a +=secretNum();
    birth();
    a +=interest();
    a +=introduce();

    console.log(a);
    if(a == 8){
        let regiform = document.getElementById("regiform");
    	regiform.submit(); // subject는 제목을 정의하기 위한 구문으로 필수 아님
    }
}

// 회원기본정보
function id() {
    var id = document.getElementById("id");

    if (id.value.length < 4 || id.value.length > 12) {
        alert("4~12자로 입력해주세요");
        id.value = "";
        id.focus();
        return 0;
    }

    // 아스키코드 0-9 : 48-57 / A-Z : 65-90 / a-z : 97-122
    for (var i = 0; i < id.value.length; i++) {
        var idAscii = id.value.charCodeAt(i); // 비밀번호의 i번째자리 아스키코드를 뽑아내는 구문
        if (!(idAscii >= 48 && idAscii <= 57 ||
            idAscii >= 65 && idAscii <= 90 ||
            idAscii >= 97 && idAscii <= 122)) {
            alert("영문 대소문자와 숫자만 입력가능합니다.");
            return 0;
            break;
        }
    } return 1;
}

function pw() {
    var pw = document.getElementById("password");

    if (pw.value.length < 4 || pw.value.length > 12) {
        alert("4~12자로 입력해주세요");
        pw.value = "";
        pw.focus();
        return 0;
    }
    else if (pw.value == id.value) {
        alert("id와 동일한 값을 입력하셨습니다.");
        pw.value = "";
        pw.focus();
        return 0;
    }

    // 아스키코드 0-9 : 48-57 / A-Z : 65-90 / a-z : 97-122
    for (var i = 0; i < pw.value.length; i++) {
        var pwAscii = pw.value.charCodeAt(i); // 비밀번호의 i번째자리 아스키코드를 뽑아내는 구문
        if (!(pwAscii >= 48 && pwAscii <= 57 ||
            pwAscii >= 65 && pwAscii <= 90 ||
            pwAscii >= 97 && pwAscii <= 122)) {
            alert("영문 대소문자와 숫자만 입력가능합니다.");
            return 0;
            break;
        }
    } return 1;
}

function pwCheck() {
    var pw = document.getElementById("password");
    var pwCheck = document.getElementById("checkPassword");

    if (pw.value != pwCheck.value) {
        alert("입력한 비밀번호와 일치하지 않습니다.");
        pw.value = "";
        pw.focus();
        return 0;
    } return 1;
}

function mail() {
    var mail = document.getElementById("email");
    var golbange = mail.value.indexOf("@"); // mail 값에 @가 포함되어있지 않으면 -1반환
    var jum = mail.value.lastIndexOf(".");

    if (mail.value == "") {
        alert("빈칸 에러");
        mail.value = "";
        mail.focus();
        return 0;
    }

    if (golbange === -1 || // "@"가 없는 경우
        jum === -1 || // "."이 없는 경우
        golbange === 0 || // "@"가 맨 앞에 있는 경우
        golbange > jum || // "."이 "@"보다 앞에 있는 경우
        jum === mail.value.length - 1) { // "."이 맨 뒤에 있는 경우
        alert("입력한 이메일 형식이 옳바르지 않습니다.");
        return 0;
    } return 1;
}

function name() {
    var name = document.getElementById("userName");

    if (name.value == "") {
        alert("빈칸 에러");
        name.value = "";
        name.focus();
        return 0;
    } return 1;
}

// 개인신상정보
function secretNum() {
    var secretNum = document.getElementById("ssn");


    if (secretNum.value.length != 13) {
        alert("주민번호는 13자리입니다.");
        secretNum.value = "";
        secretNum.focus();
        return 0;
    }

    // 주민번호 규칙
    // 12345678 * 23456789 / 9 10 11 12 * 2345 의 모든 값을 더하고 % 11한 값을 a 11-a가 13번째 자리
    var rule = parseInt(secretNum.value.charAt(0)) * 2
    rule += parseInt(secretNum.value.charAt(1)) * 3
    rule += parseInt(secretNum.value.charAt(2)) * 4
    rule += parseInt(secretNum.value.charAt(3)) * 5
    rule += parseInt(secretNum.value.charAt(4)) * 6
    rule += parseInt(secretNum.value.charAt(5)) * 7
    rule += parseInt(secretNum.value.charAt(6)) * 8
    rule += parseInt(secretNum.value.charAt(7)) * 9

    rule += parseInt(secretNum.value.charAt(8)) * 2
    rule += parseInt(secretNum.value.charAt(9)) * 3
    rule += parseInt(secretNum.value.charAt(10)) * 4
    rule += parseInt(secretNum.value.charAt(11)) * 5

    var lastNum = 11 - (rule % 11);

    // lastNum%=10;
    lastNum = lastNum % 10;

    //마지막자리
    let secretNumLast = secretNum.value.charAt(12);

    if (secretNumLast != lastNum) {
        alert("주민번호가 올바르지 않습니다.");
        return 0;
    } return 1;

}

function birth() {
    var secretNum = document.getElementById("ssn").value; // 주민번호 가져오기
    var year2 = secretNum.substring(0, 2); // 연도
    var sevenNum = secretNum.charAt(6);


    if (sevenNum == 3 || sevenNum == 4) {
        year2 = '20' + year2
    }
    else {
        year2 = '19' + year2
    }

    document.getElementById("birthYear").value = year2;

    // 월
    var month2 = secretNum.substring(2, 4);
    document.getElementById("birthMonth").value = month2;

    // 일
    var day2 = secretNum.substring(4, 6);
    document.getElementById("birthDay").value = day2;
    // console.log(day2); // 검증용 출력
}

function interest() {
    var interest = document.getElementsByName("hobbies");
    var count = 0;
    for (var i = 0; i < interest.length; i++) { // 5개의 선택지만큼 반복하며 각각 체크가 되어있는지를 확인
        if (interest[i].checked == true) { // true면 체크된 상태
            count++; // 체크된 체크박스의 갯수를 count
        }
    } if (count == 0) { // 하나도 체크되어있지 않다면
        alert("하나 이상 선택해주세요.");
        return 0;
    } return 1;
}

function introduce() {
    if (introduce.value == "") {
        alert("빈칸 에러");
        name.value = "";
        name.focus();
        return 0;
    } return 1;
}