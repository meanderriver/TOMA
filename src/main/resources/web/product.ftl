<!DOCTYPE html>

<html lang="en">

 <head>  
        <title>新建产品</title>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	
    </head>  
	
<body>

      <#import "layout.ftl" as defaultLayout>
      
      <@defaultLayout.layout>

      <div >新建产品表单</div>  
        <form name="createProductForm" action="/product/save" method="POST">  
            <div style="position: absolute; left:20px; top: 70px;">id: <input type="id" name="id" ><br/></div>
            <div style="position: absolute; left:20px; top: 150px;">name: <input type="name" name="name"><br/>
            <input type="submit">    </div>
        </form> 
        
        </@defaultLayout.layout> 
</body>

</html>