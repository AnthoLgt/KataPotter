package fr.ala.formation.katta.potter;

import org.junit.Test;
import static org.junit.Assert.*;

public class BasketTest {

    @Test
    public void createBasketShouldBeEmpty(){
        Basket emptyBasket = new Basket();

        int sizeOfBasket = emptyBasket.getNumberOfBooks();

        assertEquals(0, sizeOfBasket);
    }

    @Test
    public void createBasketWithOneBookSizeShouldBeOne(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);

        int sizeOfBasket = basket.getNumberOfBooks();

        assertEquals(1, sizeOfBasket);
    }

    @Test
    public void createBasketWithTwoSameBooksSizeShouldBeTwo(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK1);

        int sizeOfBasket = basket.getNumberOfBooks();

        assertEquals(2, sizeOfBasket);
    }

    @Test
    public void createBasketWithTwoDifferentBooksSizeShouldBeTwo(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK2);

        int sizeOfBasket = basket.getNumberOfBooks();

        assertEquals(2, sizeOfBasket);
    }

    @Test
    public void createBasketWithOneBookAndWithdrawTheBookNumberOfBooksShouldBeZero(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);

        basket.withdrawABook(Book.BOOK1);
        int sizeOfBasket = basket.getNumberOfBooks();

        assertEquals(0, sizeOfBasket);
    }

    @Test
    public void createBasketWithTwoBooksAndWithdrawOneBookNumberOfBooksShouldBeOne(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK1);

        basket.withdrawABook(Book.BOOK1);
        int sizeOfBasket = basket.getNumberOfBooks();

        assertEquals(1, sizeOfBasket);
    }

    @Test
    public void createBasketWithTwoDifferentBooksAndWithdrawOneBookNumberOfBooksForTypeOneShouldBeOne(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK1);

        basket.withdrawABook(Book.BOOK1);
        int numberOfBooksForAType = basket.getNumberOfBooksForAType(Book.BOOK1);

        assertEquals(1, numberOfBooksForAType);
    }

    @Test
    public void createBasketWithTwoDifferentBooksAndWithdrawOneBookNumberOfTypeBooksShouldBeOne(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK2);

        basket.withdrawABook(Book.BOOK1);
        int numberOfDifferentBook = basket.getNumberOfDifferentTypeBook();

        assertEquals(1, numberOfDifferentBook);
    }

    @Test
    public void createBasketWithFiveDifferentBooksAndWithdrawOneOfEachTypeNumberOfTypeBooksShouldBe0(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK2);
        basket.addBook(Book.BOOK3);
        basket.addBook(Book.BOOK4);
        basket.addBook(Book.BOOK5);

        basket.withdrawABookOfAllType();
        int numberOfDifferentBook = basket.getNumberOfDifferentTypeBook();

        assertEquals(0, numberOfDifferentBook);
    }

    @Test
    public void createBasketWithTwoDifferentBooksAndTwoOfSameTypeWithdrawOneOfEachTypeNumberOfTypeBooksShouldBeOne(){
        Basket basket = new Basket();
        basket.addBook(Book.BOOK1);
        basket.addBook(Book.BOOK2);
        basket.addBook(Book.BOOK3);
        basket.addBook(Book.BOOK3);

        basket.withdrawABookOfAllType();
        int numberOfDifferentBook = basket.getNumberOfDifferentTypeBook();

        assertEquals(1, numberOfDifferentBook);
    }
}