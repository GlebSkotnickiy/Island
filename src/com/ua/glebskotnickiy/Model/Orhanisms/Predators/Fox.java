package com.ua.glebskotnickiy.Model.Orhanisms.Predators;

import com.ua.glebskotnickiy.Model.AbstractOrganisms.Organism;
import com.ua.glebskotnickiy.Model.AbstractOrganisms.Predator;
import com.ua.glebskotnickiy.Model.IslandSpace.Cell;
import com.ua.glebskotnickiy.Model.Orhanisms.Herbivores.*;
import com.ua.glebskotnickiy.Model.Orhanisms.Plants.Grass;

import java.util.HashMap;
import java.util.Map;

public class Fox extends Predator {

    public static final String emoji = "\uD83E\uDD8A";
    private final int maxNumberPerTurn = 2;
    private final int maxAmount = 30;
    Map<Class<? extends Organism>, Integer> probabilityToEating = new HashMap<>();
    private Cell cell;
    private double weight = 8;
    private double satiety = 2;
    private double requiredWeightWorSatiety = 2;

    {
        {
            probabilityToEating.put(Wolf.class, 0);
            probabilityToEating.put(Boa.class, 0);
            probabilityToEating.put(Fox.class, 0);
            probabilityToEating.put(Bear.class, 0);
            probabilityToEating.put(Horse.class, 0);
            probabilityToEating.put(Deer.class, 0);
            probabilityToEating.put(Rabbit.class, 70);
            probabilityToEating.put(Mouse.class, 90);
            probabilityToEating.put(Goat.class, 0);
            probabilityToEating.put(Sheep.class, 0);
            probabilityToEating.put(Boar.class, 0);
            probabilityToEating.put(Buffalo.class, 0);
            probabilityToEating.put(Duck.class, 60);
            probabilityToEating.put(Caterpillar.class, 40);
            probabilityToEating.put(Grass.class, 0);
        }
    }

    @Override
    public Organism createOrganism() {
        Fox fox = new Fox();
        putToAllOrganisms(fox);
        return fox;
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
