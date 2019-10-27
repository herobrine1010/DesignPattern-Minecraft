package design.concretes;

import design.patterns.Animal;
import design.patterns.Building;
import design.patterns.CreateStrategy;
import design.patterns.Interactable;

import java.util.HashSet;

public class Farm extends Building<Farm.FarmInteractStrategy> {
    private HashSet<Animal> animals = new HashSet<>();

    private static Integer capacity = 32;
    private Integer takenSpace = 0;

    private Class<? extends Animal> state = null;

    @Override
    public Building create(CreateStrategy strategy) {
        switch (strategy) {
            case CRAFT:
                //TODO("impl interact code")

                // fallthrough
            case CREATE:
                return new Farm();
        }
        return null;
    }

    @Override
    public Object interact(FarmInteractStrategy interactStrategy, Object... args)
            throws NotHereException, NoEnoughSpaceException, DiffAnimalTypeException,
            NotFreeAnimalException, Interactable.InteractArgException {
        switch (interactStrategy) {
            case GET_ANIMALS:
                return animals;
            case REMOVE_ANIMAL: {
                if (args.length != 1 || !(args[0] instanceof Animal)) {
                    throw new Interactable.InteractArgException();
                }
                Animal animal = (Animal) args[0];
                if (!animals.remove(animal)) {
                    throw new NotHereException();
                }
                takenSpace -= animal.getSpaceRequire();
                if(animals.isEmpty()) state = null;
                return animal;
            }
            case ADD_ANIMAL: {
                if (args.length != 1 || !(args[0] instanceof Animal)) {
                    throw new Interactable.InteractArgException();
                }
                Animal animal = (Animal) args[0];
                if(state == null) {
                    state = animal.getClass();
                }
                else if(!state.isInstance(animal)) {
                    throw new DiffAnimalTypeException();
                }
                if (animal.getSpaceRequire() > (capacity - takenSpace)) {
                    throw new NoEnoughSpaceException();
                }
                if (animal.getBelongTo() != null) {
                    throw new NotFreeAnimalException();
                }
                animal.setBelongTo(this);
                animals.add(animal);
                return animal;
            }
        }
        return null;
    }

    public enum FarmInteractStrategy {
        GET_ANIMALS,
        // args: none
        // return type: HashSet<Animal>
        REMOVE_ANIMAL,
        // args: Animal: animal instance that will be removed
        // return type: Animal: exact the removed instance
        // throw: Interactable.InteractArgException: type check failed
        //        NotHereException: given animal not belongs to this
        ADD_ANIMAL,
        // args: Animal: animal instance that will be added
        // return type: Animal: exact the added instance
        // throw: Interactable.InteractArgException: type check failed
        //        NoEnoughSpaceException: space not enough
        //        NotFreeAnimalException: animal already has a farm
    }

    public static class NotHereException extends IllegalArgumentException {
    }

    public static class NoEnoughSpaceException extends RuntimeException {
    }

    public static class NotFreeAnimalException extends RuntimeException {
    }

    public static class DiffAnimalTypeException extends RuntimeException {
    }
}
