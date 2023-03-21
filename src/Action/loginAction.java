package Action;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import exercise.MysqlTool;

import java.sql.Connection;
import java.sql.Statement;

public class loginAction implements Action {
    private String username;
    private String password;
    //数据库相关属性
    private MysqlTool mysql=new MysqlTool();
    private Connection con;
    private Statement statement;

    public String getUsername() {
        return username;
    }
    public String getPassword() {
        return password;
    }



    @Override
    public String execute() throws Exception {
        con=mysql.openDB();
        Boolean login=1;
        //将属性与Student数据库中的账号密码比对
        /*

          待完成
           待完成
           待完成
           待完成

             嗨嗨嗨

           待完成
           待完成
           待完成
           待完成
            待完成
            待完成
            你好
                */



        if(login){
        //返回SUCCESS，通过struts.xml进入登录成功页面（即进入学生主页面）
            return SUCCESS;
        }else{
            //登录失败（可以添加功能，比如账号错误还没密码错误，只需要区别一下返回值就行了）
            return ERROR;
        
        }

        
    }
}
