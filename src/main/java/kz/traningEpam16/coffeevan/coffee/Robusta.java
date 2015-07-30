package kz.traningEpam16.coffeevan.coffee;

import kz.traningEpam16.coffeevan.coffee.type.TypeOfCoffee;
import kz.traningEpam16.coffeevan.coffee.wrap.WrapOfCoffee;

/**
 * Сорт кофе - Робуста
 */
public class Robusta extends AbstractCoffee {
    private static final double ROBUSTA_COST_PER_HUNDRED_GRAM = 25;

    public Robusta(WrapOfCoffee wrapOfCoffee, TypeOfCoffee typeOfCoffee) {
        super(typeOfCoffee.getStandardVolume(),
                ROBUSTA_COST_PER_HUNDRED_GRAM, wrapOfCoffee, typeOfCoffee);
    }
}
