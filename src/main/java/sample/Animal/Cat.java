package sample.Animal;

public class Cat extends Animal {

    private String badHabits;

    public void setBadHabits(String badHabits) {
        this.badHabits = badHabits;
    }

    public String getBadHabbits(){
        return badHabits;
    }

    public Cat(String name, Gender gender, String badHabits) {
        super(name, gender);
        this.badHabits = badHabits;
        super.price = calculatePrice();
    }

    public String toString() {
        return super.toString() + String.format(", bad habits: %s. Price: %s",
                                            this.badHabits.toLowerCase(),
                                            this.price);
    }

    private double calculatePrice() {
        int minusAmount = 20 * this.badHabits.length();
        int result = 350 - minusAmount;
        if (result >= 35) {
            return result;
        }else {
            return 35;
        }
    }


}
