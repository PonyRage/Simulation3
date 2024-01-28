package entity.factory;

import entity.Entity;
import entity.Rock;

public class RockFactory implements EntityFactory{
    @Override
    public Entity createEntity() {
        return new Rock();
    }
}
