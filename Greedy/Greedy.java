package Greedy;

import java.util.Arrays;
import java.util.Collections;

public class Greedy {
    public static void main(String[] args) {
        Integer[] costVer = {2, 1, 3, 1, 4};
        Integer[] costHor = {4, 1, 2};

        Arrays.sort(costVer, Collections.reverseOrder());
        Arrays.sort(costHor, Collections.reverseOrder());

        int h = 0, v = 0;
        int hp = 0, vp = 0;
        int cost = 0;

        while (h < costHor.length && v < costVer.length) {
            if (costVer[v] <= costHor[h]) {
                cost += costHor[h] * (vp + 1);
                hp++;
                h++;
            } else {
                cost += costVer[v] * (hp + 1);
                vp++;
                v++;
            }
        }

        while (h < costHor.length) {
            cost += costHor[h] * (vp + 1);
            h++;
        }

        while (v < costVer.length) {
            cost += costVer[v] * (hp + 1);
            v++;
        }

        System.out.println(cost);
    }
}
