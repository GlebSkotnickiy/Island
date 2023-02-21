package com.ua.glebskotnickiy.Model.AbstractOrganisms;

import com.ua.glebskotnickiy.Model.Util.GameWorker;
import com.ua.glebskotnickiy.Model.IslandSpace.Cell;

import java.util.HashSet;

public abstract class Organism {

    public abstract void reproduce();

    public void die() {
        synchronized (this.getCell()) {
            this.getCell().getOrganisms().get(this.getClass()).remove(this);
            this.setCell(null);
        }
    }

    public abstract Organism createOrganism();

    public void putToAllOrganisms(Organism organism) {
        if (GameWorker.allOrganisms.containsKey(organism.getClass())) {
            GameWorker.allOrganisms.get(organism.getClass()).add(organism);
        } else {
            GameWorker.allOrganisms.put(organism.getClass(), new HashSet<>());
            GameWorker.allOrganisms.get(organism.getClass()).add(organism);
        }
    }

    public abstract Cell getCell();

    public abstract void setCell(Cell cell);

    public abstract double getWeight();

    public abstract int getMaxAmount();

    public abstract String getEmoji();
}