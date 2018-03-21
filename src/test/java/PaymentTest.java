import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class PaymentTest {

    @Test
    public void testSuccessfulCreditCardPayment() {
        //Arrange
        ICreditCardService ccsMock = mock(ICreditCardService.class);

        when(ccsMock.processCard()).thenReturn("processed");

        ParkingLot parkingLot = new ParkingLot(ccsMock);
        Ticket ticket = new Ticket();
        ticket.setCarId("1");
        ticket.setTicketLost("false");
        ticket.setTimeIn(0.0);
        ticket.setTimeOut(173);
        ticket.setPaymentMethod("CreditCard");

        //Act
        double result = parkingLot.processTicket(ticket);

        //Assert
        assertEquals(97.5, result, 0);
    }

    @Test
    public void testDeclinedCreditCardPayment() {
        //Arrange
        ICreditCardService ccsMock = mock(ICreditCardService.class);

        when(ccsMock.processCard()).thenReturn("declined");

        ParkingLot parkingLot = new ParkingLot(ccsMock);
        Ticket ticket = new Ticket();
        ticket.setCarId("1");
        ticket.setTicketLost("false");
        ticket.setTimeIn(0.0);
        ticket.setTimeOut(173);
        ticket.setPaymentMethod("CreditCard");

        //Act
        double result = parkingLot.processTicket(ticket);

        //Assert
        assertEquals(100, result, 0);
    }

    @Test
    public void testCashPayment() {
        //Arrange
        ICreditCardService ccsMock = mock(ICreditCardService.class);

        when(ccsMock.processCard()).thenReturn("declined");

        ParkingLot parkingLot = new ParkingLot(ccsMock);
        Ticket ticket = new Ticket();
        ticket.setCarId("1");
        ticket.setTicketLost("false");
        ticket.setTimeIn(0.0);
        ticket.setTimeOut(173);
        ticket.setPaymentMethod("Cash");

        //Act
        double result = parkingLot.processTicket(ticket);

        //Assert
        assertEquals(100, result, 0);
    }
}
