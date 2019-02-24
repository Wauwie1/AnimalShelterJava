package sample;

public enum Species {
    Dog("Dog"),
    Cat("Cat");

    private final String text;

    Species(final String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
