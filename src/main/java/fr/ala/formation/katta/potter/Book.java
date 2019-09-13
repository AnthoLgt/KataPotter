package fr.ala.formation.katta.potter;

public class Book {

    private final Title title;

    public Book(Title title){
        this.title = title;
    }

    public Title getTitle(){
        return this.title;
    }
}
