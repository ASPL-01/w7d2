package com.chyld;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args){
        // Create a list of numbers and filter
        int[] nums1 = {-8, -5, 2, 4, 5, 99, 100};
        IntStream stream1 =  Arrays.stream(nums1);
        List<Integer> nums2 = new ArrayList<>();

        for(int i = 0; i < nums1.length; i++){
            nums2.add(nums1[i]);
        }

        Predicate<Integer> isPositive = n -> n > 0;
        List<Integer> evens = nums2
                .stream()
                .filter(MyMath::isEven)
                .filter(n -> n < 100)
                .filter(isPositive)
                .map(n -> n * n)
                .map(MyMath::addOne)
                .collect(Collectors.toList());

        int sum = evens.stream().reduce(0, (acc, val) -> acc + val);
        System.out.println(sum);

        // Infinite Streams

        Stream<Integer> nums3 = Stream.iterate(10, n -> n + 3);
        nums3.limit(10).forEach(n -> {
            System.out.println(n);
        });

        //find sum of first 20 values of nums3
        int sum1 = nums3.limit(20).reduce(0, (a, c) -> a + c);

        // Steams using Composite objects

        List<Dog> dogs = new ArrayList<>();
        dogs.add(new Dog("Fido", 3, Gender.MALE));
        dogs.add(new Dog("Lassy", 4, Gender.FEMALE));
        dogs.add(new Dog("Barka", 5, Gender.FEMALE));
        dogs.add(new Dog("Bob", 10, Gender.MALE));
        dogs.add(new Dog("Sally", 12, Gender.FEMALE));


        List<Dog> maleDogsUnder10YearsOld = dogs
                .stream()
                .filter(d -> d.getGender() == Gender.MALE)
                .filter(d -> d.getAge() < 10)
                .collect(Collectors.toList());

        //dogs.stream().
    }
}
