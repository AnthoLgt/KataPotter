package fr.ala.formation.katta.potter;

public class PriceModel {

    public static double getCostOfABasket(Basket basket){
        double cost = 0.0;
        if(basket.getSize() > 0){
            for(int indexBook = 0; indexBook < basket.getSize(); indexBook++){
                cost+= 8.0;
            }
        }
        return cost;
    }

}
