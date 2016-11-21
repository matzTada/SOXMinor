//https://www.qoosky.io/techs/f8c35bb5d7
//TCP/IP �N���C�A���g�T�C�h
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
            int port = Integer.parseInt(args[1]); //�T�[�o�[���̃|�[�g�ԍ�
            Socket s = new Socket(server, port);

            // �T�[�o�[�ɐ��l�𑗐M
            OutputStream os = s.getOutputStream();
            DataOutputStream dos = new DataOutputStream(os);
            dos.writeInt(Integer.parseInt(args[2]));

            // ���Z���ʂ���M
            InputStream is = s.getInputStream();
            DataInputStream dis = new DataInputStream(is);
            int res = dis.readInt();
            System.out.println(res);

            // �X�g���[�������
            dis.close();
            dos.close();
        }
        catch (Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}