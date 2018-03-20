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

        timeElapsed = Math.round(ticket.getTimeOut() - ticket.getTimeIn());

        double days = Math.floor(timeElapsed/24);
        double hours = timeElapsed % 24;

        double dayFee = days*15;
        double hourFee = 2*hours;
        if (hourFee > 15) {
            hourFee = 15;
        }

        return dayFee + hourFee;
    }
}
