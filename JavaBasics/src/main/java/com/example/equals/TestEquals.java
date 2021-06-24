package com.example.equals;

import java.util.Arrays;

/**
 * @Author: lyh
 * @Date: 2021/06/23  14:59
 * @Description:
 */
public class TestEquals {
    public static void main(String[] args) {
        String temp = "Test";
        String temp2 = "Test";
        String temp3 = "Test";

        //自反性
        System.out.println(temp.equals(temp));
        //对称性
        System.out.println(temp.equals(temp2) + "---" + temp2.equals(temp));
        //传递性
        System.out.println(temp.equals(temp2) + "---" + temp2.equals(temp3) + "---" + temp.equals(temp3));
        //一致性
        System.out.println(temp.equals(temp2));

        //完善的重写equals
        /**
         * 1，将equals的Object类显式参数命名为otherObject，稍后需要将它转换成另一个叫做 other 的变量　　
         *
         * 2，检测otherObject是否与this引用自同一个对象。
         * if (this = otherObject) return true;
         *
         * 3，检测otherObject是否为null，是的话返回false。
         *  if (otherObject = null) return false;
         *
         * 4，检测this与otherObject是否属于同一个类
         *      如果 equals 的语义在每个子类中有所改变，就使用 getClass 检测
         *      if (getClass() != otherObject.getCIassO) return false;
         *
         *      如果所有的子类都拥有统一的语义，就使用 instanceof 检测：
         *      if (!(otherObject instanceof ClassName)) return false;
         *
         * 5，将otherObject转换为this类型的变量。
         *  ClassName other = (ClassName) otherObject
         *
         * 6，现在开始进行私有数据域的比较，对于基本类型如数值，字符和布尔类型使用==进行比较，对对象域使用equals进行比较，所有域都相同则返回true。
         *
         *  return fieldl == other.field
         *  && Objects.equa1s(fie1d2, other.field2)
         *  如果在子类中重新定义 equals, 就要在其中包含调用 super.equals(other)
         *
         * 7，使用@Override声明有助于错误检查。
         */

        //检测数组元素是否相等
        Integer[] integers = {1,2,4,5};
        Integer[] integers2 = {1,2,4,5};
        System.out.println("数组:" + Arrays.equals(integers,integers2));
    }
}
