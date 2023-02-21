package com.ua.glebskotnickiy.Model.AbstractOrganisms;

public abstract class Plant extends Organism {

    @Override
    public void reproduce() {
        synchronized (this.getCell()) {
            if (this.getCell().getWeather() && this.getCell().getOrganisms().get(this.getClass()).size() < this.getMaxAmount()) {
                if (this.getCell().getOrganisms().get(this.getClass()).size() > 1) {
                    this.getCell().addOrganism(this.createOrganism());
                }
            }
        }
    }
}
