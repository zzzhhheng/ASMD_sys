public class BinaryOperationTester {
    public static void main(String[] args) {
        BinaryOperation bop;
        for (int i=0;i<10;i++){
            bop=new AdditionOperation();
            System.out.println(bop.asString());
        }
    }
}
