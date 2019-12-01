<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>测试页面</title>
</head>
<body>
    <h1>HELLO WORLD!!!</h1>
    <b>spring的启动方式</b>
    <br><br>

    如果只是运行Application的main函数，是不能跳转到jsp页面的，<br>
    而是需要用<b style="color: red;">“mvn clean spring-boot:run”</b>。<br><br>
    另外，新版本的spring boot貌似不能识别application.properties和application.yml中的jsp过滤器<br>
    <div>
        spring.mvc.view.prefix=/WEB-INF/jsp/<br>
        spring.mvc.view.suffix=.jsp<br>
    </div>
    以上配置无法生效，具体原因未知<br>
</body>
</html>