import java.net.*;
import java.util.Scanner;
public class DatagramSocketServer
{
public static void main(String args[])
{
System.out.println("Server is Running");
DatagramSocket socket=null;
try
{
socket=new DatagramSocket(9876);//keep it more than 5000
InetAddress clientAddress=InetAddress.getByName("localhost");
Scanner sc=new Scanner(System.in);
while(true)//true makes while loop infinite
{

System.out.println("Enter message to send to the client");
String message=sc.nextLine();
byte[] buffer=message.getBytes();//convert string to byte
DatagramPacket packet=new DatagramPacket(buffer,buffer.length,clientAddress,9877);//object name DatagramPacket
socket.send(packet);
if(message.equalsIgnoreCase("exit"))
{
System.out.println("server exiting");
break;



}
}
}
catch(Exception e){}
finally {
socket.close();
}
}
}