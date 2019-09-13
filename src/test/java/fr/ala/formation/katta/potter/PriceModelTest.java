package fr.ala.formation.katta.potter;

import org.junit.Test;
import static org.junit.Assert.*;

public class PriceModelTest {

    double MARGIN_PRECISION = 0.001; // Tolérance plus petite que les centimes

    @Test
    public void emptyBasketShouldCostZero(){
        Basket emptyBasket = new Basket();

        double costOfEmptyBasket = PriceModel.getCostOfABasket(emptyBasket);

        assertEquals(costOfEmptyBasket, 0, MARGIN_PRECISION);
    }

    @Test
    public void basketWithOneBookShouldCostEight(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(costOfBasket, 8, MARGIN_PRECISION);
    }

    @Test
    public void basketWithTwoSameBookShouldCostSixteen(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));
        basket.addBook(new Book(Title.TITLE1));

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(costOfBasket, 16, MARGIN_PRECISION);
    }


}