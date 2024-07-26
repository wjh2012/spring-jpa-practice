package practice.concurrency;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

@SpringBootTest
@Rollback(false)
public class JoinEventTest {

    @Autowired
    private EventService eventService;

    @Test
    public void testJoinEvent() throws InterruptedException {
        int totalThreads = 100;
        int perThread = 1;

        CountDownLatch countDownLatch = new CountDownLatch(totalThreads);
        ExecutorService executorService = Executors.newFixedThreadPool(totalThreads);

        for (int i = 0; i < totalThreads; i++) {
            final int finalI = i;
            executorService.submit(() -> {
                try {
                    for (int j = 0; j < perThread; j++) {
                        RequestDto request = RequestDto.builder()
                            .number(finalI)
                            .build();
                        eventService.memberJoinEvent(request);
                    }
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        countDownLatch.await();
        executorService.shutdown();
    }
}
