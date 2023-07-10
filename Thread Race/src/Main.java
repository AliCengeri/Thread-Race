import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Integer> mainList = new ArrayList<>();

        for (int i = 1; i < 10001; i++) {
            mainList.add(i);
        }

        ExecutorService pool= Executors.newFixedThreadPool(4);

        for (int i = 0; i < 4; i++) {
            int x = i * 2500;
            int y = x + 2500;
            pool.execute(new Runner(mainList.subList(x,y)));
            Thread.sleep(1000);
        }
        pool.shutdown();

        System.out.println(Runner.oddNumbers());
        System.out.println(Runner.evenNumbers());
    }
}