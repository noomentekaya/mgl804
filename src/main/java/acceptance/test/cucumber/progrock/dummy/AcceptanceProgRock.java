package acceptance.test.cucumber.progrock.dummy;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cucumber.api.junit.Cucumber;
import hello.Application;
@RunWith(Cucumber.class)
@SpringApplicationConfiguration(classes = Application.class)

public class AcceptanceProgRock {

}
