package test;

import exercise.*;

import java.util.function.BinaryOperator;

public class testop {
    public static void main(String[] args) {
   Exercise ex=new Exercise();
   ex.generateAdditionExercise(5);
  while (ex.hasNext()){
      System.out.println(ex.next());
  }
    }
}
