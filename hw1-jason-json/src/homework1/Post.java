package homework1;

import java.util.HashMap;
import java.util.List;

public class Post implements Endpoint<Integer> {
    int value;
    public Integer solve_end(HashMap<String, Integer> postmap){
        for(String keys: postmap.keySet())
            value = postmap.get(keys);

        return value;
    }
}

