package com.ua.glebskotnickiy.Controller;

import com.ua.glebskotnickiy.Model.AbstractOrganisms.Organism;
import com.ua.glebskotnickiy.Model.Orhanisms.Herbivores.*;
import com.ua.glebskotnickiy.Model.Orhanisms.Plants.Grass;
import com.ua.glebskotnickiy.Model.Orhanisms.Predators.*;

import java.util.*;

public class CliAplication {
    private Map<String, Organism> newOrganisms = new HashMap<>();

    private List<Organism> typesOfOrganisms = new ArrayList<>();

    {
        {
            newOrganisms.put("wolf", new Wolf());
            newOrganisms.put("boa", new Boa());
            newOrganisms.put("fox", new Fox());
            newOrganisms.put("bear", new Bear());
            newOrganisms.put("horse", new Horse());
            newOrganisms.put("deer", new Deer());
            newOrganisms.put("rabbit", new Rabbit());
            newOrganisms.put("mouse", new Mouse());
            newOrganisms.put("goat", new Goat());
            newOrganisms.put("sheep", new Sheep());
            newOrganisms.put("boar", new Boar());
            newOrganisms.put("buffalo", new Buffalo());
            newOrganisms.put("duck", new Duck());
            newOrganisms.put("caterpillar", new Caterpillar());
            newOrganisms.put("grass", new Grass());
            newOrganisms.put("tiger", new Tiger());
        }
    }

    public List<Organism> getTypesOfOrganisms(String[] strings) {
        for (String s : strings) {
            if (newOrganisms.containsKey(s.toLowerCase())) {
                typesOfOrganisms.add(newOrganisms.get(s.toLowerCase()));
            } else throw new InputMismatchException();
        }
        return typesOfOrganisms;
    }
}
