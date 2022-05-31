package by.svetlenkaja.travelagency.exception;

public class TourServiceException extends  RuntimeException{
    public TourServiceException(String message) {
        super(message);
    }

    public TourServiceException(Exception exception) {
        super(exception);
        this.setStackTrace(exception.getStackTrace());
    }

    public TourServiceException(String message, Exception exception) {
        super(message, exception);
    }
}
