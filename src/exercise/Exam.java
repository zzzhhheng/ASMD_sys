package exercise;

import exercise.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.*;
import java.util.ArrayList;
import java.util.function.BinaryOperator;

//当学生进入系统时，存10000道题到数据库，1-2500为加法，2501-5000为减法，5001到7500为乘法，7501到10000为除法
public class Exam {
    private ArrayList<BinaryOperation> operationList01 = new ArrayList<>();  //加法
    private ArrayList<BinaryOperation> operationList02 = new ArrayList<>();  //减法
    private ArrayList<BinaryOperation> operationList03 = new ArrayList<>();  //乘法
    private ArrayList<BinaryOperation> operationList04 = new ArrayList<>();  //除法

    //数据库相关属性
    private MysqlTool mysql=new MysqlTool();
    private Connection con;
    private PreparedStatement ps;



    Exam(){ //构造函数后，自动存入1000道题入数据库(在优化阶段可以使用多线程，减少数据写入数据库所需时间)
        con= mysql.openDB();
        Exercise ex01=new Exercise();
        ex01.generateAdditionExercise(2);
        Exercise ex02=new Exercise();
        ex02.generateSubstractExercise(2);
        Exercise ex03=new Exercise();
        ex03.generateMultiplyExercise(2);
        Exercise ex04=new Exercise();
        ex04.generateDivisionExercise(2);

        while(ex01.hasNext()){
            operationList01.add(ex01.next());
        }
        while(ex02.hasNext()){
            operationList02.add(ex02.next());
        }
        while(ex03.hasNext()){
            operationList03.add(ex03.next());
        }
        while(ex04.hasNext()){
            operationList04.add(ex04.next());
        }

            //将生成的习题数组存入数据库
            try {
                //添加加法题目
                for(int i=0;i<2;i++){
                    String sql="INSERT INTO question (factor1,operator,factor2,result) VALUES (?,?,?,?)";
                    ps= con.prepareStatement(sql);
                    ps.setInt(1,operationList01.get(i).getLeft_operand());
                    ps.setString(2,""+operationList01.get(i).getOperator());
                    ps.setInt(3,operationList01.get(i).getRight_operand());
                    ps.setInt(4,operationList01.get(i).getValue());
                    int j = ps.executeUpdate();
                    if (j == 0)
                        System.out.println("添加失败");
                }
                //添加减法题目
                for(int i=0;i<2;i++){
                    String sql="INSERT INTO question (factor1,operator,factor2,result) VALUES (?,?,?,?)";
                    ps= con.prepareStatement(sql);
                    ps.setInt(1,operationList02.get(i).getLeft_operand());
                    ps.setString(2,""+operationList02.get(i).getOperator());
                    ps.setInt(3,operationList02.get(i).getRight_operand());
                    ps.setInt(4,operationList02.get(i).getValue());
                    int j = ps.executeUpdate();
                    if (j == 0)
                        System.out.println("添加失败");
                }
                //添加乘法题目
                for(int i=0;i<2;i++){
                    String sql="INSERT INTO question (factor1,operator,factor2,result) VALUES (?,?,?,?)";
                    ps= con.prepareStatement(sql);
                    ps.setInt(1,operationList03.get(i).getLeft_operand());
                    ps.setString(2,""+operationList03.get(i).getOperator());
                    ps.setInt(3,operationList03.get(i).getRight_operand());
                    ps.setInt(4,operationList03.get(i).getValue());
                    int j = ps.executeUpdate();
                    if (j == 0)
                        System.out.println("添加失败");
                }
                //添加除法题目
                for(int i=0;i<2;i++){
                    String sql="INSERT INTO question (factor1,operator,factor2,result) VALUES (?,?,?,?)";
                    ps= con.prepareStatement(sql);
                    ps.setInt(1,operationList04.get(i).getLeft_operand());
                    ps.setString(2,""+operationList04.get(i).getOperator());
                    ps.setInt(3,operationList04.get(i).getRight_operand());
                    ps.setInt(4,operationList04.get(i).getValue());
                    int j = ps.executeUpdate();
                    if (j == 0)
                        System.out.println("添加失败");
                }

                ps.close();
                con.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }

    }
  
  
  //getter方法
    public ArrayList<BinaryOperation> getOperationList01() {
        return operationList01;
    }

    public ArrayList<BinaryOperation> getOperationList02() {
        return operationList02;
    }

    public ArrayList<BinaryOperation> getOperationList03() {
        return operationList03;
    }

    public ArrayList<BinaryOperation> getOperationList04() {
        return operationList04;
    }

    //测试代码，看是否能将题目正确生成，且存入四种List中
    public static void main(String[] args) {
        Exam ex=new Exam();
//        System.out.println(ex.getOperationList01().size());
//        System.out.println(ex.getOperationList02().size());
//        System.out.println(ex.getOperationList03().size());
//        System.out.println(ex.getOperationList04().size());
//        for(int i=0;i<2500;i++){
//            System.out.println(ex.getOperationList01().get(i).asString());
//        }
//        for(int i=0;i<2500;i++){
//            System.out.println(ex.getOperationList02().get(i).toString());
//        }
//        for(int i=0;i<2500;i++){
//            System.out.println(ex.getOperationList03().get(i).toString());
//        }
//        for(int i=0;i<2500;i++){
//            System.out.println(ex.getOperationList04().get(i).toString());
//        }
//        //System.out.println(ex.getOperationList04().get(2).toString());
    }
}
