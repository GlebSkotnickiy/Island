package com.ua.glebskotnickiy.Model.IslandSpace;

import com.ua.glebskotnickiy.Model.AbstractOrganisms.Organism;
import com.ua.glebskotnickiy.Model.Orhanisms.Plants.Grass;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class Cell {

    private final List<Cell> nextSells = new ArrayList<>();
    private final boolean isSunnyWeather = ThreadLocalRandom.current().nextBoolean();
    private volatile Map<Class<? extends Organism>, Set<Organism>> organisms = new HashMap<>();

    public void addOrganism(Organism organism) {
        synchronized (organisms) {
            if (organisms.containsKey(organism.getClass())) {
                if (this.getOrganisms().get(organism.getClass()).size() < organism.getMaxAmount()) {
                    organisms.get(organism.getClass()).add(organism);
                    organism.setCell(this);
                }
            } else {
                organisms.put(organism.getClass(), new HashSet<>());
                organisms.get(organism.getClass()).add(organism);
                organism.setCell(this);
            }
        }
    }

    public String getEmojiOfBestAnimal() {
        synchronized (organisms) {
            Set<Organism> setOfBestAnimal = getBestAnimal(organisms);
            String result = "\uD83C\uDF3F" + " ";
            if (setOfBestAnimal != null && setOfBestAnimal.size() != 0) {
                result = setOfBestAnimal.stream().findFirst().get().getEmoji() + " ";
            }
            return result;
        }
    }

    public Set<Organism> getBestAnimal(Map<Class<? extends Organism>, Set<Organism>> organisms) {
        synchronized (organisms) {
            Set<Organism> maxEntry = null;
            Map<Class<? extends Organism>, Set<Organism>> copyMap = new HashMap<>(organisms);
            copyMap.remove(Grass.class);
            for (Set<Organism> entry : copyMap.values()) {
                if (maxEntry == null || entry.size() > maxEntry.size()) {
                    maxEntry = entry;
                }
            }
            return maxEntry;
        }
    }

    public Map<Class<? extends Organism>, Set<Organism>> getOrganisms() {
        return organisms;
    }

    public List<Cell> getNextSells() {
        return nextSells;
    }

    public void setNextCells(Cell cell) {
        nextSells.add(cell);
    }

    public boolean getWeather() {
        return isSunnyWeather;
    }

    @Override
    public synchronized String toString() {
        return getEmojiOfBestAnimal();
    }
}
