package stream;

import java.util.stream.Stream;

public class StreamReduce {
    public static void main(String[] args) {
       int count= Stream.of(1,5,0,8).reduce(0, Integer::sum);
       System.out.println(count);
    }
}
