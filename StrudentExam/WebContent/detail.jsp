<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="com.test.student_exam.Student" %>
<%@ page import="com.test.student_exam.JavaC"	 %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	int no = Integer.parseInt(request.getParameter("no"));
	Student student = null;
	JavaC javaC = new JavaC();
	for(int i = 0; i < javaC.getLength(); i++){
		Student object = javaC.getStudent(i);
		if(object.getNo() == no){
			student = object;
			break;
		}
	}
	String[] majorArray = {"기계공학", "컴퓨터학","컴퓨터공학" , "정보통신"};
	String[] cityArray = {"서울", "안산", "부천"}; 
%>
<H1><%= student.getName() %></H1>
<ul>
	<li>번호:<%= student.getNo() %></li>
	<li>성별:<%= student.getGender() =='m'?"남성":"여성" %></li>
	<li>전공:<%= majorArray[student.getMajor()] %></li>
	<li>지역:<%= cityArray[student.getCity()] %></li>
	<li>가입일:<%= student.getCreated_at() %></li>
</ul>
</body>
</html>