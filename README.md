更新说明

1. 开始学习vue.js
2. 通过application.yml配置静态的路径
3. 纯注解方式引入拦截器，在main函数类前增加注解，其中controller、service等注解默认情况下可以被springboot扫描到，而interceptor却不行，只能通过以下方式，具体原因不明确
@SpringBootApplication(scanBasePackages = {"com.example.demo.bean", "com.example.demo.controller", "com.example.demo.service", "com.example.demo.interceptor"})
4. jsp跳转有问题