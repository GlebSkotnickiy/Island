package com.ua.glebskotnickiy.Model.Orhanisms.Plants;

import com.ua.glebskotnickiy.Model.AbstractOrganisms.Organism;
import com.ua.glebskotnickiy.Model.AbstractOrganisms.Plant;
import com.ua.glebskotnickiy.Model.IslandSpace.Cell;

public class Grass extends Plant {
    private final double weight = 0.30;
    private final int maxAmount = 1000000;
    private final String emoji = "\uD83C\uDF3F";
    private Cell cell;

    @Override
    public Organism createOrganism() {
        Grass grass = new Grass();
        putToAllOrganisms(grass);
        return grass;
    }

    @Override
    public Cell getCell() {
        return cell;
    }

    @Override
    public void setCell(Cell cell) {
        this.cell = cell;
    }

    @Override
    public double getWeight() {
        return weight;
    }

    @Override
    public int getMaxAmount() {
        return maxAmount;
    }

    @Override
    public String getEmoji() {
        return emoji;
    }
}
