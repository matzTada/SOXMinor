//https://www.qoosky.io/techs/f8c35bb5d7
//server side UDP
//$ javac Server.java && java Server 8888
//qoosky
import java.net.DatagramSocket;
import java.net.DatagramPacket;

class ServerUDP {
    public static void main(String args[]) {
        try {
            int port = Integer.parseInt(args[0]); //server side port number
            DatagramSocket ds = new DatagramSocket(port);

            byte buffer[] = new byte[32]; //buffer for receiving data
            while(true) {
                // received data is stored to buffer
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ds.receive(dp); //wait for receiving

                // when received
                byte received[] = new byte[dp.getLength()];
                byte tmp[] = dp.getData(); //32byte (buffer.length)
                for(int i=0; i<dp.getLength(); ++i) received[i]=tmp[i];

                // output after make it string
                String str = new String(received);
                System.out.println(str);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}