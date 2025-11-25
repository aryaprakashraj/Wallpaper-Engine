package Project0.Wallpaper.Engine.Model;

public class Wallpaper {
    private long id ;
    private String imageUrl ;
    private String categoryTag ;

    public Wallpaper(long id, String imageUrl, String categoryTag){
        this.id = id ;
        this.imageUrl = imageUrl ;
        this.categoryTag = categoryTag ;
    }

    public long getId() {
        return id;
    }
    public String getImageUrl(){
        return imageUrl ;
    }
    public String getCategoryTag() {
        return categoryTag;
    }
}