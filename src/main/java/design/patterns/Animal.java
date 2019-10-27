package design.patterns;

import design.concretes.Clock;
import design.concretes.Farm;
import lombok.Getter;
import lombok.Setter;

public abstract class Animal<S> extends Entity implements Interactable<S>, Creatable<Animal> {
    @Setter @Getter
    protected Farm belongTo = null;

    protected Integer birthDate = Clock.getInstance().getState();

    protected Integer getAge() {
        return Clock.getInstance().getState() - birthDate;
    }

    @Getter
    protected Integer grownAge = null;
    // must be assigned in subclass's static block

    @Getter
    protected Integer spaceRequire = null;
    // must be assigned in subclass's static block
}
