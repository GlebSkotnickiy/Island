package com.ua.glebskotnickiy.Model.Orhanisms.Predators;

import com.ua.glebskotnickiy.Model.AbstractOrganisms.Organism;
import com.ua.glebskotnickiy.Model.AbstractOrganisms.Predator;
import com.ua.glebskotnickiy.Model.IslandSpace.Cell;
import com.ua.glebskotnickiy.Model.Orhanisms.Herbivores.*;
import com.ua.glebskotnickiy.Model.Orhanisms.Plants.Grass;

import java.util.HashMap;
import java.util.Map;

public class Tiger extends Predator {

    public static final String emoji = "\uD83D\uDC2F";
    private final int maxNumberPerTurn = 2;
    private final int maxAmount = 30;
    Map<Class<? extends Organism>, Integer> probabilityToEating = new HashMap<>();
    private Cell cell;
    private double weight = 8;
    private double satiety = 2;
    private double requiredWeightWorSatiety = 2;

    {
        {
            probabilityToEating.put(Wolf.class, 60);
            probabilityToEating.put(Boa.class, 10);
            probabilityToEating.put(Fox.class, 50);
            probabilityToEating.put(Bear.class, 20);
            probabilityToEating.put(Horse.class, 40);
            probabilityToEating.put(Deer.class, 50);
            probabilityToEating.put(Rabbit.class, 20);
            probabilityToEating.put(Mouse.class, 10);
            probabilityToEating.put(Goat.class, 40);
            probabilityToEating.put(Sheep.class, 50);
            probabilityToEating.put(Boar.class, 30);
            probabilityToEating.put(Buffalo.class, 20);
            probabilityToEating.put(Duck.class, 70);
            probabilityToEating.put(Caterpillar.class, 0);
            probabilityToEating.put(Grass.class, 0);
        }
    }

    @Override
    public Organism createOrganism() {
        Tiger tiger = new Tiger();
        putToAllOrganisms(tiger);
        return tiger;
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
    public double getSatiety() {
        return satiety;
    }

    @Override
    public void setSatiety(double satiety) {
        this.satiety = satiety;
    }

    @Override
    public double getRequiredWeightWorSatiety() {
        return requiredWeightWorSatiety;
    }

    @Override
    public double getProbabilityToEat(Class<? extends Organism> animal) {
        return probabilityToEating.get(animal);
    }

    @Override
    public int getMaxNumberPerTurn() {
        return maxNumberPerTurn;
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