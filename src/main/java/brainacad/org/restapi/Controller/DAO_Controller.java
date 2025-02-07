package brainacad.org.restapi.Controller;

import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface DAO_Controller<C,R,U>
{
    ResponseEntity<C> create(C dto);
    ResponseEntity<R> getById(@NotNull Long id);
    ResponseEntity<List<R>> getAll();
    ResponseEntity<U> update(@NotNull Long id,U dto);
    ResponseEntity <Void> delete(@NotNull Long id);
}
