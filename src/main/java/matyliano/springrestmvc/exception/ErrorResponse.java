package matyliano.springrestmvc.exception;

public class ErrorResponse {

    private String message;
    private int code;
    private String moreInfo;

    public ErrorResponse(String message, int code, String moreInfo) {
        super();
        this.message = message;
        this.code = code;
        this.moreInfo = moreInfo;
    }

    public String getMessage() {

        return message;
    }

    public int getCode() {

        return code;
    }

    public String getMoreInfo() {

        return moreInfo;
    }

}

