package homework1;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import javax.naming.spi.ObjectFactoryBuilder;
import javax.print.DocFlavor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.Object;
import java.util.HashMap;

public class Response {
    private static String responseCode;
    private static String response;
    private String key1, key2;

    private static final DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sssZ");

    public void getreponse(String s) {
        Date date = new Date();

        String xDate = outputFormat.format(date);

        StringBuilder sb = new StringBuilder();

        Processor test3 = new Processor();
        test3.splitendpoint(s);

        Endpoint endpoint = Factory.Endpointfacotry(test3.getrequest(s));
        response = endpoint.solve_end(test3.map).toString();

        if (test3.getrequest(s).equals("/math/add")) {
            responseCode = "OK";
        } else if (test3.getrequest(s).equals("/posts")) {
            responseCode = "OK";
        } else if (test3.getrequest(s).equals("/users")) {
            responseCode = "OK";
        } else if (test3.getrequest(s).equals("Error")) {
            responseCode = "ERROR";
        } else {
            responseCode = null;
        }
       /* System.out.println("rcode: " + responseCode);
        System.out.println("response " + endpoint.solve_end(test3.map));

*/

           StringBuilder anotherSB2 = new StringBuilder();
        StringBuilder anotherSB = new StringBuilder();
        if(test3.map.size()==2) {
            HashMap.Entry<String, Integer> entry = test3.map.entrySet().iterator().next();
            String key = entry.getKey();
            int value = entry.getValue();
            anotherSB2.append("\n\"" + key + "\": \"" + value + "\",");


            for (String keys : test3.map.keySet()) {
                //System.out.println(keys + " " + test3.map.get(keys));
                key1 = keys;
                key2 = String.valueOf(test3.map.get(keys));

            }
            anotherSB.append("\n\"" + key1 + "\": \"" + key2 + "\"");



        }else if(test3.map.size()==1){
            for (String keys : test3.map.keySet()) {
                //System.out.println(keys + " " + test3.map.get(keys));
                key1 = keys;
                key2 = String.valueOf(test3.map.get(keys));
            }
            anotherSB.append("\n\"" + key1 + "\": \"" + key2 + "\"");
        }




        sb.append("{");
        sb.append("\n\"date\": \"" + xDate + "\",");
        sb.append("\n\"params\": {" + anotherSB2);
        sb.append(anotherSB);
        sb.append("\n},\n\"responseCode\": \"" + responseCode + "\",");
        sb.append("\n\"response\": " + response + "\n}");


        String sbparse = new String(sb);
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(sbparse).getAsJsonObject();

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);



        System.out.println(prettyJson);
    }

    /*public void getKeys(String s) {
        Processor keyP = new Processor();
        keyP.splitendpoint(s);

        //Endpoint endpoint = Factory.Endpointfacotry(keyP.getrequest(s));
        for (String keys : keyP.map.keySet()) {
            System.out.println(keys + " " + keyP.map.get(keys));

            String k1 = keys;
            String k2 = String.valueOf(keyP.map.get(keys));

            String retS = "peepee";//("\n" + k1 + ": " + k2);
            System.out.println(k1);
        }
    }

    private static final DateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sssZ");
    Date date = new Date();

    String xDate = outputFormat.format(date);

    public String responseToString() {
        Processor rtest = new Processor();

        StringBuilder sb = new StringBuilder();

        StringBuilder anotherSB = new StringBuilder();
        //anotherSB.append(retS);

        sb.append("\ndate: " + xDate);
        sb.append("\nparams: " + anotherSB);
        sb.append("\nresponseCode: " + responseCode);
        sb.append("\nresponse: " + response);

        return sb.toString();
    }*/
}

