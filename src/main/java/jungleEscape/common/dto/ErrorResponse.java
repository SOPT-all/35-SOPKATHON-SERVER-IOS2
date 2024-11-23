package jungleEscape.common.dto;

import jungleEscape.common.util.NullValidator;

public record ErrorResponse(
        boolean success,
        String message
) implements BaseResponse {

    public static ErrorResponse of(final String message) {
        NullValidator.valid(message);
        return new ErrorResponse(false, message);
    }
}
