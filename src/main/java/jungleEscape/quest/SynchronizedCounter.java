package jungleEscape.quest;

import org.springframework.stereotype.Component;

@Component
public class SynchronizedCounter {
    private int counter = 1; // 일반 int 사용
    private final int maxValue = 5; // 최대 값 설정

    public SynchronizedCounter() {
    }

    public synchronized void incrementAndSet() {
        counter++;
        if (counter > maxValue) {
            counter = 1; // maxValue를 넘으면 1로 초기화
        }
    }

    public synchronized int getCounter() {
        return counter/3;
    }
}

