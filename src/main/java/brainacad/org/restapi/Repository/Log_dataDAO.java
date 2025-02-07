package brainacad.org.restapi.Repository;

import brainacad.org.restapi.Model.Entity.Log_data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Log_dataDAO extends JpaRepository<Log_data, Long>
{
}
