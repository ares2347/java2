package assignment1.books;

public class Book {
    public String title;
    public Integer id;

    public Book(String name, Integer id) {
        this.title = name;
        this.id = id;
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
