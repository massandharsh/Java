package com.codejam;

import java.util.*;

class Pair{
    Integer distance;
    int direction;
    Integer number;
    public Pair(Integer distance,int direction,int number){
        this.distance = distance;
        this.direction = direction;
        this.number = number;
    }

    @Override
    public String toString() {
        return "Pair{" +
                "distance=" + distance +
                ", direction=" + direction +
                '}';
    }
}

public class Ants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int ct = 1;
        while(t>0){
            t--;
            int n = sc.nextInt();
            int l = sc.nextInt();
            int q = n;
            Pair [] arr = new Pair[q];
            for(int i = 0 ; i < n ; ++i){
                int x = sc.nextInt();
                int y = sc.nextInt();
                arr[i] = new Pair(x,y,i+1);
            }
            Arrays.sort(arr,(a,b)->{
                if(a.direction == 0 && b.direction == 0){
                    return a.distance.compareTo(b.distance);
                }
                if(a.direction == 1 && b.direction == 1){
                    return a.distance.compareTo(b.distance);
                }
                if(a.direction == 0){
                    return -1;
                }
                return 1;
            });
            int start = 0;
            int end = n-1;
//            System.out.println(Arrays.toString(arr));
            List<Pair> po = new ArrayList<>();
            while(start<n&&end>=0&&start < end){
                if(arr[start].direction == 0 && arr[end].direction == 1 && arr[start].distance<arr[end].distance){
                    if(arr[start].distance - 1 <= l - arr[end].distance){
                        arr[start].distance = arr[start].distance - 1;
                        po.add(arr[start]);
                        start++;
                    }
                    else{
                        arr[end].distance = l-arr[end].distance;
                        po.add(arr[end]);
                        end--;
                    }
                }
                else{
                    break;
                }
            }

            int i = start;
            int j = end;
            for(;i<=j;++i){
                if(arr[i].direction == 1){
                    po.add(new Pair(arr[i].distance-1,0,arr[i].number));
                }
                else{
                    po.add(new Pair(l-arr[i].distance,0,arr[i].number));
                }
            }
            po.sort((a1, a2) -> {
                if(a1.distance > a2.distance){
                    return 1;
                }
                if(a1.distance.equals(a2.distance)){
                    return a1.number.compareTo(a2.number);
                }
                return -1;

            });
            System.out.print("Case #" + ct++ + ": " );
            for(Pair p : po){
                System.out.print(p.number+" ");
            }
            System.out.println();

        }
    }
}
