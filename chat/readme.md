Simple chat application.
===================================

The application is implemented as web application - war file.
It is build with gradle as:

     >gradle build
     
The build war file is located at {basedir}/build/libs/chat-1.0.war
Java version - 1.7
The application is started in apache-tomcat-8.0.22
After starting application, it can be accessed at
http://{host}/chat-1.0/index.html (for a example http://localhost:8080/chat-1.0/index.html)

The application is implemented by using websocket (for sending chat messages) and 
server-sent events (for sending progress information)
