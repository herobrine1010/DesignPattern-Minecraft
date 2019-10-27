package design.patterns;

public interface Creatable<T> {
    T create(CreateStrategy strategy);
}
