package spark;

import static spark.Spark.*;

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

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;

import javax.print.DocFlavor;

public class Main {
/*
    public static String processRoute(Request req, Response res) {
        Set<String> params = req.queryParams();
        for (String param : params) {
            // possible for query param to be an array
            System.out.println(param + " : " + req.queryParamsValues(param)[0]);
        }
        // do stuff with a mapped version http://javadoc.io/doc/com.sparkjava/spark-core/2.8.0
        // http://sparkjava.com/documentation#query-maps
        // print the id query value
        System.out.println(req.queryMap().get("id").value());
        return "Done!";
    }
*/
    public static void main(String[] args) {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        MongoDatabase db = mongoClient.getDatabase("MyDatabase");
        MongoCollection<Document> myCollection = db.getCollection("MyCollection");
        DateFormat DateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:sss'Z'");
        String date = DateFormat.format(new Date()).toString();

        port(3030);
        // calling get will make your app start listening for the GET path with the /hello endpoint
        get("/store", (req, res) -> {
            //Data fin = new Data();
            Document doc = new Document("date", date)
                    //.append("type", "database")
                    .append("data",req.queryMap().get("notes").value());
            // insert document into collection

            myCollection.insertOne(doc);

         //   fin.id = doc.getObjectId("_id").toHexString();
//System.out.println(fin.id);
            ResponseS resP = new ResponseS();
            String resS = resP.Response("OK");
            return resS;

           // String returnS = "<br>{<br/>" + "<br>date:<br/>" + dateV + " &#09; responseCode:" + responseCode + "<br>response:<br/>" + "<br>[<br/>" + "<br>{<br/>" + "<br/>data:<br/>" +dataValue+"<br>_id:<br/>"+ idValue+"<br>date:<br/>"+dateValue+"<br>}<br/>"+"<br>]<br/>,"+"<br>}<br/>";

            //return returnS;

        });

        // showing a lambda expression with block body

        // Slightly more advanced routing
        get("/list", (req, res) -> {
            String dataS = "";
            MongoCursor<Document> cursor = myCollection.find().iterator();
            //System.out.println(cursor);
            try {
                while (cursor.hasNext()) {
                    dataS = dataS + cursor.next().toJson()+"<br>";
                }
                //System.out.println(dataS);

                ResponseS resP = new ResponseS();
                String resS = resP.Response("OK", dataS);
                return resS;
            } finally {
                cursor.close();
            }

        });

        get("/delete", (req, res) -> {
           myCollection.deleteOne(new Document("_id", new ObjectId(req.queryMap().get("_id").value())));
            myCollection.deleteOne(new Document("_id", req.queryMap().get("_id").value()));
            ResponseS resP = new ResponseS();
            String resS = resP.Response("Deleted");
            return resS;
        });

        get("/get", (req, res) -> {
            //System.out.println("inner get");
            String dataS ="";
            if (req.queryMap().hasKey("_id")) {
                //System.out.println("_id get.");
                MongoCursor<Document> cursor = myCollection.find(new Document("_id", new ObjectId(req.queryMap().get("_id").value()))).iterator();
                //MongoCursor<Document> cursor = myCollection.find(new Document("_id", req.queryMap().get("_id").value())).iterator();
               // System.out.println("before get return.");
                //System.out.println(cursor.next().toJson());
                ResponseS resP= new ResponseS();
                String resS = resP.Response("OK",cursor.next().toJson());
                return resS;
                //return cursor.next().toJson();
                //return "test";
                // return cursor.next().get("data");
            } else if (req.queryMap().hasKey("contains")) {
                //System.out.println("in contains");
                MongoCursor<Document> cursor = myCollection.find(regex("data", req.queryMap().get("contains").value())).iterator();
                //System.out.println("after get contain.");
                try {
                    while (cursor.hasNext()) {
                        dataS = dataS + cursor.next().toJson();
                    }
                    //System.out.println(dataS);
                    ResponseS resP = new ResponseS();
                    String resS = resP.Response("OK", dataS);
                    return resS;
                } finally {
                    cursor.close();
                }
                //return "Done!";
            } else {
                return "Error";
            }
        });

    }
}
