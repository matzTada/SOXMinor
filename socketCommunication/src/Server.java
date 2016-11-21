//https://www.qoosky.io/techs/f8c35bb5d7
//TCP/IP �T�[�o�[�T�C�h (2�悵�����ʂ�Ԃ��܂�)
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
            int port = Integer.parseInt(args[0]); //�T�[�o���̑Ҏ�|�[�g�ԍ�
            ServerSocket ss = new ServerSocket(port);

            while(true) {
                Socket s = ss.accept(); //�N���C�A���g����̒ʐM�J�n�v��������܂őҋ@

                // �ȉ��A�N���C�A���g����̗v��������
                InputStream is = s.getInputStream(); //�N���C�A���g���琔�l����M
                DataInputStream dis = new DataInputStream(is);
                int req = dis.readInt();

                OutputStream os = s.getOutputStream(); //��悵�����ʂ𑗐M
                DataOutputStream dos = new DataOutputStream(os);
                dos.writeInt(req*req);

                // �X�g���[�������
                dos.close();
                dis.close();
            }
        }
        catch(Exception e) {
            System.out.println("Exception: " + e);
        }
    }
}