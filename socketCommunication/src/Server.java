//https://www.qoosky.io/techs/f8c35bb5d7
//TCP/IP server side return squared value
//$ javac Server.java && java Server 8888
import java.net.ServerSocket;
import java.net.Socket;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;

class Server {
    public static void main(String args[]) {
        try {
            int port = Integer.parseInt(args[0]); //server side port number
            ServerSocket ss = new ServerSocket(port);

            while(true) {
                Socket s = ss.accept(); //wait for request of client

                //when request from client
                InputStream is = s.getInputStream(); //receive value from client
                DataInputStream dis = new DataInputStream(is);
                int req = dis.readInt();

                OutputStream os = s.getOutputStream(); //send squared value 
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeInt(req*req);

                //close stream
                dos.close();
                dis.close();
            }
        }
        catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}