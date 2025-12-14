package Project0.Wallpaper.Engine.Controllers;

import Project0.Wallpaper.Engine.Model.Wallpaper;
import Project0.Wallpaper.Engine.Services.WallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/api/wallpapers")
public class WallpaperController {

    @Autowired
    private WallpaperService wallpaperService;

    @GetMapping("/categories")
    public Set<String> getCategories() {
        return wallpaperService.getCategories();
    }


    @GetMapping("/random/{category}")
    public Wallpaper getRandom(@PathVariable String category) {
        return wallpaperService.getRandomWallpaper(category);
    }
}
