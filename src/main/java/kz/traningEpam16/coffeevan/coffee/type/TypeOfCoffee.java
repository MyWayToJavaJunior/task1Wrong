package kz.traningEpam16.coffeevan.coffee.type;

/**
 * Форма кофе
 */
public enum TypeOfCoffee {
    GRAIN ("Grain", 100),
    GROUND ("Ground", 80),
    INSTANT ("Instant", 15);

    private final String nameOfType;
    private final int standardVolume;

    TypeOfCoffee(String nameOfType, int standardVolume) {
        this.nameOfType = nameOfType;
        this.standardVolume = standardVolume;
    }

    public String getNameOfType() {
        return this.nameOfType;
    }

    public int getStandardVolume() {
        return this.standardVolume;
    }
}
