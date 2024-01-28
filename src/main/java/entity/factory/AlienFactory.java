package entity.factory;

import entity.Alien;
import entity.Entity;

public class AlienFactory implements EntityFactory{
    @Override
    public Entity createEntity() {
        return new Alien();
    }
}
