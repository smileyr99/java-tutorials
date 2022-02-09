package tutorials.encapsulation.car;

//SET 은 변수값을 할당하는 목적의 함수이기 때문에 인자를 받아야 하고
// GET 은 변수값을 반환하는 목적이기 때문에 return 이 필요합니다.

public class RepairTicket {
    private String VIN;
    private double cost;
    private String description;
    private int recentTicket;

    public RepairTicket(String VIN, double cost, String description, int recentTicket) {
        this.VIN = VIN;
        this.cost = cost;
        this.description = description;
        this.recentTicket = recentTicket;
    }

    public String getVIN() {
        return VIN;
    }

    public double getCost() {
        return cost;
    }

    public String getDescription() {
        return description;
    }

    public int getRecentTicket() {
        return recentTicket;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}