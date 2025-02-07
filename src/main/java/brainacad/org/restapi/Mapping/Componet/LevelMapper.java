package brainacad.org.restapi.Mapping.Componet;

import brainacad.org.restapi.Model.Entity.Level;
import brainacad.org.restapi.Service.Level.LevelService;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LevelMapper {

    private final LevelService levelService;

    @Autowired
    public LevelMapper(LevelService levelService) {
        this.levelService = levelService;
    }

    @Named("mapStringToLevel")
    public Level mapStringToLevel(String levelName) {
        return levelService.findByName(levelName);
    }

    @Named("mapLevelToString")
    public String mapLevelToString(Level level) {
        return (level != null) ? level.getName() : null;
    }
}
