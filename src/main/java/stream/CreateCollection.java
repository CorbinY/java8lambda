package stream;

import com.google.common.collect.Lists;
import org.junit.Assert;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CreateCollection {

    public static void main(String[] args) {
        Integer[] arr = {1, 2, 3, 5, 6, 2};

        List<Integer> integerList = Stream.of(arr).collect(Collectors.toList());
        System.out.println(integerList);
        integerList.add(10);

        Assert.assertEquals(integerList, Arrays.asList(1, 3, 6, 7, 9, 3, 10));
        System.out.println(integerList);


        //-------------------------------------------

        //自动丢弃相同元素
        Set<Integer> integerSet = Stream.of(1, 3, 6, 7, 9, 3).collect(Collectors.toSet());
        System.out.println(integerSet);
List<Integer> list1=new ArrayList<>(integerList);

    }
}
