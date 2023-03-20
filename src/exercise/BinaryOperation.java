package exercise;

import java.util.Random;

/**
 * BinaryOperation抽象类是所有题目的基类
 * 包括成员变量两个静态变量UPPER,LOW表示题目的结果的上线
 * left_operand，right_operand是算式左右两部分的数据
 * operator是算式中的运算符
 * value是算式的结果
 */
abstract class BinaryOperation {
    static final int UPPER = 100;
    static final int LOW = 0;
    private int left_operand = 0;
    private int right_operand = 0;
    private char operator;
    private int value = 0;

    /**
     * 为成员变量提供的getter和setter
     */
    public int getLeft_operand() {
        return left_operand;
    }

    public void setLeft_operand(int left_operand) {
        this.left_operand = left_operand;
    }

    public int getRight_operand() {
        return right_operand;
    }

    public void setRight_operand(int right_operand) {
        this.right_operand = right_operand;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    /**
     * 格式化输出
     */
    //示例：对运算32+5返回字符串“32+5”
    public String toString() {
        return "" + left_operand + operator + right_operand;
    }

    //示例；对运算32+5返回字符串“32+5=”
    public String asString() {
        return "" + left_operand + operator + right_operand + "=";
    }

    //示例：对运算32+5返回字符串“32+5=37”
    public String fullString() {
        return "" + left_operand + operator + operator + right_operand + "=" + value;
    }


    /**
     * 调用了两个抽象方法，生成合法的算式成分，调用者负责输入合法的参数
     * anOperator是需要设置的算式运算符
     * checkingCalculation()方法是基类中的抽象方法是用来检测生成算式的结果是否合法
     */
    protected void generateBinaryOperation(char anOperator) {

        int left, right, result;
        Random random = new Random();

        //生成left和right
         if(anOperator=='*'){   //如果是乘法，将两个数都限制在10以内（如果添加难度分级功能的话，可以增加难度比如一个是十位数往上的，一个是有个位的比如21*4，甚至可以增加小数，比如19.6*5）
            left = random.nextInt(11);
            do {
                right = random.nextInt(11);
                result = calculate(left, right);
            } while (!(checkingCalculation(result)));
        }else if(anOperator=='/') {  //如果是除法，两个数相同的概率比较大，所以如果相同，就再随机一次（如果添加难度分级的话，将结果为两位数的分离为难题，比如91/3，将属于99乘法表的分离为简单题，比如81/9=9）
            left = random.nextInt(UPPER + 1);
            do {
                right = random.nextInt(UPPER + 1);
                result = calculate(left, right);
            } while (!(checkingCalculation(result)));
            if(right==left){
                left = random.nextInt(UPPER + 1);
                do {
                    right = random.nextInt(UPPER + 1);
                    result = calculate(left, right);
                } while (!(checkingCalculation(result)));
            }
        }else {
                left = random.nextInt(UPPER + 1);
                do {
                    right = random.nextInt(UPPER + 1);
                    result = calculate(left, right);
                } while (!(checkingCalculation(result)));
            }
        
        left_operand = left;
        right_operand = right;
        operator = anOperator;
        value = result;
    }

    //子类必须实现的两个方法
    //checkingCalculation()方法是基类中的抽象方法是用来检测生成算式的结果是否在UPPER和LOWER之间*
    abstract boolean checkingCalculation(int anInteger);

    //calculate得出计算结果
    abstract int calculate(int left, int right);

    public boolean equals(BinaryOperation anOperation) {
        return left_operand == anOperation.getLeft_operand() && right_operand == anOperation.getRight_operand() && operator == anOperation.getOperator();
    }
}

/**
 * AdditionOperation类是产生加法算式类
 * AdditionOperation()构造函数调用基类的 generateBinaryOperation()方法并传入参数生成成员变量的值
 */
class AdditionOperation extends BinaryOperation {
    AdditionOperation() {
        generateBinaryOperation('+');
    }

    public boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER && anInteger >= LOW;
    }

    int calculate(int left, int right) {
        return left + right;
    }
}

/**
 * SubstractOperation类是产生减法法算式类
 * SubstractOperation()构造函数调用基类的 generateBinaryOperation()方法并传入参数生成成员变量的值
 */
class SubstractOperation extends BinaryOperation {
    SubstractOperation() {
        generateBinaryOperation('-');
    }

    public boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER && anInteger >= LOW;
    }

    int calculate(int left, int right) {
        return left - right;
    }
}

/**
 * MultiplyOperation类是产生乘法法算式类
 * MultiplyOperation()构造函数调用基类的 generateBinaryOperation()方法并传入参数生成成员变量的值
 */
class MultiplyOperation extends BinaryOperation {
    MultiplyOperation() {
        generateBinaryOperation('*');
    }

    public boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER && anInteger >= LOW;
    }

    int calculate(int left, int right) {
        return left * right;
    }
}

/**
 * DivisionOperation类是产生除法法算式类
 * DivisionOperation()构造函数调用基类的 generateBinaryOperation()方法并传入参数生成成员变量的值
 * 该类的calculate方法与其他不同增加了检测算式是否为整数除法算式不带小数
 */
class DivisionOperation extends BinaryOperation {
    DivisionOperation() {
        generateBinaryOperation('/');
    }

    public boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER && anInteger >= LOW;
    }

    int calculate(int left, int right) {
        int n = -1;
        if (right == 0){
            return n;
        }
        if (left % right == 0) {
            n = left / right;
        }
        return n;
    }
}
