package serverPackage;

import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws IOException {
        ServerSocket serveurSocket=new ServerSocket();
        InetAddress ip=InetAddress.getByName("192.168.1.244");
        InetSocketAddress adresse=new InetSocketAddress(ip,1234);
        serveurSocket.bind(adresse);
        System.out.println("Je suis un serveur en attente la connexion d un client");
        Socket socket=serveurSocket.accept();
        System.out.println("un client est connecté");
        BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
        int nb;
        String op;
        int nb2;
        int res=0;
        do{
            nb =Integer.parseInt(bf.readLine());
            op=bf.readLine();
            nb2 =Integer.parseInt(bf.readLine());
            if(nb!=0){

                switch (op){
                    case "*":res=nb*nb2; break;
                    case "/":res=nb/nb2; break;
                    case "+":res=nb+nb2; break;
                    case "-":res=nb-nb2; break;

                }
                pw.println(res);
            }

        }while(nb!=0);
        socket.close();
        serveurSocket.close();
    }
}
