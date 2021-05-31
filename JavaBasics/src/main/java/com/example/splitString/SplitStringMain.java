package com.example.splitString;

import java.util.*;

public class SplitStringMain {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1,张三,70","2,李四,52","3,王五,93","4,张三,83","5,林六,23");
        HashMap<Integer,String[]> map = getSplitString(list);

        HashMap<String,Person> personMap = getPersonMap(map);

        sort(personMap);

    }

    public static HashMap<Integer,String[]> getSplitString(List<String> list){
        //String[] str;
        HashMap<Integer,String[]> map = new HashMap<>();
        for(int i=0;i<list.size();i++){
            String[]  str=list.get(i).split(",");
            map.put(i,str);
        }
        return map;
    }

    public static HashMap<String,Person> getPersonMap(HashMap<Integer,String[]> map){
        HashMap<String,Person> personMap = new HashMap<>();
        for(int i=0;i<map.size();i++){
            String[] str = map.get(i);
            if(personMap.get(str[1]) != null) {
                Person person = personMap.get(str[1]);
                Double temp = Double.valueOf(str[2])+person.score;
                person.score = temp/2;
                personMap.replace(str[1],person);
            }else{
                personMap.put(str[1],
                        new Person(Integer.valueOf(str[0]), str[1], Double.valueOf(str[2])));
            }
        }

        return personMap;
    }

    public static void sort(HashMap<String,Person> personMap){
        HashMap<Double,String> map = new HashMap<>();
        for(Person person : personMap.values()){
            map.put(person.score,person.name);
        }

        //key-sort
        Set set = map.keySet();
        Object[] arr = set.toArray();
        //升序
        Arrays.sort(arr);
        //降序
        //Arrays.sort(arr,Collections.reverseOrder());
        for (Object key : arr) {
            System.out.println(map.get(key) + " " + key);
        }

    }
}
