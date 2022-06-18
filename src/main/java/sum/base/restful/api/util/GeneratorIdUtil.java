package sum.base.restful.api.util;

import java.util.UUID;

public class GeneratorIdUtil {

    public static String GenerateId(){
        return UUID.randomUUID().toString().replace("-","");
    }

}
