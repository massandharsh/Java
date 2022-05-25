package com.codejam;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class RangePartition {
    public static void main(String[] args) {
        int t;
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        int ct = 1;
        while(t>0){
            t--;
            long n = sc.nextInt();
            long x = sc.nextInt();
            long y = sc.nextInt();
            long sum = (n*(n+1))/2;
            System.out.print("Case #"+ ct++ + ": ");
            if((x*sum)%(x+y) != 0){
                System.out.println("IMPOSSIBLE");
                continue;
            }
            System.out.println("POSSIBLE");
            long s2 = (x*sum)/(x+y);
            List<Long> ans = new ArrayList<>();
            for(long i =n;i>=1;i--){
                if(s2 <= i){
                    ans.add(s2);
                    break;
                }
                ans.add(i);
                s2 -= i;
                if(s2 == 0)break;
            }
//            Collections.sort(ans);
            System.out.println(ans.size());
            for(Long s : ans){
                System.out.print(s+" ");
            }
            System.out.println();

        }
    }
}
