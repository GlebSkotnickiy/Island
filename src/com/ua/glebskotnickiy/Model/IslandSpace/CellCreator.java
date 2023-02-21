package com.ua.glebskotnickiy.Model.IslandSpace;

import com.ua.glebskotnickiy.Model.AbstractOrganisms.Organism;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class CellCreator {

    public Cell createCell(List<Organism> typesOfOrganisms) {
        Cell cell = new Cell();
        for (Organism typesOfOrganism : typesOfOrganisms) {
            for (int i = 0; i < ThreadLocalRandom.current().nextInt(typesOfOrganism.getMaxAmount()); i++) {
                cell.addOrganism(typesOfOrganism.createOrganism());
            }
        }
        return cell;
    }
}