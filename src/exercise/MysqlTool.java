import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//mysql工具，可以通过声明此类，调用方法直接获取connection
//然后通过statement=con.createStatement()获取statement
//最后通过statement.executeUpdate(sql)进行增删改，通过statement.executeQuery(sql)进行查询
public class MysqlTool {
    private static final String DRIVER ="com.mysql.cj.jdbc.Driver";
    private static final String URL="jdbc:mysql://localhost:3306/asmd_sys";
    private static final String USERNAME="root";
    private static final String PWD="123456";
    private Connection conn=null;

    //打开数据库连接
    public Connection openDB(){

        try {
            java.lang.Class.forName(DRIVER);
            conn= DriverManager.getConnection(URL,USERNAME,PWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

}
