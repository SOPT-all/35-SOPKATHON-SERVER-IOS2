package jungleEscape.quest;

public class SynchronizedCounter {
    private int counter = 0; // 일반 int 사용
    private final int maxValue; // 최대 값 설정

    public SynchronizedCounter(int maxValue) {
        this.maxValue = maxValue;
    }

    public synchronized void incrementAndSet() {
        counter++;
        if (counter > maxValue) {
            counter = 1; // maxValue를 넘으면 1로 초기화
        }
    }

    public synchronized int getCounter() {
        return counter;
    }
}

