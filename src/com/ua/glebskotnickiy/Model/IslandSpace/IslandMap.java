package com.ua.glebskotnickiy.Model.IslandSpace;

import com.ua.glebskotnickiy.Model.AbstractOrganisms.Animal;
import com.ua.glebskotnickiy.Model.AbstractOrganisms.Organism;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;

public class IslandMap {
    private final CellCreator cellCreator = new CellCreator();
    private final List<Organism> typesOfOrganisms;
    public volatile Cell[][] cells;

    public IslandMap(int x, int y, List<Organism> typesOfOrganisms) {
        this.cells = new Cell[x][y];
        this.typesOfOrganisms = typesOfOrganisms;
        createCells();
        setCellsBinds();
    }

    public void createCells() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                cells[i][j] = cellCreator.createCell(typesOfOrganisms);
            }
        }
    }

    public void setCellsBinds() {
        for (int i = 0; i < cells.length; i++) {
            for (int j = 0; j < cells[i].length; j++) {
                Cell cell = cells[i][j];
                Cell rightCell = null;
                Cell bottomCell = null;

                if (j < cells[i].length - 1) {
                    rightCell = cells[i][j + 1];
                }

                if (i < cells.length - 1) {
                    bottomCell = cells[i + 1][j];
                }

                if (rightCell != null) {
                    cell.setNextCells(rightCell);
                    rightCell.setNextCells(cell);
                }

                if (bottomCell != null) {
                    cell.setNextCells(bottomCell);
                    bottomCell.setNextCells(cell);
                }
            }
        }
    }

    public void startLife() throws InterruptedException {
        for (int c = 0; c < 30; c++) {
            for (Cell[] cell : cells) {
                for (Cell value : cell) {
                    System.out.print(value);
                }
                System.out.println();
            }
            Stream.of(cells).flatMap(Arrays::stream).forEach((x) -> x.getOrganisms().keySet().forEach((y) -> {
                Set<Organism> set = new HashSet<>(x.getOrganisms().get(y));
                for (Organism organism : set) {
                    if (organism instanceof Animal) {
                        double requiredreSatiety = ((Animal) organism).getRequiredWeightWorSatiety();
                        ((Animal) organism).setSatiety((((Animal) organism).getSatiety() - (requiredreSatiety * 0.1)));
                        if (((Animal) organism).getSatiety() < 1) organism.die();
                        ((Animal) organism).move();
                        ((Animal) organism).eat();
                    }
                    organism.reproduce();
                }
            }));
            Thread.sleep(1000);
            System.out.println("-----------------------------------------------------");
        }
    }

    public Cell[][] getCells() {
        return cells;
    }
}
