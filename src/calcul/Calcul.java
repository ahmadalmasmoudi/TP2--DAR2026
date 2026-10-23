package calcul;

import java.io.Serializable;

public class Calcul implements Serializable {
    public int nb1;
    public String op;
    public int nb2;
    public Calcul(int a,String b,int c){
        nb1=a;
        op=b;
        nb2=c;
    }
}
