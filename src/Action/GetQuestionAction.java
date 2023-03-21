package Action;

import com.opensymphony.xwork2.ActionContext;
import exercise.BinaryOperation;
import exercise.MysqlTool;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import com.opensymphony.xwork2.Action;



//当学生点击练习或查看试卷时，前端调用此类，获取题目数组，并显示给用户
public class GetQuestionAction implements Action {
    private ArrayList<BinaryOperation> questions;//题目数组
    //数据库相关属性
    private MysqlTool mysql=new MysqlTool();
    private Connection con;
    private Statement statement;

    public ArrayList<BinaryOperation> getQuestions() {
        return questions;
    }


    //获取普通练习的题目，默认10道题。可以修改方法让用户输入题目数
    @Override
    public String execute() throws Exception {
        con=mysql.openDB();
        //从数据库中随机抽10道题，存入questions
        try {
            for (int i = 0; i < 10; i++) {
                statement=con.createStatement();
                Random random = new Random();
                //随机出题，如果想要定向出题（如只有加，只有减，或者只有乘除），可以限定随机数的范围
                int questionId= random.nextInt(100001);
                //通过题目id查询题目的所有信息（id,factor1,operator,factor2,result），并存入questions数组

                /*待完成
                待完成
                待完成
                待完成
                待完成
                待完成
                待完成
                待完成
                待完成*/


            }
            statement.close();
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }




        ActionContext ac=ActionContext.getContext();
        //把习题数组保存到application中
        ac.getApplication().put("questions",getQuestions());
        //返回SUCCESS，题目返回成功
        return SUCCESS;
    }



}
