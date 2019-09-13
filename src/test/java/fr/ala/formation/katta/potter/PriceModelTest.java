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
    public void basketWithOneBookShouldCostOne(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(8, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithTwoIdentiqBooksShouldCostTwo(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));
        basket.addBook(new Book(Title.TITLE1));

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(8 * basket.getSize(), costOfBasket, MARGIN_PRECISION);
    }


    @Test
    public void basketWithTwoDifferentBooksShouldHaveFivePercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));
        basket.addBook(new Book(Title.TITLE2));
        double normalCost = 8 * basket.getSize();
        double discount = normalCost * 5 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithTwoNotDifferentBooksShouldNotHaveFivePercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));
        basket.addBook(new Book(Title.TITLE1));
        double normalCost = 8 * basket.getSize();
        double discount = normalCost * 5 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertNotEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithThreeDifferentBooksShouldHaveTenPercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));
        basket.addBook(new Book(Title.TITLE2));
        basket.addBook(new Book(Title.TITLE3));
        double normalCost = 8 * basket.getSize();
        double discount = normalCost * 10 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithThreeNotDifferentBooksShouldNotHaveTenPercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));
        basket.addBook(new Book(Title.TITLE2));
        basket.addBook(new Book(Title.TITLE2));
        double normalCost = 8 * basket.getSize();
        double discount = normalCost * 10 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertNotEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithFourDifferentBooksShouldHaveTwentyPercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));
        basket.addBook(new Book(Title.TITLE2));
        basket.addBook(new Book(Title.TITLE3));
        basket.addBook(new Book(Title.TITLE4));
        double normalCost = 8 * basket.getSize();
        double discount = normalCost * 20 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithNotFourDifferentBooksShouldNotHaveTwentyPercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));
        basket.addBook(new Book(Title.TITLE2));
        basket.addBook(new Book(Title.TITLE3));
        basket.addBook(new Book(Title.TITLE3));
        double normalCost = 8 * basket.getSize();
        double discount = normalCost * 20 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertNotEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithFiveDifferentBooksShouldHaveTwentyFivePercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));
        basket.addBook(new Book(Title.TITLE2));
        basket.addBook(new Book(Title.TITLE3));
        basket.addBook(new Book(Title.TITLE4));
        basket.addBook(new Book(Title.TITLE5));
        double normalCost = 8 * basket.getSize();
        double discount = normalCost * 25 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithFiveNotDifferentBooksShouldNotHaveTwentyFivePercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));
        basket.addBook(new Book(Title.TITLE2));
        basket.addBook(new Book(Title.TITLE3));
        basket.addBook(new Book(Title.TITLE5));
        basket.addBook(new Book(Title.TITLE5));
        double normalCost = 8 * basket.getSize();
        double discount = normalCost * 25 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertNotEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }



}