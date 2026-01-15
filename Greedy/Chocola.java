package Greedy;

import java.util.*;

public class Chocola {
    public static void main(String[] args) {
        Integer[] Hor = {4, 1, 2};      
        Integer[] Ver = {1, 2, 3, 1, 4}; 

        Arrays.sort(Hor, Collections.reverseOrder()); 
        Arrays.sort(Ver, Collections.reverseOrder()); 

        int cost = 0;
        int hp = 1, vp = 1;  
        int h = 0, v = 0;

        while(h < Hor.length && v < Ver.length) {
            if(Ver[v] >= Hor[h]) {
                cost += Ver[v] * hp;
                vp++;  
                v++;
            } else {
                cost += Hor[h] * vp;
                hp++;  
                h++;
            }
        }

        while(h < Hor.length) {
            cost += Hor[h] * vp;
            hp++;
            h++;
        }

        while(v < Ver.length) {
            cost += Ver[v] * hp;  
            vp++;
            v++;
        }
        
        System.out.println("Minimum cost: " + cost);
    }
}