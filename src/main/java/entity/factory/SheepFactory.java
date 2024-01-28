package entity.factory;

import entity.Entity;
import entity.Sheep;

public class SheepFactory implements EntityFactory{
    @Override
    public Entity createEntity() {
        return new Sheep();
    }
}
