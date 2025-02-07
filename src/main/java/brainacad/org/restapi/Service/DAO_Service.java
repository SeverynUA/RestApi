package brainacad.org.restapi.Service;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DAO_Service<C,R,U>
{
    C create(C dto);
    R getById(@NotNull Long id);
    List<R> getAll();
    U update(@NotNull Long id,U dto);
    void delete(@NotNull Long id);

    JpaRepository<?,?> getRepository();
}
