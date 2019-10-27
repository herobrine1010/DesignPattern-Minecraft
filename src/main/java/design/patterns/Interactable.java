package design.patterns;

public interface Interactable<T> {
    Object interact(T interactStrategy, Object... args);

    class InteractArgException extends RuntimeException {}
}
