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
    private Statement statement;



    Exam(){ //构造函数后，自动存入1000道题入数据库(在优化阶段可以使用多线程，减少数据写入数据库所需时间)
        con= mysql.openDB();
        Exercise ex01=new Exercise();
        ex01.generateAdditionExercise(2500);
        Exercise ex02=new Exercise();
        ex02.generateSubstractExercise(2500);
        Exercise ex03=new Exercise();
        ex03.generateMultiplyExercise(2500);
        Exercise ex04=new Exercise();
        ex04.generateDivisionExercise(2500);

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
            /*try {
                statement=con.createStatement();

                for(int i=0;i<2500;i++){
                    //String sql="INSERT INTO problems VALUES (\'"+i+1+ "\',\'"+operationList01.get(i).asString()+"\',)";
                    //int n=statement.executeUpdate(sql);
                }
                for(int i=0;i<2500;i++){
                    //String sql="INSERT INTO problems VALUES (\'"+operationList02.get(i).asString()+"\',\'"+i+1+" \')";
                    //int n=statement.executeUpdate(sql);
                }
                for(int i=0;i<2500;i++){
                    //String sql="INSERT INTO problems VALUES (\'"+operationList03.get(i).asString()+"\',\'"+i+1+" \')";
                    //int n=statement.executeUpdate(sql);
                }
                for(int i=0;i<2500;i++){
                    //String sql="INSERT INTO problems VALUES (\'"+operationList04.get(i).asString()+"\',\'"+i+1+" \')";
                    //int n=statement.executeUpdate(sql);
                }


                statement.close();
                con.close();


            } catch (SQLException e) {
                e.printStackTrace();
            }*/




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
        System.out.println(ex.getOperationList01().size());
        System.out.println(ex.getOperationList02().size());
        System.out.println(ex.getOperationList03().size());
        System.out.println(ex.getOperationList04().size());
        for(int i=0;i<2500;i++){
            System.out.println(ex.getOperationList01().get(i).asString());
        }
        for(int i=0;i<2500;i++){
            System.out.println(ex.getOperationList02().get(i).toString());
        }
        for(int i=0;i<2500;i++){
            System.out.println(ex.getOperationList03().get(i).toString());
        }
        for(int i=0;i<2500;i++){
            System.out.println(ex.getOperationList04().get(i).toString());
        }
        //System.out.println(ex.getOperationList04().get(2).toString());
    }
}
