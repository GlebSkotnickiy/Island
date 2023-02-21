package com.ua.glebskotnickiy.View;

import com.ua.glebskotnickiy.Model.IslandSpace.Cell;
import com.ua.glebskotnickiy.Model.IslandSpace.IslandMap;

public class IslandPrinter implements Runnable {

    private IslandMap islandMap;

    public IslandPrinter(IslandMap islandMap) {
        this.islandMap = islandMap;
    }

    @Override
    public void run() {
        for (Cell[] cell : islandMap.getCells()) {
            for (Cell value : cell) {
                System.out.print(value);
            }
            System.out.println();
        }
        System.out.println();
    }
}
