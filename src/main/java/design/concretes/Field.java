package design.concretes;

import design.patterns.Building;
import design.patterns.CreateStrategy;
import design.patterns.Plant;

import java.util.HashMap;
import java.util.HashSet;

public class Field extends Building<Field.FieldInteractStrategy> {
    private HashSet<Plant> plants = new HashSet<>();

    @Override
    public Building create(CreateStrategy strategy) {
        switch(strategy) {
            case CRAFT:
                //TODO("impl interact code")

                // fallthrough
            case CREATE:
                return new Field();
        }
        return null;
    }

    @Override
    public Object interact(FieldInteractStrategy interactStrategy, Object... args) {
        return null;
    }

    enum FieldInteractStrategy {
        GET_PLANTS,
        // args: none
        // return type: HashSet<Plant>

    }
}
