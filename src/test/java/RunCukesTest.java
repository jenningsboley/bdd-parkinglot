import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

/**
 * JUnit runner which uses the JUnit framework to run Cucumber.
 *
 * @author DNA Generator
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "/Users/n0204148/Dev/tdd/src/test/java/CalculateFeeWhenTicketIsProcessed.feature")
public final class RunCukesTest {


    private RunCukesTest() {

    }

//    @BeforeClass
//    public static void beforeClass() {
//        int port = SocketUtils.findAvailableTcpPort();
//        System.setProperty("server.port", String.valueOf(port));
//    }
}