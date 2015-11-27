<#setting classic_compatible=true>
<#assign basePath=request.contextPath />
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>User List</title>
<style type="text/css">
.STYLE1 {
    font-family: Arial, Helvetica, sans-serif;
    font-weight: bold;
    font-size: 36px;
    color: #FF0000;
}
.STYLE13 {font-size: 24}
.STYLE15 {font-family: Arial, Helvetica, sans-serif; font-size: 24px; }
</style>
</head>

<body>
<table width="1500" height="600" border="0" cellpadding="0" cellspacing="0">
  
  <tr>
    <td width="500" height="200">&nbsp;</td>
    <td width="500" height="200">
    <table width="500" height="200" border="1" cellpadding="0" cellspacing="0">
      <tr>
        <td width="160" height="65" align="center" valign="middle"><span class="STYLE15">id</span></td>
        <td width="160" height="65" align="center" valign="middle"><span class="STYLE15">userno</span></td>
        <td width="160" height="65" align="center" valign="middle"><span class="STYLE15">Password</span></td>
      </tr>
      <#list userList as user>
      <tr>
        <td width="160" height="65" align="center" valign="middle"><span class="STYLE15">${user.id!!}</span></td>
        <td width="160" height="65" align="center" valign="middle"><span class="STYLE15">${user.userno!!}</span></td>
        <td width="160" height="65" align="center" valign="middle"><span class="STYLE15">${user.password!!}</span></td>
      </tr>
      </#list>
    </table>
    </td>
     
  </tr>
   
</table>

<h2>新增用户</h2>
<form action="${basePath}/User/addUser" method="post">
<input type="text" name="userno" value=""><br>
<input type="text" name="password" value="">
<input type="submit" value="submit">
</form>
<br>
<br>
<br>
<h2>查询用户</h2>
<form action="${basePath}/User/searchUser" method="post">
<input type="text" name="keyword" value="${keyword!!}"><br>
<input type="submit" value="search">
</form>















</body>
</html>