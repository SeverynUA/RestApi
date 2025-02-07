package brainacad.org.restapi.ServiceTest.Level;

import brainacad.org.restapi.Model.Entity.Level;
import brainacad.org.restapi.ServiceTest.CRUDService_Interface;

public interface LevelServiceTest extends CRUDService_Interface
{
    public void getAll_ReturnsList_WhenLevelExist();
}
