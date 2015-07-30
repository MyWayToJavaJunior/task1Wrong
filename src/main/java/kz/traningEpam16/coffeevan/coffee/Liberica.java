package kz.traningEpam16.coffeevan.coffee;

import kz.traningEpam16.coffeevan.coffee.type.TypeOfCoffee;
import kz.traningEpam16.coffeevan.coffee.wrap.WrapOfCoffee;

/**
 * Сорт кофе - Либерика
 */
public class Liberica extends AbstractCoffee {
    private static final double LIBERICA_COST_PER_HUNDRED_GRAM = 40;

    public Liberica(WrapOfCoffee wrapOfCoffee, TypeOfCoffee typeOfCoffee) {
        super(typeOfCoffee.getStandardVolume(),
                LIBERICA_COST_PER_HUNDRED_GRAM, wrapOfCoffee, typeOfCoffee);
    }
}
