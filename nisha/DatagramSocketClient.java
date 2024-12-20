                                                                                                                                                                                                                                                           import java.net.*;
import java.util.Scanner;
public class DatagramSocketClient
{
public static void main(String args[])
{
DatagramSocket socket=null;
try
{
socket=new DatagramSocket(9877);
while(true)
{
byte[] buffer= new byte[1024];
DatagramPacket packet=new DatagramPacket(buffer,buffer.length);//here we just receiving
socket.receive(packet);
String message = new String(packet.getData(),0,packet.getLength());
System.out.println("Message from server:"+message);
if(message.equalsIgnoreCase("exit"))
{
System.out.println("client is exiting");
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