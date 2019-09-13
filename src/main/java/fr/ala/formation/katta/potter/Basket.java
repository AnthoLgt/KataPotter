package fr.ala.formation.katta.potter;

import java.util.*;

public class Basket{

    private Map<Book, Integer> basketOfBooks;

    public Basket(){
        this.basketOfBooks = new HashMap<>();
    }

    public Basket(Basket another) {
        this.basketOfBooks = another.basketOfBooks; // you can access
    }

    public int getNumberOfBooks(){
        int total = 0;
        for(Integer numberOfBooks : this.basketOfBooks.values()){
            total+= numberOfBooks;
        }
        return total;
    }

    public int getNumberOfDifferentTypeBook(){
        return this.basketOfBooks.size();
    }

    public void addBook(Book book) {
        if(this.basketOfBooks.containsKey(book)){
            this.basketOfBooks.put(book, this.basketOfBooks.get(book) + 1);
        }else{
            this.basketOfBooks.put(book, 1);
        }
    }

    public int getNumberOfBooksForAType(Book book){
        return this.basketOfBooks.get(book);
    }

    public void withdrawABook(Book book){
        if(this.basketOfBooks.containsKey(book)){
            if(this.basketOfBooks.get(book) == 1){
                this.basketOfBooks.remove(book);
            }else{
                this.basketOfBooks.put(book, this.basketOfBooks.get(book) - 1);
            }
        }
    }

    public void withdrawABookOfAllType(){
        Set<Book> listBook = new HashSet<>(this.basketOfBooks.keySet());
        for(Book book: listBook) {
            if (this.basketOfBooks.get(book) == 1) {
                this.basketOfBooks.remove(book);
            } else {
                this.basketOfBooks.put(book, this.basketOfBooks.get(book) - 1);
            }
        }
    }

}
