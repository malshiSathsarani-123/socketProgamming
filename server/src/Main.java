import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.zip.InflaterInputStream;

public class Main {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(3002);

            Socket socket = serverSocket.accept();
            System.out.println("Client Accepted");

            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String massage = "";
            String reply = "";

            while (!massage.equals("finish")){
                massage = dataInputStream.readUTF();
                System.out.println("client : "+massage);
                reply=bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
            }
            socket.close();
            serverSocket.close();
            dataOutputStream.close();
            dataInputStream.close();
            bufferedReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
