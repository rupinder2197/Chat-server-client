import java.net.*;
import java.io.*;
import java.util.Scanner;
public class server{
  public static void main(String args[]) throws IOException{
     String fromserver=null;
     String fromclient=null;
     ServerSocket serversocket=new ServerSocket(2717);
     Socket connectionsocket=serversocket.accept();
     DataOutputStream dout=new DataOutputStream(connectionsocket.getOutputStream());
        DataInputStream din=new DataInputStream(connectionsocket.getInputStream());
     Scanner input=new Scanner(System.in);
     fromclient=din.readUTF();
     System.out.println("CLIENT:"+fromclient);
     System.out.print("SERVER:");
     fromserver=input.next();
     dout.writeUTF(fromserver);
     if(fromserver.equals("y") && !fromclient.equals("bye"))
       { do{ 
           fromclient=din.readUTF();
           System.out.println("CLIENT:"+fromclient);
	   if(fromclient.equals("bye"))
      		{ System.out.println("chat stopped");
		  break; }
           System.out.print("SERVER:");
           fromserver=input.next();
	   dout.writeUTF(fromserver);
	   }while(!fromserver.equals("bye"));
       }
     if(fromserver.equals("bye"))
      System.out.println("chat stopped");
     connectionsocket.close();
  }
}
     
   
