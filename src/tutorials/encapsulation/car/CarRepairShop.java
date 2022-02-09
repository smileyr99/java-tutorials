package tutorials.encapsulation.car;

public class CarRepairShop {

    private int carCnt = 0;
    private int ticketCnt = 0;
    private Car[] carDatabase;
    private RepairTicket[] ticketDatabase;
    private int recentTicket = 1;

    public boolean existCar(String VIN) {
        for (int i = 0; i < carCnt; i++) {
            if (carDatabase[i] != null && carDatabase[i].getVIN().equals(VIN)) {
                return true;
            }
        }
        return false;
    }

    public int addNewCar(String VIN, String make, int year) {
        if (existCar(VIN)) {
            throw new CarRepairShopException(CarRepairShopErrorMessage.ALREADY_EXIST_CAR);
        }
        if (carDatabase == null || carCnt + 1 > carDatabase.length) {
            Car[] nCarDatabase = new Car[(carCnt + 1) * 2];
            for (int i = 0; i < carCnt; i++) {
                nCarDatabase[i] = carDatabase[i];
            }
            carDatabase = nCarDatabase;
        }

        carDatabase[carCnt] = new Car(VIN, make, year);
        carCnt++;

        return carCnt;
    }

    public int increaseTicket() {
        return recentTicket++;
    }

    public int addRepairTicket(String VIN, double cost, String description) {
        //car exist validation
        if (existCar(VIN)) {
            throw new CarRepairShopException(CarRepairShopErrorMessage.ALREADY_EXIST_CAR);
        }
        if (ticketDatabase == null || ticketCnt + 1 > ticketDatabase.length) {
            RepairTicket[] nTicketDatabase = new RepairTicket[(ticketCnt + 1) * 2];
            for (int i = 0; i < ticketCnt; i++) {
                nTicketDatabase[i] = ticketDatabase[i];
            }
            ticketDatabase = nTicketDatabase;
        }

        ticketDatabase[ticketCnt] = new RepairTicket(VIN, cost, description, recentTicket);
        ticketCnt++;
        increaseTicket();

        return ticketCnt;
    }

    public double getRepairCost(int ticketNum) {
        double result = -1;

        for (int i = 0; i < ticketCnt; i++) {
            if (ticketNum == ticketDatabase[i].getRecentTicket()) {
                result = ticketDatabase[i].getCost();
            }
        }
        if(result == -1){
            throw new CarRepairShopException(CarRepairShopErrorMessage.INVALID_TICKET_NUM);
        }

        return result;
    }

    public double getTotalRepairCosts(String VIN) {
        double total = -1;

        for (int i = 0; i < carCnt; i++) {
            if (carDatabase[i].getVIN().equals(VIN)) {
                total = 0.0;
            }
        }
        if (total < 0) {
            return total;
        } else {
            for (int i = 0; i < ticketCnt; i++) {
                if (ticketDatabase[i].getVIN().equals(VIN)) {
                    total += ticketDatabase[i].getCost();
                }
            }
            return total;
        }
    }

    public String getWorstCarMake() {
        String[] makeArr = new String[carCnt];
        int[] cnt = new int[carCnt];
        int makeCnt = 0;
        String worstMake = null;

        for (int i = 0; i < ticketCnt; i++) {
            for (int j = 0; j < carCnt; j++) {
                if (ticketDatabase[i] != null && ticketDatabase[i].getVIN().equals(carDatabase[j].getVIN())) {
                    String make = carDatabase[j].getMake();
                    int idx;
                    for (idx = 0; idx < makeCnt; idx++) {
                        if (make.equals(makeArr[idx])) {
                            break;
                        }
                    }
                    makeArr[idx] = make;
                    cnt[idx]++;
                    if (idx == makeCnt) {
                        makeCnt++;
                    }
                    break;
                }
            }
        }
        int max = 0;
        for (int i = 0; i < makeCnt; i++) {
            if (max < cnt[i]) {
                max = cnt[i];
                worstMake = makeArr[i];
            }
        }
        return worstMake;
    }

    public boolean updateRepairCost(int ticketNum, double newCost) {
        boolean result = false;

        for (int i = 0; i < ticketCnt; i++){
            if(ticketDatabase[i] != null && ticketNum == ticketDatabase[i].getRecentTicket()){
                ticketDatabase[i].setCost(newCost);
                result = true;
            }
        }
        if(!result){
            throw new CarRepairShopException(CarRepairShopErrorMessage.INVALID_TICKET_NUM);
        }

        return result;
    }

    public boolean deleteRepair(int ticketNum) {
        boolean result = false;

        for (int i = 0; i < ticketCnt; i++) {
            if (ticketDatabase[i] != null && ticketNum == ticketDatabase[i].getRecentTicket()) {
                ticketDatabase[i] = null;
                result = true;
            }
        }
        if (result) {
            RepairTicket[] nTicketDatabase = new RepairTicket[ticketDatabase.length];
            int cnt = 0;
            for (int i = 0; i < ticketCnt; i++) {
                if (ticketDatabase[i] != null) {
                    nTicketDatabase[cnt] =  ticketDatabase[i];
                    cnt++;
                }
            }
            ticketDatabase = nTicketDatabase;
            ticketCnt--;

            return true;
        } else {
            throw new CarRepairShopException(CarRepairShopErrorMessage.INVALID_TICKET_NUM);
        }
    }

    public boolean deleteAllRepairsForCar(String VIN) {
        boolean result = false;

        int cnt = 0;
        for (int i = 0; i < ticketCnt; i++) {
            if (ticketDatabase[i] != null && ticketDatabase[i].getVIN().equals(VIN)) {
                ticketDatabase[i] = null;
                result = true;
                cnt++;
            }
        }
        ticketCnt = ticketCnt - cnt;

        if(!result){
            throw new CarRepairShopException(CarRepairShopErrorMessage.ALREADY_EXIST_CAR);
        }

        return result;
    }

    public boolean deleteCarAndRepairs(String VIN) {
        boolean result = false;

        for (int i = 0; i < carCnt; i++) {
            if (carDatabase[i] != null && carDatabase[i].getVIN().equals(VIN)) {
                carDatabase[i] = null;
                result = true;
            }
        }

        if (result) {
            deleteAllRepairsForCar(VIN);
        }
        return result;
    }
}