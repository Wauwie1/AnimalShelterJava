package sample.Animal;

import java.util.Date;
import java.util.Locale;

public class AnimalFactory {

    // Ik ben me ervan bewust dat de parameter badHabits niet gebruikt wordt door alle
    // Animal klassen. Een parameter doorgeven die genegeerd wordt door sommige klassen
    // is dus niet bepaald goed.

    public Animal MakeAnimal(String species, String name, Gender gender, String badHabits){

        if(species.equals("Dog")){
            return new Dog(name, gender, new Date());
        }else if(species.equals("Cat")){
            return new Cat(name, gender, badHabits);
        }

        return null;
    }
}
