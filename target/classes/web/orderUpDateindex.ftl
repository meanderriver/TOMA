<!DOCTYPE html>

<html lang="en">

 <head>  
        <title>修改订单</title>  
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    </head>  

<body>

       <div>修改订单表单</div>  
        <form name="updateProductForm" action="/order/updateres" method="POST">  
            id: <input type="id" name="id"><br/>    
            productId: <input type="productId" name="productId"><br/>
            quantity: <input type="quantity" name="quantity"><br/>  
              price: <input type="price" name="price"><br/>   
              address: <input type="address" name="address"><br/>
               buyer: <input type="buyer" name="buyer"><br/> 
            <input type="submit">    
        </form>  
</body>

</html>