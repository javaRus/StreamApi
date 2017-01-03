import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CountFilter {
    public static void main(String[] args) {
        List<MyInt> myInts = Arrays.asList(new MyInt(1), new MyInt(8), new MyInt(5), new MyInt(2));
        myInts.stream()
            .map(MyInt::plusRandom)
            .peek(s -> System.out.println(s.getMyInt()))
            .collect(Collectors.toList());
    }
}

class MyInt {
    private int myInt;

    public MyInt(int myInt) {
        this.myInt = myInt;
    }

    public int getMyInt() {
        return myInt;
    }

    public MyInt plusRandom() {
        return new MyInt(((int) (Math.random() * 5) + myInt));
    }

    public Stream<MyInt> addToStream(Stream<MyInt> stream, MyInt myInt) {
        return Stream.concat(stream, Stream.of(myInt));
    }
}

//@FunctionInterface
interface FunctionInterface {
    int getValue();
}