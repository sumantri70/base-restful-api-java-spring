package sum.base.restful.api.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse<P> {

    private int code;

    private String status;

    private String message;

    private P payload;

    public static <P> RestResponse success(P payload) {
        return new RestResponse<P>(
                200,
                "SUCESS",
                "success",
                payload
        );
    }

    public static <P> RestResponse badRequest(String message) {
        return new RestResponse<P>(
                200,
                "BAD REQUEST",
                message,
                null
        );
    }

    public static <P> RestResponse notFound(String message) {
        return new RestResponse<P>(
                404,
                "NOT FOUND",
                message,
                null
        );
    }

//    public static <P> RestResponse getResponse(Supplier<P> operation){
//        P result;
//        result = operation.get();
//        return RestResponse
//    }

}