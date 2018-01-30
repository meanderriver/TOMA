<!DOCTYPE html>

<html lang="en">
<head>
<style>
.table-b table td{border:1px solid #F00 }
</style>
</head>
<body>

<#list productList as product>

<div class="table-b" style="align:center;">
<table width="400" border="0" cellspacing="0" cellpadding="0">
<tr>
<td width=20%>Name:</td>
<td width=60%>${product.name}</td>
<td width=10%><a href="/product/delete">删除</a></td>
<td width=10%><a href="/product/update">修改</a></td>
</tr>
<tr>
<td>ID:</td>
<td>${product.id}</td>
</tr>
</table>
</div>


</#list>
</body>

</html>