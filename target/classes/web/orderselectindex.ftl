<!DOCTYPE html>

<html lang="en">

 <head>  
        <title>查询订单</title>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
        <script>
function ajaxotransf()
{
var a=orderProductForm.name.value;
var xmlhttp;
if (window.XMLHttpRequest)
  {
  xmlhttp=new XMLHttpRequest();
  }
else
  {
  xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
  }
xmlhttp.onreadystatechange=function()
  {
  if (xmlhttp.readyState==4 && xmlhttp.status==200)
    {
    document.getElementById("myDiv").innerHTML=xmlhttp.responseText;
    }
  }
xmlhttp.open("POST","/order/selectres",true);
xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
xmlhttp.send("id="+a);
}

</script>
    </head>  

<body>

        <form   name="orderProductForm"  method="POST">  
            <input type="text"   name="name" >
             <input type="button" value="搜索" onclick="ajaxotransf()">
             <a href="/order/createindex">创建一个订单</a>
        </form> 
</body>

</html>