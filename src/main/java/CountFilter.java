import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.IntStream;

public class CountFilter {
    public static void main(String[] args) {
        AtomicLong atomicLong = new AtomicLong();
        List<MyInt> myInts = Arrays.asList(new MyInt(1), new MyInt(8), new MyInt(5), new MyInt(2));
        myInts.stream()
            .map(s ->s.plusRandom())
            .peek(s -> )
    }
}

class MyInt {
    private int myInt;

    public MyInt(int myInt) {
        this.myInt = myInt;
    }

    public MyInt plusRandom() {
        return new MyInt((int) (Math.random() + myInt));
    }


}
