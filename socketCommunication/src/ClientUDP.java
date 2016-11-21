//https://www.qoosky.io/techs/f8c35bb5d7
//client side UDP
//$ javac Client.java && java Client localhost 8888 qoosky
import java.net.DatagramSocket;
import java.net.DatagramPacket;
import java.net.InetAddress;

class ClientUDP {
    public static void main(String args[]) {
        try {
            InetAddress addr = InetAddress.getByName(args[0]);
            int port = Integer.parseInt(args[1]); //server side port number

            // making sending packet
            byte buffer[] = args[2].getBytes();
            DatagramPacket dp = new DatagramPacket(buffer, buffer.length, addr, port);

            // make socket and send
            DatagramSocket ds = new DatagramSocket();
            ds.send(dp);
            ds.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}