import java.util.Random;

abstract class BinaryOperation {
    static final int UPPER = 100;
    static final int low = 100;
    private int left_operand = 0;
    private int right_operand = 0;
    private char operator;
    private int value = 0;

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

    //示例：对运算32+5返回字符串“32+5”
    public String toString() {
        return ""+left_operand+operator+right_operand;
    }
    //示例；对运算32+5返回字符串“32+5=”
    public String asString() {
        return ""+left_operand+operator+right_operand+"=";
    }
    //示例：对运算32+5返回字符串“32+5=37”
    public String fullString() {
        return ""+left_operand+operator+operator+right_operand+"="+value;
    }


    //调用了两个抽象方法，生成合法的算式成分，调用者负责输入合法的参数
    protected void generateBinaryOperation(char anOperator) {

        int left, right, result;
        Random random = new Random();
        left = random.nextInt(UPPER + 1);
        do {
            right = random.nextInt(UPPER + 1);
            result = calculate(left, right);
        } while (!(checkingCalculation(result)));
        left_operand = left;
        right_operand = right;
        operator = anOperator;
        value = result;
    }

    //子类必须实现的两个方法
    abstract boolean checkingCalculation(int anInteger);

    abstract int calculate(int left, int right);

    public boolean equals(BinaryOperation anOperation) {
        return left_operand == anOperation.getLeft_operand() && right_operand == anOperation.getRight_operand() && operator == anOperation.getOperator();
    }
}

//算式的成员变量访问方法、字符串显示方法同案例设计一
class AdditionOperation extends BinaryOperation {
    AdditionOperation() {
        generateBinaryOperation('+' );
    }

    public boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER;
    }

    int calculate(int left, int right) {
        return left + right;
    }
}

class SubstractOperation extends BinaryOperation {
    SubstractOperation() {
        generateBinaryOperation('-' );
    }

    public boolean checkingCalculation(int anInteger) {
        return anInteger <= UPPER;
    }

    int calculate(int left, int right) {
        return left - right;
    }
}

