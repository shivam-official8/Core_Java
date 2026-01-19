package Core_Advance_Java.Day_5;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Streams {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8);
        Stream<Integer> stream = list.stream();
        String[] arr = {"1", "hello", "A", "SE", "DM"};
        Stream<String> stream1 = Arrays.stream(arr);
        Stream<Integer> stream2 = Stream.of(1,2,3,4,5,6);
        Stream<Integer> stream3 = Stream.iterate(1,n->n+1).limit(10);
        stream2.filter(n->n%2==0).forEach(n-> System.out.println(n));
        stream.map(n->n+2).forEach(System.out::print);
        System.out.println(stream1.toList());
        System.out.println(stream3.reduce((a,b)->a+b));
        list.parallelStream().forEach(n-> System.out.println(n+" "+Thread.currentThread().getName()));
        IntStream.range(1,5).forEach(System.out::println);

        Stream<String> st = Stream.of(arr);
        AtomicInteger i = new AtomicInteger(0);
        st.filter(x->i.getAndIncrement()%2==0).forEach(System.out::print);

        Iterable<Integer> iterable = Arrays.asList(1,2,3,4,5,6);
        Spliterator<Integer> spl = iterable.spliterator();
        Stream<Integer> sm = StreamSupport.stream(spl,false);

        Set<Integer> set = sm.collect(Collectors.toSet());


    }
}
