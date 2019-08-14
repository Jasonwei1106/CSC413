package homework1;

import java.util.HashMap;
import java.util.List;

 public interface Endpoint <T> {
    T solve_end(HashMap<String, Integer> mapname);
}
