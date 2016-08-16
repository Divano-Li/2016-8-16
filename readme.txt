
1.将项目clone下来后，在src/main/java/ApplicationContext.xml中将自己的数据库的相关信息配置好
2.进入到项目路径下 编译  D:\Workspace\mvn\SpringMyBatisExam3
mvn clean compile

3.编译运行
mvn clean compile exec:java -Dexec.mainClass="com.hand.Main" -Dexec.args="arg0 arg1 arg2"
4.输入4行数据,如果数据库中存在该数据那么就不会再添加进去，如果数据库中不存在那么会自动添加到数据库。
5.最后可以根据ID删除相关的员工信息