package kz.traningEpam16.coffeevan.coffee;

import kz.traningEpam16.coffeevan.coffee.type.TypeOfCoffee;
import kz.traningEpam16.coffeevan.coffee.wrap.WrapOfCoffee;

/**
 * Абстрактный класс кофе,
 * который должны наследовать сорта кофе
 */
public abstract class AbstractCoffee implements ICoffee{
    private final double stepOfGrams = 100;
    private final int volumeOfCoffee;
    private final double costPerGram;
    private final WrapOfCoffee wrapOfCoffee;
    private final TypeOfCoffee typeOfCoffee;

    protected AbstractCoffee(int volumeOfCoffee, double costOfCoffee,
                             WrapOfCoffee wrapOfCoffee,
                             TypeOfCoffee typeOfCoffee) {
        this.volumeOfCoffee = volumeOfCoffee;
        this.costPerGram = costOfCoffee / stepOfGrams;
        this.wrapOfCoffee = wrapOfCoffee;
        this.typeOfCoffee = typeOfCoffee;
    }

    public int getVolume() {
        return this.volumeOfCoffee +
                this.wrapOfCoffee.getVolumeOfWrap();
    }

    public int getVolumeWOWrap() {
        return this.volumeOfCoffee;
    }

    public double getCost() {
        return this.costPerGram * this.volumeOfCoffee;
    }

    public WrapOfCoffee getWrapOfCoffee() {
        return this.wrapOfCoffee;
    }

    public TypeOfCoffee getTypeOfCoffee() {
        return this.typeOfCoffee;
    }

}
