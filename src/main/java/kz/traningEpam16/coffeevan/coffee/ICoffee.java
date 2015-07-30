package kz.traningEpam16.coffeevan.coffee;

import kz.traningEpam16.coffeevan.coffee.type.TypeOfCoffee;
import kz.traningEpam16.coffeevan.coffee.wrap.WrapOfCoffee;

/**
 * Типизирующий интерфейс для кофе
 */
public interface ICoffee {
    int getVolume();
    int getVolumeWOWrap();
    double getCost();
    WrapOfCoffee getWrapOfCoffee();
    TypeOfCoffee getTypeOfCoffee();
}
