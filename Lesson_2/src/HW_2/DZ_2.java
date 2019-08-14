package HW_2;

import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class DZ_2 {
    private static final int ARRAY_CAPACITY = 10_000;

    public static void main(String[] args) throws InterruptedException, TimeoutException, ExecutionException {
        Array arr = new OrderedArrayImpl(ARRAY_CAPACITY);

        randomInitialize(arr);

        Array<Integer> copy1 = arr.copy();
        Array<Integer> copy2 = arr.copy();
        Array<Integer> copy3 = arr.copy();

        ExecutorService executorService = Executors.newFixedThreadPool(3);

        List<Callable<Void>> tasks = List.of(
                measureTime(() -> copy1.sortBubble(), "Sort Bubble"),
                measureTime(() -> copy2.sortSelect(), "Sort Select"),
                measureTime(() -> copy3.sortInsert(), "Sort Insert")
        );

        for (Future<Void> future : executorService.invokeAll(tasks)) {
            future.get(1, TimeUnit.MINUTES);
        }

        executorService.shutdown();
    }

    private static void randomInitialize(Array<Integer> arr) {
        Random random = new Random();

        for (int i = 0; i < ARRAY_CAPACITY; i++) {
            arr.insert(random.nextInt());
        }
    }

    private static Callable<Void> measureTime(Runnable action, String actionName) {
        return () -> {
            long startTime = System.nanoTime();
            action.run();
            long finishTime = System.nanoTime();
            long duration = finishTime - startTime;

            System.out.println(String.format("%s took time: %d ms.",
                    actionName,
                    TimeUnit.NANOSECONDS.toMillis(duration)));

            return null;
        };

    }

}
