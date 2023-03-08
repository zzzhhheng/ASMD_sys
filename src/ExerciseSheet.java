
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

    private static void print(String str) {
        System.out.print(str);
    }

    //一次应用
    public static void main(String[] args) {
        ExerciseSheet sheet = new ExerciseSheet();
        Exercise exercise = new Exercise();
        exercise.generateBinaryExercise(20);

        System.out.println("---- generate and display add exercises ----");
        sheet.formattedDisplay(exercise, 4);
    }
}
