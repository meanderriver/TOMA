<#macro layout>
<html>
<head>
<#assign ctx = request.contextPath />
  <link rel="stylesheet" href="//apps.bdimg.com/libs/jqueryui/1.10.4/css/jquery-ui.min.css">
  <script src="//apps.bdimg.com/libs/jquery/1.10.2/jquery.min.js"></script>
  <script src="//apps.bdimg.com/libs/jqueryui/1.10.4/jquery-ui.min.js"></script>
  <link rel="stylesheet" type="text/css" href="${ctx}/css/toma.css" />
  <script>
  $(function() {
    $( "#menu" ).menu();
  });
  </script>
  <style>
  .ui-menu { background: #bdeceb; width: 150px;height: 200%; }
  </style>
</head>
<body>
    <div style="width: 100%; height:70px;text-align:center; font-size:30px;">
    <#include "header.ftl">
    </div>
    <div style=" height:100%;text-align:center;">
    <#include "sidebar.ftl">
    </div>
 
    <#-- 在这里嵌入main content -->
    <div ><#include "prodselectindex.ftl"></div>
    
    <div style="position: absolute; left: 400px; top: 100px;text-align:center;"><img src="https://rescdn.qqmail.com/zh_CN/htmledition/images/tg-mj1e9c5d.jpg"/></div>
    
    
 	
    <div  id="userMenu" style="position: absolute; left: 1100px; top: 90px;text-align:center; font-size:30px;">
    </div>
   
   <div id="myDiv" style="position: absolute; left: 400px; top: 500px;text-align:center;"></div>
    <#include "footer.ftl">
    
</body>
</html>
</#macro>