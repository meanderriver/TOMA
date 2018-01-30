<!DOCTYPE html>

<html lang="en">

 <head>  
        <title>查询产品</title>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
 <script>
function ajaxtransf()
{
var a=selectProductForm.name.value;
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
xmlhttp.open("POST","/product/selectres",true);
xmlhttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
xmlhttp.send("name="+a);
}

</script>
  
    </head>  

<body>
        <form   name="selectProductForm"  method="POST">  
            <input type="text"   name="name" >
             <input type="button" value="搜索" onclick="ajaxtransf()">
              <a href="/product/createindex">创建一个新产品</a>
        </form> 
         
</body>

</html>