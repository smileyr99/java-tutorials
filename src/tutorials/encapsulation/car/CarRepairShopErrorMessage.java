package tutorials.encapsulation.car;

public enum CarRepairShopErrorMessage {
    ALREADY_EXIST_CAR(1,"Already car exists."),
    INVALID_TICKET_NUM(2, "Invalid ticket number.");

    int errorCode;
    String message;

    CarRepairShopErrorMessage(int errorCode, String message){
        this.errorCode = errorCode;
        this.message = message;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getMessage() {
        return message;
    }


}