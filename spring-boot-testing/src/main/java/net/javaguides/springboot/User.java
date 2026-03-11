package net.javaguides.springboot;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;
import java.util.stream.Collectors;

public class User {

 
    public static void main(String[] args) throws IOException,InterruptedException{
        

        String str="abcdeffdc";

        String[] arr= str.split("");
        Map<String,Long> map=Arrays.stream(arr).collect(Collectors.groupingBy(ele->ele, Collectors.counting()));

        map=map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,(ele1,ele2)-> ele1,
            LinkedHashMap::new));

        System.out.println(map);
    


    }
    
} 
 
