package kz.traningEpam16.coffeevan.coffee.wrap;

/**
 * Упаковка кофе
 */
public enum WrapOfCoffee {
    GLASS ("Glass", 20),
    PLASTIC ("Plastic", 5);

    private final String nameOfWrap;
    private final int volumeOfWrap;

    WrapOfCoffee(String nameOfWrap, int volumeOfWrap) {
        this.nameOfWrap = nameOfWrap;
        this.volumeOfWrap = volumeOfWrap;
    }

    public String getNameOfWrap() {
        return this.nameOfWrap;
    }

    public int getVolumeOfWrap() {
        return this.volumeOfWrap;
    }
}
