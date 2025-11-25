package Project0.Wallpaper.Engine.Controllers;

import Project0.Wallpaper.Engine.Model.Wallpaper;
import Project0.Wallpaper.Engine.Services.WallpaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/wallpapers")
public class WallpaperController {

    @Autowired
    private WallpaperService wallpaperService ;

    @GetMapping("/{category}")
    public List<Wallpaper> getByCategory(@PathVariable String category){
        return wallpaperService.getByCategory(category);
    }

    @GetMapping("/random/{category}")
    public Wallpaper getRandom(@PathVariable String category){
        return wallpaperService.getRandomByCategory(category);
    }
}