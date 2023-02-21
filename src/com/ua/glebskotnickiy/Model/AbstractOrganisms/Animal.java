package com.ua.glebskotnickiy.Model.AbstractOrganisms;

import java.util.concurrent.ThreadLocalRandom;

public abstract class Animal extends Organism {

    public void move() {
        for (int i = 0; i < ThreadLocalRandom.current().nextInt(this.getMaxNumberPerTurn()); i++) {
            synchronized (this.getCell()) {
                synchronized (this.getCell().getNextSells()) {
                    this.getCell().getOrganisms().get(this.getClass()).remove(this);
                    int randomCell = ThreadLocalRandom.current().nextInt(this.getCell().getNextSells().size() - 1);
                    this.getCell().getNextSells().get(randomCell).addOrganism(this);
                }
            }
        }
    }

    @Override
    public void reproduce() {
        synchronized (this.getCell()) {
            if (this.getSatiety() > this.getRequiredWeightWorSatiety() * 0.8) {
                if (this.getCell().getOrganisms().get(this.getClass()).size() < this.getMaxAmount()) {
                    if (this.getCell().getOrganisms().get(this.getClass()).size() > 1) {
                        this.getCell().addOrganism(this.createOrganism());
                    }
                }
            }
        }
    }

    public abstract void eat();

    public abstract double getProbabilityToEat(Class<? extends Organism> animal);

    public abstract double getSatiety();

    public abstract void setSatiety(double satiety);

    public abstract double getRequiredWeightWorSatiety();

    public abstract int getMaxNumberPerTurn();

    public abstract String getEmoji();
}
