public class ParkingLot {

    public double processTicket(Ticket ticket) {
        double timeElapsed = ticket.getTimeOut() - ticket.getTimeIn();

        // Scenario: Ticket is lost
        if ("true".equals(ticket.getTicketLost()))
        {
            return 75;

        // Scenario: Ticket is processed in under 30 minutes
        } else if (timeElapsed <= 0.5) {
            return 0;
        }

        double days = 0;
        while (timeElapsed > 7.5) {
            days++;
            timeElapsed -= 24;
        }
        timeElapsed = Math.round(ticket.getTimeOut() - ticket.getTimeIn());

        return ((15.0 * days) + (2.0 * (timeElapsed % 24)));
    }
}
