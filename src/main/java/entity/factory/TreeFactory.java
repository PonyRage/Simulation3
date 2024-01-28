package entity.factory;

import entity.Entity;
import entity.Tree;

public class TreeFactory implements EntityFactory{
    @Override
    public Entity createEntity() {
        return new Tree();
    }
}
