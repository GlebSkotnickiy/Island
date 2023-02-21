package com.ua.glebskotnickiy.Model.Util;

import com.ua.glebskotnickiy.Model.AbstractOrganisms.Animal;
import com.ua.glebskotnickiy.Model.AbstractOrganisms.Organism;
import com.ua.glebskotnickiy.Model.IslandSpace.IslandMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GameWorker implements Runnable {

    public volatile static Map<Class<? extends Organism>, Set<Organism>> allOrganisms = new HashMap<>();
    private Organism organism;
    private IslandMap map;

    public GameWorker(Organism organism, IslandMap map) {
        this.organism = organism;
        this.map = map;
    }

    @Override
    public void run() {
        Set<Organism> set = new HashSet<>(allOrganisms.get(organism.getClass()));
        for (Organism organism : set) {
            if (organism instanceof Animal) {
                double satiety = ((Animal) organism).getSatiety();
                double fullSatiety = ((Animal) organism).getRequiredWeightWorSatiety();
                ((Animal) organism).setSatiety((satiety - (fullSatiety * 0.1)));
                if (satiety < 1) organism.die();
                ((Animal) organism).move();
                ((Animal) organism).eat();
            }
            organism.reproduce();
        }
    }
}
