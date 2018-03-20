public class Ticket {

    private String carId;
    private double timeIn;
    private double timeOut;
    private String ticketLost;

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public void setTicketLost(String ticketLost) {
        this.ticketLost = ticketLost;
    }

    public String getTicketLost() {
        return ticketLost;
    }

    public double getTimeIn() {
        return timeIn;
    }

    public void setTimeIn(double timeIn) {
        this.timeIn = timeIn;
    }

    public double getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(double timeOut) {
        this.timeOut = timeOut;
    }
}
