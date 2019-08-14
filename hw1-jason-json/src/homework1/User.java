package homework1;

import java.util.HashMap;
import java.util.List;

public class User implements Endpoint<Integer> {
    int value;
    public Integer solve_end(HashMap<String, Integer> usermap){
        for(String keys: usermap.keySet())
            value = usermap.get(keys);

        return value;
    }
}
