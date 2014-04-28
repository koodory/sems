If you have trouble in JDBC connection errors, 
it is recommended that overwrite "context.xml" in webapp into 
your present folder such as "/Servers/Tomcat VX.0 Server at localhost"

The reason is that Public JDBC requires XML declarations in context.xml, 
so those statements were already injected in the XML file enclosed in
webapp folder.

* Location of context.xml : /src/main/webapp
* XML statement for Resoruce :
<Resource auth="Container" 
          driverClassName="com.mysql.jdbc.Driver" 
          maxActive="10" maxIdle="3" maxWait="1000" 
          name="jdbc/studydb" 
          password="study" 
          type="javax.sql.DataSource" 
          url="jdbc:mysql://localhost:3306/studydb?useUnicode=true&amp;
          characterEncoding=UTF-8" username="study"/>

