package com.ua.glebskotnickiy.Model.AbstractOrganisms;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

public abstract class Predator extends Animal {

    @Override
    public void eat() {
        synchronized (this.getCell()) {
            for (Class<? extends Organism> organisms : this.getCell().getOrganisms().keySet()) {
                Set<Organism> copySet = new HashSet<>(this.getCell().getOrganisms().get(organisms));
                for (Organism organism : copySet) {
                    if (organism instanceof Animal && this.getSatiety() < this.getRequiredWeightWorSatiety() * 0.70) {
                        double probability = this.getProbabilityToEat(organism.getClass());
                        if (ThreadLocalRandom.current().nextInt(100) < probability) {
                            this.setSatiety((int) (this.getSatiety() + organism.getWeight()));
                            organism.die();
                        }
                    }
                }
            }
        }
    }
}
