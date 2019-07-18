package stream;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.stream.Stream;

/**
 * 计算集合中 特定条件的的元素个数
 */
public class ElementCount {
    public static void main(String[] args) {

        List<Integer> integerList = Lists.newArrayList(1, 4, 65, 8);
        long count = integerList.stream().filter(num -> num > 4).count();
        System.out.println(count);


    }
}
