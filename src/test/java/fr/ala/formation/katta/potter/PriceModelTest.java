package fr.ala.formation.katta.potter;

import org.junit.Test;
import static org.junit.Assert.*;

public class PriceModelTest {

    double MARGIN_PRECISION = 0.001; // Tolérance plus petite que les centimes

    @Test
    public void emptyBasketShouldCostZero(){
        Basket emptyBasket = new Basket();

        double costOfEmptyBasket = PriceModel.getCostOfABasket(emptyBasket);

        assertEquals(0, costOfEmptyBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithOneBookShouldCostEight(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(8, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithTwoSameBookShouldCostSixteen(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));
        basket.addBook(new Book(Title.TITLE1));

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(16, costOfBasket, MARGIN_PRECISION);

    }

    @Test
    public void basketWithTwoDifferentBookShouldHaveFivePourcentDiscount(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));
        basket.addBook(new Book(Title.TITLE2));
        double normalCost = 8 * 2;
        double discount = normalCost * 5 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }


}