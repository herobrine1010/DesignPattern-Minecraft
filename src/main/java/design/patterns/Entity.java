package design.patterns;

public abstract class Entity {
    private static int lastId = 0;
    private static synchronized int generateId() {
        return ++lastId;
    }

    protected int entityId = generateId();
}
