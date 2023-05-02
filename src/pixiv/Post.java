package pixiv;

public class Post {

    private int id;
    private Author author;
    private String category;
    private String description;

    public Post() {
    }

    public Post(int id, Author author, String category, String description) {
        this.id = id;
        this.author = author;
        this.category = category;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}