<!DOCTYPE html>

<html lang="en">
<head>
<style>
.table-b table td{border:1px solid #F00 }
</style>
</head>
<body>
<#list orderList as order>


<div class="table-b" style="align:center;">
<table width="400" border="0" cellspacing="0" cellpadding="0">
<tr>
<td width=20%>ID:</td>
<td width=60%>ORDERID:</td>
<td width=60%>QUANTITY:</td>
<td width=60%>PICE:</td>
<td width=60%>ADDRESS:</td>
<td width=60%>BUYER:</td>
<td width=60%></td>
<td width=60%></td>
</tr>
<tr>
<td>${order.id}</td>
<td>${order.productId}</td>
<td>${order.quantity}</td>
<td>${order.price}</td>
<td> ${order.address}</td>
<td>${order.buyer} </td>
<td ><a href="/order/delete">删除</a></td>
<td ><a href="/order/update">修改</a></td>
</tr>
</table>
</div>


</#list>
</body>

</html>