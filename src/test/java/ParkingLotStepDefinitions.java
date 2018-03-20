import static org.junit.Assert.assertEquals;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ParkingLotStepDefinitions {

    private ParkingLot parkingLot;
    private Ticket ticket;
    private double result;

        @Given("^A ticket$")
        public void aTicket () {
            ticket = new Ticket();
            parkingLot = new ParkingLot();
        }

        @And("^CarID is \"([^\"]*)\"$")
        public void carIdIs (String carId) {
            ticket.setCarId("1");
        }

        @And("^TimeIn is \"([^\"]*)\"$")
        public void timeInIs (final double timeIn) {
            ticket.setTimeIn(timeIn);
        }

        @And("^TimeOut is \"([^\"]*)\"$")
        public void timeOutIs ( final double timeOut) {
            ticket.setTimeOut(timeOut);
        }

        @And("^TicketLost is \"([^\"]*)\"$")
        public void ticketLostIs (final String ticketLost) {
            ticket.setTicketLost(ticketLost);
        }

        @When("^Ticket is processed$")
        public void aTicketIsProcessed () {
            result = parkingLot.processTicket(ticket);
        }

        @Then("^fee is calculated to be (\\d+)$")
        public void feeIsCalculatedToBe (final double fee) {
            assertEquals(fee, result, 0);
        }
}
