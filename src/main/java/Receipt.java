public class Receipt {

    private String carId;
    private double totalTimeParked;
    private String ticketLost;
    private double feeCollected;

    public Receipt(String carId, double totalTimeParked, String ticketLost, double feeCollected) {
        this.carId = carId;
        this.totalTimeParked = totalTimeParked;
        this.ticketLost = ticketLost;
        this.feeCollected = feeCollected;
    }

    public String getCarId() {
        return carId;
    }

    public double getTotalTimeParked() {
        return totalTimeParked;
    }

    public String getTicketLost() {
        return ticketLost;
    }

    public double getFeeCollected() {
        return feeCollected;
    }
    
    public void print() {
        System.out.println(
                "CarID: " + carId +
                ", Total time parked: " + totalTimeParked +
                ", Ticket lost: " + ticketLost +
                ", Fee collected: " + feeCollected);
    }
}
