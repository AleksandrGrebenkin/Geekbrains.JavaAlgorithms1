package com.geekbrains.java.algorithms;

public class RecursiveExponentiation {
    public int recusriveExponentiation(int number, int power) {
        if (power == 0) {
            return 1;
        }
        return number * recusriveExponentiation(number, power - 1);
    }

    public static void main(String[] args) {
        RecursiveExponentiation re = new RecursiveExponentiation();
        System.out.println(re.recusriveExponentiation(2, 10));
    }
}
