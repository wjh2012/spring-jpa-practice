package practice.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ThreadTest {

    @Test
    public void test() {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
    }
}
