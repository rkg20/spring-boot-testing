package net.javaguides.springboot.others;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.stream.Collectors;

public class Example2 {
    
    public static void main(String[] args) {
        List<Integer> list=Arrays.asList(5,2,1,4,5,2,7);

        list=list.stream().distinct().sorted().collect(Collectors.toList());

        System.out.println(list);


    }

}
