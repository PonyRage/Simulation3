package entity.factory;

import entity.Entity;
import entity.Predator;

public class PredatorFactory implements EntityFactory{
    @Override
    public Entity createEntity() {
        return new Predator();
    }
}
