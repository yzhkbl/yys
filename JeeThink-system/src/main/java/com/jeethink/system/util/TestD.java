package com.jeethink.system.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestD {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("hello");
        list.add("world");
        //List<Object> a=getDuplicateElements(list.stream());

        System.out.println();
    }

    public static <T> List<T> getDuplicateElements(Stream<T> stream) {
        return stream
                .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b))
                .entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .map(entry -> entry.getKey())
                .collect(Collectors.toList());
    }
}
