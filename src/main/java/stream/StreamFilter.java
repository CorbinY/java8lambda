
package stream;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFilter {
    public static void main(String[] args) {
        String[] arr = {"b", "a", "C", "?"};
        //转成大写，并倒叙,筛选出！=？的元素放到列表中
        //  List<String> list= Stream.of(arr).map(element->element.toUpperCase()).collect(Collectors.toList());
        List<String> list = Stream.of(arr).map(String::toUpperCase).sorted().filter(ele->!"?".equals(ele)).collect(Collectors.toList());
        Collections.reverse(list);

        System.out.println(list);

    }
}
