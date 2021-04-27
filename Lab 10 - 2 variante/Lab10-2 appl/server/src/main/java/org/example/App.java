package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {  //starting server from here
        try {
            Server server = new Server();
        } catch(Exception e)
        {System.err.println("Eroare de server");}
        System.out.println( "All work is in the classes" );
    }
}
