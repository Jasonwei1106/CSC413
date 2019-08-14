package homework1;

import java.util.HashMap;
import java.util.List;

public class Math implements Endpoint<Integer>{
    HashMap<String, Integer> map2;
     int result;
     public Integer solve_end(HashMap<String,Integer> addmap){

         if(addmap.size()==1){
             for(String keys: addmap.keySet())
             result = addmap.get(keys)+ 1;
         }else if(addmap.size()==2) {
             for (String keys: addmap.keySet()) {
                 result += addmap.get(keys);
             }
         }
         return result;
     }
 }