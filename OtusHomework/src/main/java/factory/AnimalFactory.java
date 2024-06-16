package factory;
import animals.Animal;
import animals.birds.Duck;
import animals.pats.Cat;
import animals.pats.Dog;
import data.AnimalInputData;

public class AnimalFactory {

    public Animal create(AnimalInputData animalTypeData){
        return switch (animalTypeData) {
            case CAT -> new Cat();
            case DOG -> new Dog();
            case DUCK -> new Duck();
        };
    }
}
