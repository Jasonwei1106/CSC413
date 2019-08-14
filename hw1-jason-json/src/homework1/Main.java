package homework1;

import com.sun.corba.se.impl.orbutil.ObjectWriter;

public class Main {
       public static void main(String[] args) {
           Server s = Server.getInstance();
           s.run();
       }
    }