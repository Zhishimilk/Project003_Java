package com.bilibili.pokerDemo;

import java.util.*;

public class PokerDemo {
    public static void main(String[] args) {

        //准备牌的花色和牌的数字
        List<String> colors = List.of("♥", "♠", "♣", "♦");
        List<String> nums = List.of("2", "A", "K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3");
        HashMap<Integer, String> pokers = new HashMap<>();
        ArrayList<Integer> keys = new ArrayList<>();
        int index = 0;

        //组装牌
        keys.add(index);
        pokers.put(index, "大王");
        index++;
        keys.add(index);
        pokers.put(index, "小王");
        index++;
        for (int i = 0; i < nums.size(); i++) {

            for (int i1 = 0; i1 < colors.size(); i1++) {
                String p = colors.get(i1) + nums.get(i);

                keys.add(index);
                pokers.put(index, p);
                index++;
            }
        }

        //洗牌
        Collections.shuffle(keys);

        //--------------------------------------------port1

        //创建玩家
        TreeSet<Integer> player01 = new TreeSet<>();
        TreeSet<Integer> player02 = new TreeSet<>();
        TreeSet<Integer> player03 = new TreeSet<>();
        TreeSet<Integer> diPai = new TreeSet<>();

        //发牌
        for (int i = 0; i < keys.size(); i++) {

            if(keys.size() - i <= 3){
                diPai.add(keys.get(i));
            }else if(i%3 == 0){
                player01.add(keys.get(i));
            }else if(i%3 == 1){
                player02.add(keys.get(i));
            }else if(i%3 == 2){
                player03.add(keys.get(i));
            }
        }

        //看牌
        lookPokers("刘德华", pokers, player01);
        lookPokers("周润发", pokers, player02);
        lookPokers("周星驰", pokers, player03);
        lookPokers("底牌", pokers, diPai);

        //--------------------------------------------port2

        //创建玩家
        ArrayList<Integer> player04 = new ArrayList<>();
        ArrayList<Integer> player05 = new ArrayList<>();
        ArrayList<Integer> player06 = new ArrayList<>();
        ArrayList<Integer> diPai2 = new ArrayList<>();

        //发牌
        for (int i = 0; i < keys.size(); i++) {
            if(keys.size() - i <= 3){
                diPai2.add(keys.get(i));
            }else if(i%3 == 0){
                player04.add(keys.get(i));
            }else if(i%3 == 1){
                player05.add(keys.get(i));
            }else if(i%3 == 2){
                player06.add(keys.get(i));
            }
        }

        //看牌
        lookPokers2("王德华", pokers, player04);
        lookPokers2("张润发", pokers, player05);
        lookPokers2("李星驰", pokers, player06);
        lookPokers2("底牌", pokers, diPai2);
    }

    //创建看牌方法

    public static void lookPokers(String name, HashMap pokers, TreeSet player){
        System.out.print(name + ": ");
        Iterator iterator = player.iterator();
        while(iterator.hasNext()){
            System.out.print(pokers.get(iterator.next()) + " ");
        }
        System.out.println("");
    }

    public static void lookPokers2(String name, HashMap pokers, ArrayList<Integer> player){
        System.out.print(name + ": ");
        Collections.sort(player);
        Iterator iterator = player.iterator();
        while(iterator.hasNext()){
            System.out.print(pokers.get(iterator.next()) + " ");
        }
        System.out.println("");
    }
}
