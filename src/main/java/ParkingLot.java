public class ParkingLot {

    static double totalRevenue = 0;

    public double processTicket(Ticket ticket) {

        double result;

        // round time to nearest hour
        double hours = Math.round(ticket.getTimeOut() - ticket.getTimeIn());

        double weeks = 0;
        double days = 0;

        // pull out whole weeks and days
        while (hours >= 24) {
            // Weeks checker
            if (hours >= 24 * 7) {
                weeks++;
                hours -= (24 * 7);
            // Day checker
            } else if (hours >= 24) {
                days++;
                hours -= 24;
            }
        }

        // set fees for whole units of time
        double dayFee = 15 * days;
        double hourFee = 2 * hours;
        double weekFee = 90 * weeks;

        // enforce that max daily fee is $15
        if (hourFee > 15) {
            hourFee = 15;
        }

        // enforce that max weekly fee is $90
        if (dayFee >= 90) {
            dayFee = 90;
            hourFee = 0;
        }

        // add all fees
        result = weekFee + dayFee + hourFee;

        // Scenario: Ticket is lost
        if ("true".equals(ticket.getTicketLost())) {
            result = 75;
        }

        totalRevenue += result;
        System.out.println(totalRevenue);
        return result;
    }
}
