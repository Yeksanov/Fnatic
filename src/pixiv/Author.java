package pixiv;

public class Author {
    private int id;
    private String name;
    private String instagram;

    public Author() {

    }

    public Author(int id, String name, String instagram) {
        this.id = id;
        this.name = name;
        this.instagram = instagram;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }
}
