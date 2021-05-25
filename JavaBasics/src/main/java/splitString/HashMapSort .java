package splitString;

import java.util.*;

//Author:Hibiki last modified in 2018.10.04
class HashMapSort {

    public static void main(String[] args) {
        Map phone = new HashMap();
        phone.put("李四", 52.00);
        phone.put("张三", 76.00);
        phone.put("王五", 93.00);
        phone.put("林六", 23.00);
        //key-sort
        Set set = phone.keySet();
        Object[] arr = set.toArray();
        Arrays.sort(arr);
        for (Object key : arr) {
            System.out.println(key + ": " + phone.get(key));
        }
        System.out.println();
        //value-sort
        List<Map.Entry<String, Double>> list = new ArrayList<Map.Entry<String, Double>>(phone.entrySet());
        //list.sort()
        list.sort(new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //collections.sort()
        Collections.sort(list, new Comparator<Map.Entry<String, Double>>() {
            @Override
            public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });
        //for
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getKey() + ": " + list.get(i).getValue());
        }
        System.out.println();
        //for-each
        for (Map.Entry<String, Double> mapping : list) {
            System.out.println(mapping.getKey() + ": " + mapping.getValue());
        }
    }
}


