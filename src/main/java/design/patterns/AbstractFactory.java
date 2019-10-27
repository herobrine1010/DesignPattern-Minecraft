package design.patterns;

public abstract class AbstractFactory {
    public abstract <T extends Animal> Animal createAnimal(Class<T> type, CreateStrategy strategy);

    public abstract <T extends Plant> Plant createPlant(Class<T> type, CreateStrategy strategy);

    public abstract <T extends Building> Building createBuilding(Class<T> type, CreateStrategy strategy);

    private static class FactoryCreator {
        public static AbstractFactory getFactory(Class type) {
            //TODO("Add impl")
            return null;
        }
    }
}
