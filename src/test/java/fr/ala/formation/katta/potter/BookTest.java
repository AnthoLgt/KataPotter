package fr.ala.formation.katta.potter;

import org.junit.Test;
import static org.junit.Assert.*;

public class BookTest {
    @Test
    public void createBookAndShouldReturnTitle(){
        Book book = new Book(Title.TITLE1);

        Title title = book.getTitle();

        assertEquals(title, Title.TITLE1);
    }
}