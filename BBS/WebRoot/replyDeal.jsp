<%@ page language="java" import="java.util.*,java.sql.*, com.hx.bbs.*" pageEncoding="GB18030"%>

<%
request.setCharacterEncoding("GBK");

int pid = Integer.parseInt(request.getParameter("pid"));
int rootId = Integer.parseInt(request.getParameter("rootId"));

String title = request.getParameter("title");
System.out.println(title);
String cont = request.getParameter("cont");
System.out.println(cont);
Connection conn = DB.getConn();

boolean autoCommit = conn.getAutoCommit();
conn.setAutoCommit(false);

String sql = "insert into article values(null, ?, ?, ?, ?, now(), ?)";
PreparedStatement pstmt = DB.prepareStmt(conn, sql);
pstmt.setInt(1, pid);
pstmt.setInt(2, rootId);
pstmt.setString(3, title);
pstmt.setString(4, cont);
pstmt.setInt(5, 0);
pstmt.executeUpdate();

Statement stmt = DB.createStmt(conn);
stmt.executeUpdate("update article set isleaf = 1 where id = " + pid);

conn.commit();
conn.setAutoCommit(autoCommit);
DB.close(pstmt);
DB.close(stmt);
DB.close(conn);

//response.sendRedirect("article.jsp");
%>

<span id="time" style="background:red">3</span>秒钟后自动跳转，如果不跳转请点击下面链接。

<script language="JavaScript1.2" type="text/javascript">
<!--
//  Place this in the 'head' section of your page.  

function delayURL(url, time) {
	var delay = document.getElementById("time").innerHTML;
	if(delay > 0) {
		dlay--;
		document.getElementById("time").innerHTML = delay;
	}else{
		window.top.location.href=url;
	}
		setTimeout("delayURL('" + url + "')", 1000);
		
}

//-->

</script>


<a href="article.jsp">主题列表</a>
<script type="text/javascript">
	delayURL("article.jsp",3000);
</script>
<!--

//-->
</script>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'replayDeal.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    	回复成功！<br>
  </body>
</html>
