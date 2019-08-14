package spark;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import static spark.Spark.*;


import com.google.gson.*;
import com.google.gson.JsonObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.util.JSON;
import org.bson.Document;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class ResponseS {
    public String Response(String status){
        //status="OK";
        DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");
        String dateS = DateFormat.format(new Date()).toString();
        return "{<br>" + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"date\":" + dateS + "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"responseCode\":"+status+"<br> }";
    }
    public String Response(String status, String data) {
        if (data.equals("")) {return "Empty";}
        else{
            if (status.equals("OK")) {
                DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");
                String dateS = DateFormat.format(new Date()).toString();
                //data = "<pre>" + data + "<pre/>";
                data = data.replaceAll("},", ",");
                data = data.replaceAll(",", "<br>");
                data = data.replaceAll("\\{ \"_", "{ <br> \"_");
                data = data.replaceAll(": \\{", "");
                data = data.replaceAll("\"\\$oid\"", "");
                //data = data.replaceFirst(" }"," ");
                data = data.replaceAll("}", "<br> }");
                data = data.replaceAll("}\\{", "<br> } <br> \\{");
                data = data.replaceAll("\\{", " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \\{ ");
                data = data.replaceAll("}", " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; } ");
                data = data.replaceAll("\"_", " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \"_");
                data = data.replaceAll("\"data", " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \"data");
                data = data.replaceAll("\"date", " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; \"date");
                return "{ <br> \"date\":  " + dateS + "<br> \"responseCode\":" + status + " <br> \"response\":" + "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [<br>" + data + "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ],<br>}";
            } else return "ERROR";
        }
    }

    /*
    public static String toPrettyFormat(String jsonString)
    {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonParser parser = new JsonParser();
        JsonObject json = parser.parse(jsonString).getAsJsonObject();

        //Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String prettyJson = gson.toJson(json);

        return prettyJson;
    }

    public String Response(String status){
                //status="OK";
                DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");
                String dateS = DateFormat.format(new Date()).toString();
                return "{<br>" + " &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"date\":" + dateS + "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;\"responseCode\":"+status+"<br> }";
    }
    public String Response(String status, String data) {



        if (status.equals("OK")) {

            DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");
            String dateS = DateFormat.format(new Date()).toString();
            data = data.replaceAll("\"\\$oid\"","");
            data = data.replaceAll("},",",");
            data = data.replaceAll(": \\{","");
           //data = data.replaceAll(",",":");





            //String [] array = data.split(":");
            //String [] sub = array
            //JsonObject jo = new JsonObject();
          //  for(int i =0; i<(array.length)/2;i=i+2)ti{
              //jo.addProperty("response",data);

            //String prettyJson = toPrettyFormat(jo.toString());
            String x =  "{ <br> \"date\":  " + dateS + "<br> \"responseCode\":"+status +" <br> \"response\":" +"<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; [<br>" +  data + "<br> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ]<br>}";
             return  x;
             //Gson xd = new GsonBuilder().setPrettyPrinting().create();
            //String please = xd.toJson(jo);
            //return please;


          //System.out.println(data+"\n"+array[0]+"   "+array[1]+"    "+array[2]);
          //return "sad";
        }
        else return "error";
    }

    /*public Response(StatusResponse status, Main data) {

    }*/

}
