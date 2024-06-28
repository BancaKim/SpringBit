<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>

<html>
<p><center>
<head>
<meta charset="UTF-8">
<title> 회원가입 </title> 
<br>
<h1 style = size = 3> 회원가입 </h1>

<script defer src="./resources/script.js">
</script>
</head>

<form action = "./studentView" id="regiform" method="Post">

<table bgcolor = "white" border="1">

<tr style="height: 40px;">
<td colspan="2" bgcolor="pink"> <center> 회원기본정보 </td>
</tr>

<tr> 
<td bgcolor="gray"> <center> 아이디: </td>
<td> <input type="text" name="id" id="id" size="20"> 4~12자의 영문 대소문자와 숫자로만 입력 </td>
</tr>

<tr> 
<td bgcolor="gray"> <center> 비밀번호: </td>
<td> <input type="password" name="password" id="password" size="20"> 4~12자의 영문 대소문자와 숫자로만 입력 </td>
</tr>

<tr> 
<td bgcolor="gray">  <center>비밀번호확인: </td>
<td><input type="password" name="checkPassword" id="checkPassword"  size="20"> </td>
</tr>

<tr> 
<td bgcolor="gray"> <center>메일주소: 
<td> <input type="text" name="email" id="email" size="20"> 예)  id@domain.com </td>
</tr>

<tr> 
<td bgcolor="gray">  <center>이름: 
<td> <input type="text" name="userName" id="userName" size="20"> </td>
</tr>

<tr style="height: 40px;">
<td colspan="2" bgcolor="pink"> <center> 개인 신상 정보 </td>
</tr>

<tr> 
<td bgcolor="gray"> <center> 주민등록번호: </td>
<td> <input type="text" name="ssn" id="ssn" size="20"> 예)1234561234567 </td>
</tr>

<tr> 
<td bgcolor="gray"> <center> 생일: </td>
<td> <input type="text" name="birthYear" id="birthYear" size="10">년
<select name="birthMonth" id="birthMonth">
<option value="1"> 1</option>
<option value="2"> 2</option>
<option value="3"> 3</option>
<option value="4"> 4</option>
<option value="5"> 5</option>
<option value="6"> 6</option>
<option value="7"> 7</option>
<option value="8"> 8</option>
<option value="9"> 9</option>
<option value="10"> 10</option>
<option value="11"> 11</option>
<option value="12"> 12</option>
</select> 월
<select name="birthDay" id="birthDay">
<option value="1"> 1</option>
<option value="2"> 2</option>
<option value="3"> 3</option>
<option value="4"> 4</option>
<option value="5"> 5</option>
<option value="6"> 6</option>
<option value="7"> 7</option>
<option value="8"> 8</option>
<option value="9"> 9</option>
<option value="10"> 10</option>
<option value="11"> 11</option>
<option value="12"> 12</option>
<option value="13"> 13</option>
<option value="14"> 14</option>
<option value="15"> 15</option>
<option value="16"> 16</option>
<option value="17"> 17</option>
<option value="18"> 18</option>
<option value="19"> 19</option>
<option value="20"> 20</option>
<option value="21"> 21</option>
<option value="22"> 22</option>
<option value="23"> 23</option>
<option value="24"> 24</option>
<option value="25"> 25</option>
<option value="26"> 26</option>
<option value="27"> 27</option>
<option value="28"> 28</option>
<option value="29"> 29</option>
<option value="30"> 30</option>
<option value="31"> 31</option>
</select> 일
</tr>

<tr> 
<td bgcolor="gray">  <center> 관심분야: </td>
<td>
    <input type="checkbox" name="hobbies" value="컴퓨터">컴퓨터
    <input type="checkbox" name="hobbies" value="인터넷">인터넷
    <input type="checkbox" name="hobbies" value="여행">여행
    <input type="checkbox" name="hobbies" value="영화감상" >영화감상
    <input type="checkbox" name="hobbies" value="음악감상" >음악감상
</td>
</tr>

<tr> 
<td bgcolor="gray"> <center> 자기소개: </td>
<td> <center> <textarea name = "introduction"  id="introduction" cols="70" rows="10" style="width: 100%; height: 300%;" ></textarea> </td>
</tr>

</table>

<br>

<tr>
<td>
<input type="button" value="회원 가입" onclick="allFun()"> 
&nbsp&nbsp 
<input type="reset" value="다시 입력" onclick="clearForm()">
</td>
</tr>
</form>

</p> 

</body>

</html>
