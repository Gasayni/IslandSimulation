package com.company;

public class Details {
    public String randomMoveToCell() {
        int n = (int) (Math.random() * 4) + 1;
        if (n == 1) return "left";
        else if (n == 2) return "right";
        else if (n == 3) return "up";
        else return "down";
    }

    public int randomizer(int fromNum, int untilNum) {
        return (int) (Math.random() * untilNum) + fromNum;
    }
}
