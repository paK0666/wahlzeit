import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({org.wahlzeit.handlers.SuiteHandlers.class, org.wahlzeit.model.SuiteModel.class, 
	org.wahlzeit.model.persistence.SuiteModelPersistence.class, org.wahlzeit.services.SuiteServices.class,
	org.wahlzeit.services.mailing.SuiteServicesMailing.class, org.wahlzeit.utils.SuiteUtils.class})
public class SuiteAllTests {

}
