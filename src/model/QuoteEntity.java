package model;

public class QuoteEntity {
    private final String text;
    private final String author;
    private final String category;

    public QuoteEntity(String text, String author, String category){
        this.category = category;
        this.author = author;
        this.text = text;
    }

    public String getText(){
        return text;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }
}
