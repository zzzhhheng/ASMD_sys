package Action;

import exercise.BinaryOperation;
import java.util.ArrayList;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import exercise.MysqlTool;
import java.sql.Connection;
import java.sql.Statement;

//检查题目是否正确，需要前端传题目数组进来
public class CheckingAction implements Action{
    private ArrayList<Boolean> checkPaper=new ArrayList<>();//储存一个判断对错的数组，判断用户输入是否正确，如果正确，对应题号为true，错误则为false
    private ArrayList<BinaryOperation>problems;  //储存试卷信息，信息由前端发送
    private ArrayList<Integer>answ;              //储存答案信息，信息由前端发送
    //数据库相关属性
    private MysqlTool mysql=new MysqlTool();
    private Connection con;
    private Statement statement;
    
    
    public ArrayList<Boolean> getCheckPaper() {
        return checkPaper;
    }

    
    @Override
    public String execute() throws Exception {
        con=mysql.openDB();
        //判断学生输入的信息是否正确，提取前端发送来的题目数组和对应结果，后端函数进行判断，返回boolen类型的数组，如果正确返回1.如果错误返回0
            for(int i=0;i<problems.size();i++){
                checkPaper.add(true);      //将checkPaper赋初值
            }
            for(int i=0;i<problems.size();i++){
                if(problems.get(i).getValue()!=answ.get(i)){
                    checkPaper.set(i,false);      //如果用户输入和答案不等，将check数组对应值设定为false
                }
            }
        


        ActionContext ac=ActionContext.getContext();
        //把对错数组保存到application中
        ac.getApplication().put("checkPaper",getCheckPaper());
       

        //返回SUCCESS，根据对错数组进行批改
        return SUCCESS;
    }

}
