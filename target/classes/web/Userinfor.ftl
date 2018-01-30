<!DOCTYPE html>

<html lang="en">
<head>
<style>
.table-b table td{border:1px solid #F00 }
</style>
</head>
<body>
<#list user as user>


<div class="table-b" style="align:center;">
<table width="400" border="0" cellspacing="0" cellpadding="0">
<tr>
<td width=20%>ID:</td>
<td width=60%>ORDERID:</td>
</tr>
<tr>
<td>${user.id}</td>
<td>${user.name}</td>
</tr>
</table>
</div>


</#list>
</body>

</html>