package com.geekbrains.java.algorithms;

public class Backpack {

    /**
     *
     * @param weight - массив значений веса предметов
     * @param val - массив значений ценности предметов
     * @param w - максимально допустимый вес вещей в рюкзаке
     * @param itemNum - элемент, который мы хотим положить на текущей итерации
     * @return максимально возможная ценность предметов, которые могут поместиться в рюкзаке
     */
    public int recursive(int[] weight, int[] val, int w, int itemNum) {
        if (w == 0 || itemNum == weight.length) {
            return 0;
        }
        if (weight[itemNum] > w) {
            return recursive(weight, val, w,itemNum + 1);
        }
        int without = recursive(weight, val, w,itemNum + 1);
        int with = val[itemNum] + recursive(weight, val, w - weight[itemNum],itemNum + 1);
        return with > without? with : without;
    }

    public int recursive(int[] weight, int[] val, int w) {
        return recursive(weight, val, w, 0);
    }

    public static void main(String[] args) {
        Backpack bp = new Backpack();
        int[] weight = {2, 3, 3, 4};
        int[] val = {1, 2, 5, 8};
        int w = 7;

        System.out.println(bp.recursive(weight, val, w));
    }
}
