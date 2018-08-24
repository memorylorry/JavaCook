# Why does my EL Expression not work?
When I use el in my login page, I find it is no use. Why is it? By searching it I understand *that my web.xml cofiguration is default disable el expression.*

I check my web.xml. It looks like this:
```web.xml
<!DOCTYPE web-app PUBLIC
        "-//Sun Microsystems, Inc.//DTD Web Application 2.3//EN"
        "http://java.sun.com/dtd/web-app_2_3.dtd" >
<web-app>
  <display-name>Archetype Created Web Application</display-name>
</web-app>
```
Here is 2 ways to solve it.

### 1. Enable it in JSP page
```web.xml
<%@ page isELIgnored="false"%>
```

### 2. Change JSP 2.0 later schema in web.xml
```web.xml
<web-app version="2.4"
         xmlns="http://java.sun.com/xml/ns/j2ee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee
	     http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
  <display-name>Archetype Created Web Application</display-name>
</web-app>
```
