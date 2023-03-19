package exercise;
/**
 * @author :LGH
 *
 * */
public class ExerciseSheet {
    private static final short COLUMN_NUMBER = 5;

    public void formattedDisplay(Exercise ex, int columns) {

        while (ex.hasNext()) {
            System.out.println(ex.next().asString());
        }
    }

    public void formattedDisplay(Exercise ex) {//默认：每行打印5个算式
        formattedDisplay(ex, COLUMN_NUMBER);
    }



}
