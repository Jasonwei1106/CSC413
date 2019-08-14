package homework1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

    public class Server {

        String url;
        private static Server instance;

        public static Server getInstance() {
            if (instance == null) {
                instance = new Server();
            }
            return instance;
        }

        void run() {
            System.out.println("Homework 1");
            ServerSocket ding;
            Socket dong = null;
            String resource = null;
            try {
                ding = new ServerSocket(6969);
                System.out.println("Opened socket " + 6969);
                while (true) {
                    // keeps listening for new clients, one at a time
                    try {
                        dong = ding.accept(); // waits for client here
                    } catch (IOException e) {
                        System.out.println("Error opening socket");
                        System.exit(1);
                    }

                    InputStream stream = dong.getInputStream();
                    BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                    try {
                        // read the first line to get the request method, URI and HTTP version
                        String line = in.readLine();
                        url = line;

                        //System.out.println(url);
                        System.out.println("----------REQUEST START---------");
                        System.out.println(line);
                        // read only headers
                        line = in.readLine();
                        while (line != null && line.trim().length() > 0) {
                            int index = line.indexOf(": ");
                            if (index > 0) {
                                System.out.println(line);
                            } else {
                                break;
                            }
                            line = in.readLine();
                        }
                        System.out.println("----------REQUEST END---------\n\n");
                    } catch (IOException e) {
                        System.out.println("Error reading");
                        System.exit(1);
                    }

                    BufferedOutputStream out = new BufferedOutputStream(dong.getOutputStream());
                    PrintWriter writer = new PrintWriter(out, true);  // char output to the client

                    /*
                    Processor p = new Processor();
                    p.splitendpoint(url);
                    //System.out.println(keys +"  "+ value);
                    Endpoint endpoint = Factory.Endpointfacotry(p.getrequest(url));
                    //System.out.println(endpoint.solve_end(p.map));
*/

                    // every response will always have the status-line, date, and server name
                    writer.println("");

                    // Body of our response
                    Response r = new Response();
                    System.out.println("\n\n\n\n");
                    r.getreponse(url);

                    //r.responseToString();
                    // writer.println(r.getKeys(url));

                    dong.close();
                }
            } catch (IOException e) {
                System.out.println("Error opening socket");
                System.exit(1);
            }

        }
    }

