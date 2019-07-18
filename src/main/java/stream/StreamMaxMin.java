package stream;

import com.google.common.collect.Lists;
import stream.model.User;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMaxMin {

    public static void main(String[] args) {

        List<User> list = Lists.newArrayList(new User(1), new User(4), new User(2));

//        User u = list.stream().min(new Comparator<User>() {
//            @Override
//            public int compare(User o1, User o2) {
//                return o1.getAge()-o2.getAge();
//            }
//        }).orElse(null);
//-------------------------------------------------------------
//        User u = list.stream().min((o1, o2) -> o1.getAge()-o2.getAge()).orElse(null);
//-------------------------------------------------------------
        User u = list.stream().min(Comparator.comparingInt(User::getAge)).orElse(null);
        User u1 = list.stream().max(Comparator.comparingInt(User::getAge)).orElse(null);


        System.out.println(u);
        System.out.println(u1);
    }


}
