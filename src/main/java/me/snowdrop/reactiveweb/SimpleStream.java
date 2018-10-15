package me.snowdrop.reactiveweb;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SimpleStream {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(10,15,6);
        // System.out.println(sumIterator(values));
        // System.out.println(sumStream(values));
        // System.out.println(rangeStream(values));
        values
          .stream()
          .forEach(System.out::println);
    }

    private static int sumIterator(List<Integer> list) {
        Iterator<Integer> it = list.iterator();
        int sum = 0;
        while (it.hasNext()) {
            int num = it.next();
            if (num > 10) {
                sum += num;
            }
        }
        return sum;
    }

    private static int sumStream(List<Integer> list) {
        return list.parallelStream().filter(i -> i > 10).mapToInt(i -> i).sum();
    }

    private static void rangeStream(List<Integer> list) {
        list.stream().forEach(System.out::println);
    }

}
