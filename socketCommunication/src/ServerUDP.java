//https://www.qoosky.io/techs/f8c35bb5d7
//サーバーサイド 
//$ javac Server.java && java Server 8888
//qoosky
import java.net.DatagramSocket;
import java.net.DatagramPacket;

class ServerUDP {
    public static void main(String args[]) {
        try {
            int port = Integer.parseInt(args[0]); //サーバー側の待受ポート番号
            DatagramSocket ds = new DatagramSocket(port);

            byte buffer[] = new byte[32]; //受信データを書き込むためのバッファ
            while(true) {
                // 受信したデータは実際にはbufferに格納される
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ds.receive(dp); //受信するまで待機

                // 以下、受信後
                byte received[] = new byte[dp.getLength()];
                byte tmp[] = dp.getData(); //32バイト (buffer.length)
                for(int i=0; i<dp.getLength(); ++i) received[i]=tmp[i];

                // 文字列化して出力
                String str = new String(received);
                System.out.println(str);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}