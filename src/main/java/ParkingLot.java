public class ParkingLot {

    public ParkingLot (ICreditCardService ccs) {
        this.ccs = ccs;
    }

    static double totalRevenue = 0;
    private Receipt receipt;
    private ICreditCardService ccs;

    public Receipt getReceipt() {
        return receipt;
    }

    public double processTicket(Ticket ticket) {

        // calculate fee
        double result = calculateFee(ticket);

        // pay
        if ("CreditCard".equals(ticket.getPaymentMethod())
                && "processed".equals(ccs.processCard())) {

            result *= 0.975;
        }

        // generate receipt
        receipt = new Receipt(
                ticket.getCarId(),
                (ticket.getTimeOut() - ticket.getTimeIn()),
                ticket.getTicketLost(),
                result);

        receipt.print();

        // reporting
        totalRevenue += result;
        System.out.println("Total Revenue: " + totalRevenue);

        return result;
    }

    private double calculateFee (Ticket ticket) {
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
        if (hourFee >= 15) {
            dayFee += 15;
            hourFee = 0;
        }

        // enforce that max weekly fee is $90
        if (dayFee >= 90) {
            weekFee += 90;
            dayFee = 0;
            hourFee = 0;
        }

        // add all fees
        result = weekFee + dayFee + hourFee;

        // Scenario: Ticket is lost
        if ("true".equals(ticket.getTicketLost())) {
            result = 75;
        }

        return result;
    }
}
