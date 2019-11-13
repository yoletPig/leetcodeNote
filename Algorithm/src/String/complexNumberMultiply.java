package String;

public class complexNumberMultiply {
    public String complexNumberMultiply(String a, String b) {
        String[] Rea = a.split("\\+");
        String Simga = Rea[1].substring(0,Rea[1].length()-1);
        String[] Reb = b.split("\\+");
        String Simgb = Reb[1].substring(0,Reb[1].length()-1);
        int Re_a = Integer.parseInt(Rea[0]);
        int Re_b = Integer.parseInt(Reb[0]);
        int Img_a = Integer.parseInt(Simga);
        int Imag_b = Integer.parseInt(Simgb);
        return ((Re_a*Re_b)-(Img_a*Imag_b))+"+"+((Re_a*Imag_b)+(Re_b*Img_a))+"i";
    }

    public static void main(String[] args) {
        complexNumberMultiply cn = new complexNumberMultiply();
        System.out.println(cn.complexNumberMultiply("1+1i","1+1i"));
    }
}
