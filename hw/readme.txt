Prerequisites: java 8 / gradle

To build application:
>gradle build

To run application:
copy war file to Tomcat webapp dir:
>cp <repo.dir>\hw\build\libs\hw.war <catalina.home>\webapps\

To start application - start tomcat and send loan request in browser:
http://localhost:8080/hw/firstname/John/lastname/Smith/amount/1000/term/30

Limitations:
terms and amount accept only digits
