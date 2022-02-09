package tutorials.encapsulation.car;

public class CarRepairShopException extends RuntimeException {
    int errorCode;

    public CarRepairShopException() {
        super();
    }

    public CarRepairShopException(String msg) {
        super(msg);
    }

    public CarRepairShopException(String msg, int errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }

    public CarRepairShopException(CarRepairShopErrorMessage errorMessage) {
        super(errorMessage.getMessage());
        this.errorCode = errorMessage.getErrorCode();
    }

    public CarRepairShopException(CarRepairShopErrorMessage errorMessage, Throwable t) {
        super(errorMessage.getMessage(), t);
        this.errorCode = errorMessage.getErrorCode();
    }


}
