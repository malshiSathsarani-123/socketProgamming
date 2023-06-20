import java.io.*;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        try {
           Socket socket=new Socket("localhost",3002);

            DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
            DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

            String massage = "";
            String reply = "";

            while (!massage.equals("finish")){
                reply=bufferedReader.readLine();
                dataOutputStream.writeUTF(reply);
                dataOutputStream.flush();
                massage = dataInputStream.readUTF();
                System.out.println("Server : "+massage);
            }
            socket.close();
            dataOutputStream.close();
            dataInputStream.close();
            bufferedReader.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
