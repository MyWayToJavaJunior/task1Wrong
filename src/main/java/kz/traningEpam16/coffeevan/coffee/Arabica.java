package kz.traningEpam16.coffeevan.coffee;

import kz.traningEpam16.coffeevan.coffee.type.TypeOfCoffee;
import kz.traningEpam16.coffeevan.coffee.wrap.WrapOfCoffee;

/**
 * Сорт кофе - Арабика
 */
public class Arabica extends AbstractCoffee {
    private static final double ARABICA_COST_PER_HUNDRED_GRAM = 20;

    public Arabica(WrapOfCoffee wrapOfCoffee, TypeOfCoffee typeOfCoffee) {
        super(typeOfCoffee.getStandardVolume(),
                ARABICA_COST_PER_HUNDRED_GRAM, wrapOfCoffee, typeOfCoffee);
    }
}
