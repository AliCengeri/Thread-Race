import java.util.ArrayList;
import java.util.List;

public class Runner implements Runnable {
    private static List<Integer> runList = new ArrayList<>();
    private static ArrayList<Integer> oddNumberList = new ArrayList<>();
    private static ArrayList<Integer> evenNumberList = new ArrayList<>();

    public Runner(List<Integer> runList) {
        this.runList = runList;
    }

    @Override
    public void run() {
        for (int i : runList) {
            synchronized (evenNumberList) {
                if (i % 2 == 0) {
                    evenNumberList.add(i);
                }
            }
            synchronized (oddNumberList) {
                if (i % 2 == 1) {
                    oddNumberList.add(i);
                }
            }
        }
    }

    public static List<Integer> oddNumbers() {
        return oddNumberList;
    }

    public static List<Integer> evenNumbers() {
        return evenNumberList;
    }
}
