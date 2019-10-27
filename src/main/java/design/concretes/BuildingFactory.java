package design.concretes;

import design.patterns.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class BuildingFactory extends AbstractFactory {

    @Override
    public <T extends Animal> Animal createAnimal(Class<T> type, CreateStrategy strategy) {
        return null;
    }

    @Override
    public <T extends Plant> Plant createPlant(Class<T> type, CreateStrategy strategy) {
        return null;
    }

    @Override
    public <T extends Building> Building createBuilding(Class<T> type, CreateStrategy strategy) {
        try {
            Method creator = type.getMethod("create");
            if(type == creator.getReturnType()) {
                return type.cast(creator.invoke(null));
            }
            return null;
        } catch (IllegalAccessException| InvocationTargetException |NoSuchMethodException e) {
            e.printStackTrace();
            return null;
        }
    }
}
