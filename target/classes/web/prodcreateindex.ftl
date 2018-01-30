<!DOCTYPE html>

<html lang="en">

 <head>  
        <title>新建产品</title>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
	
    </head>  
	
<body>

      <div >新建产品表单</div>  
        <form name="createProductForm" action="/product/save" method="POST">  
            <div >id: <input type="id" name="id" ><br/></div>
            <div >name: <input type="name" name="name"><br/>
            <input type="submit">    </div>
        </form> 
        <a href="/product/create">返回</a>
</body>

</html>