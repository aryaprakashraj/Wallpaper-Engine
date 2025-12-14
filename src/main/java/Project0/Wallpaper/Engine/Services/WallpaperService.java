package Project0.Wallpaper.Engine.Services;

import Project0.Wallpaper.Engine.Model.Wallpaper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.io.InputStream;
import java.util.*;

@Service
public class WallpaperService {

    private Map<String, List<Wallpaper>> wallpapers = new HashMap<>();
    private final Random random = new Random();

    @PostConstruct
    public void loadWallpapers() {
        try {
            ObjectMapper mapper = new ObjectMapper();
            InputStream inputStream = getClass().getResourceAsStream("/wallpapers.json");

            wallpapers = mapper.readValue(inputStream, new TypeReference<Map<String, List<Wallpaper>>>() {});
            System.out.println("Wallpapers loaded → " + wallpapers.size() + " categories");

        } catch (Exception e) {
            throw new RuntimeException("Failed to load wallpapers.json", e);
        }
    }

    public List<Wallpaper> getWallpapersByCategory(String category) {
        return wallpapers.getOrDefault(category.toLowerCase(), Collections.emptyList());
    }

    public Wallpaper getRandomWallpaper(String category) {
        List<Wallpaper> list = getWallpapersByCategory(category);
        if (list.isEmpty()) return null;
        return list.get(random.nextInt(list.size()));
    }

    public Set<String> getCategories() {
        return wallpapers.keySet();
    }
}