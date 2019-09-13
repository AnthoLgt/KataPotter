package fr.ala.formation.katta.potter;

import org.junit.Test;
import static org.junit.Assert.*;

public class BasketTest {

    @Test
    public void createBasketShouldBeEmpty(){
        Basket emptyBasket = new Basket();

        int sizeOfBasket = emptyBasket.getSize();

        assertEquals(0, sizeOfBasket);
    }

    @Test
    public void createBasketWithOneBookSizeShouldBeOne(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));

        int sizeOfBasket = basket.getSize();

        assertEquals(1, sizeOfBasket);
    }

    @Test
    public void createBasketWithTwoSameBooksSizeShouldBeTwo(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));
        basket.addBook(new Book(Title.TITLE1));

        int sizeOfBasket = basket.getSize();

        assertEquals(2, sizeOfBasket);
    }

    @Test
    public void createBasketWithTwoDifferentBooksSizeShouldBeTwo(){
        Basket basket = new Basket();
        basket.addBook(new Book(Title.TITLE1));
        basket.addBook(new Book(Title.TITLE2));

        int sizeOfBasket = basket.getSize();

        assertEquals(2, sizeOfBasket);
    }
}