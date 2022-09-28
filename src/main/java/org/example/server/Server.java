package org.example.server;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT =10001;
    //private ServerSocket server;
    ServerSocket server = new ServerSocket(PORT, 5);
    private void run(){
        while (true){
            try{
                Socket socket = server.accept();
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private final Application application;

    public Server(Application application) {
        this.application = application;
    }

    public String handle(String requestString){
        Request request = RequestBuilder.build(requestString);
        Response response = this.application.handle(request);

        return response.toString();
    }

    /*private void run() {
        while (true) {
            try {
                Socket socket = server.accept();
                // TODO: Implement RequestHandler
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/
}
