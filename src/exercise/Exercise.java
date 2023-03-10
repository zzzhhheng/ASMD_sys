package exercise;

import java.util.ArrayList;
import java.util.Random;


public class Exercise {
    private ArrayList<BinaryOperation> operationList = new ArrayList<>();
    private int current = 0;//用于遍历数据集

    public void generateBinaryExercise(int operationCount) {
        BinaryOperation anOperation = null;
        while (operationCount > 0) {
            do {
                anOperation = generateOperation();

            } while (operationList.contains(anOperation));
            operationCount--;
            operationList.add(anOperation);
        }

    }

    public void generateAdditionExercise(int operationCount) {
        BinaryOperation anOperation = null;
        while (operationCount > 0) {
            do {
                anOperation = new AdditionOperation();

            }
            while (operationList.contains(anOperation));

            operationCount--;
            operationList.add(anOperation);
        }

    }

    public void generateSubstractExercise(int operationCount) {
        BinaryOperation anOperation = null;
        while (operationCount > 0) {
            do {
                anOperation = new SubstractOperation();

            }
            while (operationList.contains(anOperation));

            operationCount--;
            operationList.add(anOperation);
        }

    }


    private BinaryOperation generateOperation() {
        Random random = new Random();
        int opValue = random.nextInt(2);
        if (opValue == 1) {
            return new AdditionOperation();
        }
        return new SubstractOperation();
    }


    //下面两个方法用于实现遍历数据
    //若有元素，返回true,否则返回false
    public boolean hasNext() {
        return current <= operationList.size() - 1;
    }

    //若有元素，返回当前元素，移动到一个
    public BinaryOperation next() {
        return operationList.get(current++);
    }


}


