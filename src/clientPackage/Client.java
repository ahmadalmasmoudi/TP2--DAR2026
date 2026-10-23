package clientPackage;
import calcul.Calcul;
import java.io.*;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("Je suis un client pas encore connecté…");
        InetAddress ip =InetAddress.getByName("192.168.1.244");
        InetSocketAddress adresse=new InetSocketAddress(ip,1234);
        Socket socket=new Socket();
        socket.connect(adresse);

        System.out.println("j' suis un client connecté");
        Scanner sc=new Scanner(System.in);
        ObjectOutputStream oos=new ObjectOutputStream(socket.getOutputStream());
        BufferedReader bf=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        int nb;
        String op;
        int nb2;
        int res;
        Calcul operation;
        do{
            nb=sc.nextInt();
            op=sc.next();
            nb2=sc.nextInt();
            operation=new Calcul(nb,op,nb2);
            oos.writeObject(operation);
            if(nb!=0){
                res=Integer.parseInt(bf.readLine());
                System.out.println("resultat: "+res);
            }

        }while(nb!=0);
        socket.close();
    }
}
