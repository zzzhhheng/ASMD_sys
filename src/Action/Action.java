package Action;

import exercise.BinaryOperation;
import java.net.BindException;
import java.util.ArrayList;
import java.util.function.BinaryOperator;

//Action类用于前后端交互，前端可以通过get获取Action中参数的值，后端可以用Action中的方法对前端数据进行处理
public class Action {
    private ArrayList<Boolean> checkPaper=new ArrayList<>();//储存一个判断对错的数组，判断用户输入是否正确，如果正确，对应题号为true，错误则为false

  
    //判断学生输入的信息是否正确，提取前端发送来的题目数组和对应结果，后端函数进行判断，返回boolen类型的数组，如果正确返回1.如果错误返回0
    public void checkPaper(int num, ArrayList<BinaryOperation> problems, ArrayList<Integer> answ){
        for(int i=0;i<num;i++){
            checkPaper.add(true);      //将checkPaper赋初值
        }
        for(int i=0;i<num;i++){
            if(problems.get(i).getValue()!=answ.get(i)){
                checkPaper.set(i,false);      //如果用户输入和答案不等，将check数组对应值设定为false
            }
        }
    }

}
