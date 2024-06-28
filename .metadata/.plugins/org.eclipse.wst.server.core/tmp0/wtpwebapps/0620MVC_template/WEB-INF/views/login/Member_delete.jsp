<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>스프링MVC</title>
<style>
@font-face {
    font-family: 'DNFBitBitv2';
    font-style: normal;
    font-weight: 400;
    src: url('//cdn.df.nexon.com/img/common/font/DNFBitBitv2.otf') format('opentype');
}

* {
    font-family: 'DNFBitBitv2';
}
</style>
<link href="https://unpkg.com/nes.css@latest/css/nes.min.css" rel="stylesheet" />
<!-- SweetAlert2 CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/sweetalert2@11/dist/sweetalert2.min.css">
</head>
<body>
<%
String id = request.getParameter("id");
Connection conn = null;
PreparedStatement pstmt = null;
String sql = "DELETE FROM USER WHERE id=?";

try {
    Context init = new InitialContext();
    DataSource ds = (DataSource)init.lookup("java:comp/env/jdbc/MysqlDB");
    conn = ds.getConnection(); 
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, id);
    int affectedRows = pstmt.executeUpdate();

    if (affectedRows > 0) {
        %>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script>
        Swal.fire({
            title: 'Success!',
            text: '<%= id %> 회원이 삭제되었습니다.',
            icon: 'success'
        }).then((result) => {
            if (result.isConfirmed) {
                window.location.href = "Main2.jsp";
            }
        });
        </script>
        <%
    } else {
        %>
        <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
        <script>
        Swal.fire({
            title: 'Error!',
            text: '존재하지 않는 회원 ID입니다.',
            icon: 'error'
        }).then((result) => {
            if (result.isConfirmed) {
                history.back();
            }
        });
        </script>
        <%
    }
} catch(Exception e) {
    e.printStackTrace();
    %>
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script>
    Swal.fire({
        title: 'Database Error!',
        text: '데이터베이스 처리 중 오류가 발생했습니다.',
        icon: 'error'
    }).then((result) => {
        if (result.isConfirmed) {
            history.back();
        }
    });
    </script>
    <%
} finally {
    if (pstmt != null) try { pstmt.close(); } catch(SQLException ex) { ex.printStackTrace(); }
    if (conn != null) try { conn.close(); } catch(SQLException ex) { ex.printStackTrace(); }
}
%>
</body>
</html>