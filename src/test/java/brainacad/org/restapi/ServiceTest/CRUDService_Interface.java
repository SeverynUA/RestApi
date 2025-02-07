package brainacad.org.restapi.ServiceTest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public interface CRUDService_Interface
{
    @BeforeEach
    public void setUp();

    @Test
    public void create_ReturnsClass_WhenValidInputProvided();

    @Test
    public void getById_ReturnsClass_WhenRequestExists();

    @Test
    public void delete_DoesNotThrow_WhenRequestExists();

    @Test
    public void update_UpdatesEntity_WhenValidInputProvided();
}
