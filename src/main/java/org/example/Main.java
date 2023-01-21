package org.example;

import org.example.base.BaseClass;
import org.example.genericrepository.GeneralRepository;
import org.example.genericrepository.GeneralRepositoryImpl;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        Object[] array=new Object[]{11,12,13,14,15};
//        Object[] temp=new Object[array.length+5];
//        System.arraycopy(array,0,temp,0,array.length);
//        System.out.println(Arrays.toString(temp));

        GeneralRepositoryImpl<Integer> genericRepository = new GeneralRepositoryImpl<>();
        BaseClass<Integer> num1 = new BaseClass<>();
        num1.setId(11);
        BaseClass<Integer> num2 = new BaseClass<>();
        num2.setId(12);
        BaseClass<Integer> num3 = new BaseClass<>();
        num3.setId(13);
        BaseClass<Integer> num4 = new BaseClass<>();
        num4.setId(12);
        BaseClass<Integer> num5 = new BaseClass<>();
        num5.setId(15);
        BaseClass<Integer> num6 = new BaseClass<>();
        num6.setId(16);
        genericRepository.add(num1);
        genericRepository.add(num2);
        genericRepository.add(num3);
        genericRepository.add(num4);
        genericRepository.add(num5);
        genericRepository.add(num6);
        genericRepository.printAll();

        System.out.println();
        System.out.println("get element by Index:" + genericRepository.get(2));
        System.out.println("get element by id:" + genericRepository.getById(15));
        genericRepository.update(2, num4);
        System.out.println("update:" + genericRepository.get(2));
        System.out.println("findFirst:" + genericRepository.findFirst(12));

        genericRepository.remove(2);
        genericRepository.removeByElement(11);
        System.out.println("findFirstById:"+genericRepository.findFirstById(14));
      //  genericRepository.removeAll(12);
        genericRepository.printAll();
        genericRepository.clear();

    }
}