package homework1;


import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.net.URL;
import java.net.MalformedURLException;

class Processor {
    int result;
    String request;
    int num;
    HashMap<String, Integer> map;
    //List<Integer> mylist;
    String sub2;

    public String getrequest(String endpoint){

            String [] sub1 = endpoint.split(" ",2);

            if(sub1[1].contains("?")) {
                String[] array = sub1[1].split("\\?");
                request = array[0];
            }else{
                request = "Error";
            }

        return request;
    }
    public void splitendpoint(String endpoint) {
        endpoint = endpoint.substring(0,endpoint.length()-9);
        String [] sub1 = endpoint.split(" ",2);
        if(sub1[1].contains("?")) {
            String[] array = sub1[1].split("\\?");
            //mylist = new ArrayList<Integer>();
            map = new HashMap<String, Integer>();
            if (array[1].contains("&")) {
                String[] subarray = array[1].split("&");
                for (int i = 0; i < subarray.length; i++) {
                    String[] str = subarray[i].split("=");
                    String number = str[1].replaceAll("[^\\d.]", "");
                    int num = Integer.parseInt(number);
                    map.put(str[0],num);
                }
            }
            else{

                String[] str = array[1].split("=");
                String number = str[1].replaceAll("[^\\d.]", "");
                int num = Integer.parseInt(number);
                map.put(str[0], num);
            }
        }
    }

      /* public static void main(String [] args) {
           String s = "GET /math/add?a=1&b=2 HTTP/1.1";
           String s2 = "GET /users?userid=1234 HTTP/1.1";
           String s3 = "GET /asdasda HTTP/1.1";
           Processor test = new Processor();
           Processor test2 = new Processor();
           Processor test3 = new Processor();
           test.splitendpoint(s);
           //System.out.println(keys +"  "+ value);
           Endpoint endpoint = Factory.Endpointfacotry(test.getrequest(s));
           System.out.println(endpoint.solve_end(test.map));

           test2.splitendpoint(s2);
           //System.out.println(keys +"  "+ value);
           Endpoint endpoint2 = Factory.Endpointfacotry(test2.getrequest(s2));
           System.out.println(endpoint2.solve_end(test2.map));

         test3.splitendpoint(s3);
           //System.out.println(keys +"  "+ value);
           Endpoint endpoint3 = Factory.Endpointfacotry(test3.getrequest(s3));
               System.out.println(endpoint3.solve_end(test3.map));
           //}else{
             //  System.out.print("");
           }*/
       }






