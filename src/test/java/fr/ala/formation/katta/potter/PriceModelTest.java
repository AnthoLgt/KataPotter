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
        basket.addBook(Book.BOOK1);

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(8, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithTwoIdentiqBooksShouldCostTwo(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK1);

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(8 * 2, costOfBasket, MARGIN_PRECISION);
    }


    @Test
    public void basketWithTwoDifferentBooksShouldHaveFivePercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK2);
        double normalCost = 8 * basket.getNumberOfBooks();
        double discount = normalCost * 5 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithTwoNotDifferentBooksShouldNotHaveFivePercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK1);
        double normalCost = 8 * basket.getNumberOfBooks();
        double discount = normalCost * 5 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertNotEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithThreeDifferentBooksShouldHaveTenPercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK2);
        basket.addBook(Book.BOOK3);
        double normalCost = 8 * basket.getNumberOfBooks();
        double discount = normalCost * 10 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithThreeNotDifferentBooksShouldNotHaveTenPercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK2);
        basket.addBook(Book.BOOK2);
        double normalCost = 8 * basket.getNumberOfBooks();
        double discount = normalCost * 10 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertNotEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithFourDifferentBooksShouldHaveTwentyPercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK2);
        basket.addBook(Book.BOOK3);
        basket.addBook(Book.BOOK4);
        double normalCost = 8 * basket.getNumberOfBooks();
        double discount = normalCost * 20 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithNotFourDifferentBooksShouldNotHaveTwentyPercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK2);
        basket.addBook(Book.BOOK3);
        basket.addBook(Book.BOOK3);
        double normalCost = 8 * basket.getNumberOfBooks();
        double discount = normalCost * 20 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertNotEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithFiveDifferentBooksShouldHaveTwentyFivePercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK2);
        basket.addBook(Book.BOOK3);
        basket.addBook(Book.BOOK4);
        basket.addBook(Book.BOOK5);
        double normalCost = 8 * basket.getNumberOfBooks();
        double discount = normalCost * 25 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithFiveNotDifferentBooksShouldNotHaveTwentyFivePercentDiscount(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK2);
        basket.addBook(Book.BOOK3);
        basket.addBook(Book.BOOK5);
        basket.addBook(Book.BOOK5);
        double normalCost = 8 * basket.getNumberOfBooks();
        double discount = normalCost * 25 / 100;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertNotEquals(expectedCost, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void basketWithFourBooksThreeDifferentAndOneIdentiqShouldHaveTenPercentDiscountOnThreeIdentiqBooksAndNoDiscountForTheFive(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK2);
        basket.addBook(Book.BOOK3);
        basket.addBook(Book.BOOK3);
        double normalCost = 8.0 * 4.0;
        double discount = 8.0 * 3.0 * 10.0 / 100.0;
        double expectedCost = normalCost - discount;

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(costOfBasket, costOfBasket, MARGIN_PRECISION);
    }

    @Test
    public void potterExampleTest(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK2);
        basket.addBook(Book.BOOK2);
        basket.addBook(Book.BOOK3);
        basket.addBook(Book.BOOK3);
        basket.addBook(Book.BOOK4);
        basket.addBook(Book.BOOK5);

        double costOfBasket = PriceModel.getCostOfABasket(basket);

        assertEquals(51.20, costOfBasket, MARGIN_PRECISION);
    }

}