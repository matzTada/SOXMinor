//https://www.qoosky.io/techs/f8c35bb5d7
//TCP/IP クライアントサイド
//$ javac Client.java && java Client localhost 8888 7
//49
import java.net.Socket;
import java.io.InputStream;
import java.io.DataInputStream;
import java.io.OutputStream;
import java.io.DataOutputStream;

class Client {
    public static void main(String args[]) {
        try {
            String server = args[0];
            int port = Integer.parseInt(args[1]); //サーバー側のポート番号
            Socket s = new Socket(server, port);

            // サーバーに数値を送信
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(Integer.parseInt(args[2]));

            // 演算結果を受信
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            int res = dis.readInt();
            System.out.println(res);

            // ストリームを閉じる
            dis.close();
            dos.close();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}