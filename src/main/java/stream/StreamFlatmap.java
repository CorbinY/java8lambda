package stream;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFlatmap {
    public static void main(String[] args) {
        Integer[] integerArr = {1, 2, 4};
        Integer[] integerArr1 = {1, 2, 4};
        List<Integer> integerList = Stream.of(1, 2, 5).collect(Collectors.toList());
        List<Integer> integerList1 = Lists.newArrayList(1, 3, 5);


        //此处必须是相同的类型，不能一个数组一个列表
        // List<Integer> result = Stream.of(integerArr1, integerArr).flatMap(ele -> Arrays.stream(ele)).collect(Collectors.toList());
        List<Integer> result = Stream.of(integerArr1, integerArr).flatMap(Arrays::stream).collect(Collectors.toList());
        System.out.println(result);


        // List<Integer> result1 = Stream.of(integerList, integerList1).flatMap(ele->ele.stream()).collect(Collectors.toList());
        List<Integer> result1 = Stream.of(integerList, integerList1).flatMap(Collection::stream).collect(Collectors.toList());


        //不同的类型需要转化为相同的类型
        Set<Integer> result2 = Stream.of(integerList, Stream.of(integerArr).collect(Collectors.toList())).flatMap(Collection::stream).collect(Collectors.toSet());
        result2.forEach(System.out::println);

    }
}
