package homework1;

import sun.security.smartcardio.SunPCSC;

import java.util.List;

public class Factory {
    public static Endpoint Endpointfacotry(String request) {

        if(request.equals("/math/add")){
            return new Math();

        }
        else if(request.equals("/posts")){
            return new Post();

        }
        else if(request.equals("/users")){
            return new User();

        }
        else if(request.equals("Error")){
            return new Error();

        }
          return null;

    }
}