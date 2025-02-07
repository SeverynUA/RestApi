package brainacad.org.restapi.Repository;

import brainacad.org.restapi.Model.Entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Level_DAO extends JpaRepository<Level, Long>
{
    Optional<Level> findByName(String levelName);
}
