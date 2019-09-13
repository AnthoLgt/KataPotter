package fr.ala.formation.katta.potter;

import java.util.HashMap;
import java.util.Map;


public class PriceModel {

    private static final double DEFAULT_PRICE = 8.0;

    public static double getCostOfABasket(Basket basket){

        return calculateDiscount(basket);
    }

    private static double calculateDefaultPrice(Basket basket){
        return DEFAULT_PRICE * basket.getSize();
    }

    private static double calculateDiscount(Basket basket){
        double cost = 0.0;
        if(basket.getSize() > 0){
            Map<Title, Integer> numberOfEachTitle = new HashMap<>();
            for(int indexBook = 0; indexBook < basket.getSize(); indexBook++){
                Title titleOfCurrentBook = basket.getBookByAndIndex(indexBook).getTitle();
                if(numberOfEachTitle.containsKey(titleOfCurrentBook)){
                    numberOfEachTitle.put(titleOfCurrentBook, numberOfEachTitle.get(titleOfCurrentBook) + 1);
                }else{
                    numberOfEachTitle.put(titleOfCurrentBook, 1);
                }
                cost+= DEFAULT_PRICE;
            }

            switch (numberOfEachTitle.keySet().size()) {
                case 2:{
                    double discount = cost * 5 / 100;
                    cost = cost - discount;
                    break;
                }
                case 3: {
                    double discount = cost * 10 / 100;
                    cost = cost - discount;
                    break;
                }
                case 4: {
                    double discount = cost * 20 / 100;
                    cost = cost - discount;
                    break;
                }
                case 5: {
                    double discount = cost * 25 / 100;
                    cost = cost - discount;
                    break;
                }
            }

        }

        return cost;
    }

}
