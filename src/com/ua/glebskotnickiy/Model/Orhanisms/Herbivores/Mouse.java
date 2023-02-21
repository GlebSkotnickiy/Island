package com.ua.glebskotnickiy.Model.Orhanisms.Herbivores;

import com.ua.glebskotnickiy.Model.AbstractOrganisms.Herbivores;
import com.ua.glebskotnickiy.Model.AbstractOrganisms.Organism;
import com.ua.glebskotnickiy.Model.IslandSpace.Cell;
import com.ua.glebskotnickiy.Model.Orhanisms.Plants.Grass;
import com.ua.glebskotnickiy.Model.Orhanisms.Predators.Bear;
import com.ua.glebskotnickiy.Model.Orhanisms.Predators.Boa;
import com.ua.glebskotnickiy.Model.Orhanisms.Predators.Fox;
import com.ua.glebskotnickiy.Model.Orhanisms.Predators.Wolf;

import java.util.HashMap;
import java.util.Map;

public class Mouse extends Herbivores {

    private final double weight = 0.05;
    private final double requiredWeightWorSatiety = 0.01;
    private final int maxNumberPerTurn = 1;
    private final int maxAmount = 500;
    private final String emoji = "\uD83D\uDC2D";
    Map<Class<? extends Organism>, Integer> probabilityToEating = new HashMap<>();
    private Cell cell;
    private double satiety = 0.01;

    {
        {
            probabilityToEating.put(Wolf.class, 0);
            probabilityToEating.put(Boa.class, 0);
            probabilityToEating.put(Fox.class, 0);
            probabilityToEating.put(Bear.class, 0);
            probabilityToEating.put(Horse.class, 0);
            probabilityToEating.put(Deer.class, 0);
            probabilityToEating.put(Rabbit.class, 0);
            probabilityToEating.put(Mouse.class, 0);
            probabilityToEating.put(Goat.class, 0);
            probabilityToEating.put(Sheep.class, 0);
            probabilityToEating.put(Boar.class, 0);
            probabilityToEating.put(Buffalo.class, 0);
            probabilityToEating.put(Duck.class, 0);
            probabilityToEating.put(Caterpillar.class, 90);
            probabilityToEating.put(Grass.class, 100);
        }
    }

    @Override
    public Organism createOrganism() {
        Mouse mouse = new Mouse();
        putToAllOrganisms(mouse);
        return mouse;
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
