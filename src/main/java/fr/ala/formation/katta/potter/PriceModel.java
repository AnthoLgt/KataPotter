package fr.ala.formation.katta.potter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class PriceModel {

    private static final double DEFAULT_PRICE = 8.0;

    public static double getCostOfABasket(Basket basket){
        return calculateDiscount(basket);
    }

    private static double calculateDefaultPrice(Basket basket){
        return DEFAULT_PRICE * basket.getNumberOfBooks();
    }

    private static double calculateDiscount(Basket basket){
        double costTotal = 0.0;
        Basket workingBasket = basket;

        while(workingBasket.getNumberOfBooks() != 0){
            double initialCost = workingBasket.getNumberOfBooks() * DEFAULT_PRICE;
            switch (workingBasket.getNumberOfDifferentTypeBook()) {

                case 2:{
                    double discount = initialCost * 5 / 100;
                    costTotal =+ initialCost - discount;
                    workingBasket.withdrawABookOfAllType();
                    break;
                }
                case 3: {
                    double discount = initialCost * 10 / 100;
                    costTotal =+ initialCost - discount;
                    workingBasket.withdrawABookOfAllType();
                    break;
                }
                case 4: {
                    double discount = initialCost * 20 / 100;
                    costTotal =+ initialCost - discount;
                    workingBasket.withdrawABookOfAllType();
                    break;
                }
                case 5: {
                    double discount = initialCost * 25 / 100;
                    costTotal =+ initialCost - discount;
                    workingBasket.withdrawABookOfAllType();
                    break;
                }
                default:
                    costTotal =+ DEFAULT_PRICE;
                    workingBasket.withdrawABookOfAllType();
            }
        }
        return costTotal;
    }

}
