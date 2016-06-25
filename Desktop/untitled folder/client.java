import java.net.*;
import java.io.*;
import java.util.Scanner;
public class client{
 public static void main(String args[]) throws IOException{
   Socket clientsocket=new Socket("127.0.0.1",2717);
   String fromserver=null;
   String fromclient=null;
   DataOutputStream dout=new DataOutputStream(clientsocket.getOutputStream());
   DataInputStream din=new DataInputStream(clientsocket.getInputStream());
   Scanner input=new Scanner(System.in);
   System.out.println("CLIENT:wanna chat");
   dout.writeUTF("wanna chat y/n");
   fromserver=din.readUTF();
   System.out.println("SERVER:"+fromserver);
   if(fromserver.equals("y"))
     { do{ 
  	   System.out.print("CLIENT:");
           fromclient=input.next();
           dout.writeUTF(fromclient);
	   if(fromclient.equals("bye"))
      		{ System.out.println("chat stopped");
		  break; }
     	   fromserver=din.readUTF();
    	   System.out.println("SERVER:"+fromserver);
         }while(!fromserver.equals("bye"));
      }
    if(fromserver.equals("bye"))
      System.out.println("chat stopped");
   clientsocket.close();
   }
}
