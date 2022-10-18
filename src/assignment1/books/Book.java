package assignment1.books;

public class Book {
    public String title;
    public Integer id;
    public Integer amount;

    public Book(String name, Integer id, Integer amount) {
        this.title = name;
        this.id = id;
        this.amount = amount;
    }

    public String getName() {
        return title;
    }

    public void setName(String name) {
        this.title = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
