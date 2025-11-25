package Project0.Wallpaper.Engine.Services;

import Project0.Wallpaper.Engine.Model.Wallpaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors ;

@Service
public class WallpaperService {

    private final List<Wallpaper> wallpapers = List.of (
            new Wallpaper(1, "https://picsum.photos/id/237/2000/3000", "bike"),
            new Wallpaper(2, "https://picsum.photos/id/1003/2000/3000", "nature"),
            new Wallpaper(3, "https://picsum.photos/id/1025/2000/3000", "anime"),
            new Wallpaper(4, "https://picsum.photos/id/1062/2000/3000", "bike"),
            new Wallpaper(5, "https://picsum.photos/id/1039/2000/3000", "nature")
    );

    public List<Wallpaper> getByCategory(String category){
        return wallpapers.stream().filter(w -> w.getCategoryTag().equalsIgnoreCase(category)).collect(Collectors.toList());
    }

    public Wallpaper getRandomByCategory(String category){
        List<Wallpaper> filtered =  wallpapers.stream().filter(w -> w.getCategoryTag().equalsIgnoreCase(category)).collect(Collectors.toList());
        if (filtered.isEmpty()) return null ;
        Random r = new Random() ;
        return filtered.get(r.nextInt(filtered.size()));
    }
}