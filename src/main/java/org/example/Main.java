package org.example;

import org.example.genericrepository.GenericRepository;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        Object[] array=new Object[]{11,12,13,14,15};
//        Object[] temp=new Object[array.length+5];
//        System.arraycopy(array,0,temp,0,array.length);
//        System.out.println(Arrays.toString(temp));

        GenericRepository<Integer> genericRepository=new GenericRepository<>();
        genericRepository.add(11);
        genericRepository.add(12);
        genericRepository.add(13);
        genericRepository.add(14);
        genericRepository.add(12);
        genericRepository.add(16);
        genericRepository.add(17);
        genericRepository.add(12);
        genericRepository.add(19);
        genericRepository.add(20);
        genericRepository.removeAll(12);
       // genericRepository.clear();
        genericRepository.printAll();
    }
}