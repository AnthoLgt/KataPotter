package fr.ala.formation.katta.potter;

import java.util.ArrayList;

public class Basket {

    private ArrayList<Book> listOfBooks;

    public Basket(){
        this.listOfBooks = new ArrayList<>();
    }

    public int getSize(){
        return this.listOfBooks.size();
    }

    public void addBook(Book book) {
        this.listOfBooks.add(book);
    }

    public Book getBookByAndIndex(int index){
        return this.listOfBooks.get(index);
    }
}
