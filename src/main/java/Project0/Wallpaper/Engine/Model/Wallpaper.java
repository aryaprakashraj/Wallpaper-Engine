package Project0.Wallpaper.Engine.Model;

public class Wallpaper {
    private int id;
    private String imageUrl;
    private String category;

    public Wallpaper() {}

    public Wallpaper(int id, String imageUrl, String category) {
        this.id = id;
        this.imageUrl = imageUrl;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getCategory() {
        return category;
    }
}
