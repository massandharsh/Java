package com.codejam;

import java.util.*;
import java.util.stream.IntStream;

public class Solution {
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int ct = 1;
        while(t > 0){
            t--;
            int q = sc.nextInt();
            StringBuilder s = new StringBuilder(sc.next());
            Map<Character,Integer> digits= new HashMap<>();
            Map<Character,Integer> small= new HashMap<>();
            Map<Character,Integer> large= new HashMap<>();
            Map<Character,Integer> spe = new HashMap<>();
            spe.put('#',1);
            spe.put('@',1);
            spe.put('*',1);
            spe.put('&',1);
            IntStream.range(0,10).forEach((a)->digits.put((char) ('0' + a),1));
            IntStream.range(0,26).forEach((a)->small.put((char)('a'+a),1));
            IntStream.range(0,26).forEach((a)->large.put((char)('A'+a),1));

            boolean digit = false;
            boolean smallD = false;
            boolean largeD = false;
            boolean special = false;
            for(int i = 0 ; i < s.length() ; ++i){
                if(digits.containsKey(s.charAt(i))){
                    digit = true;
                }
                if(small.containsKey(s.charAt(i))){
                    smallD = true;
                }
                if(large.containsKey(s.charAt(i))){
                    largeD = true;
                }
                if(spe.containsKey(s.charAt(i))){
                    special = true;
                }
            }
            if(largeD && smallD && digit && special && s.length()>=7){
                System.out.println("Case #" + ct++ + ": " + s);
                continue;
            }
            if(!special){
                s.append("#");
            }
            if(!largeD){
                s.append("A");
            }
            if(!smallD){
                s.append("a");
            }
            if(!digit){
                s.append("1");
            }
            while (s.length() < 7){
                s.append(1);
            }

            System.out.println("Case #" + ct++ + ": " + s);
        }
    }
}
