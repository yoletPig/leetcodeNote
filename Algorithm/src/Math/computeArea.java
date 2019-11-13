package Math;

/**
 * 223 矩形面积
 */
public class computeArea {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int S1 = (C-A)*(D-B);
        int S2 = (G-E)*(H-F);
        // System.out.println(S1+S2);
        int area = 0;
        //left
        if(A<E){
            //far away
            if (E>=C||B>=H||D<=F){
                area = S1+S2;
            }
            //insert
            else {
                boolean d = D>=F&&D<=H;
                boolean b = B>=F&&B<=H;
                //D in the range of right Rectangle
                if (d&&!b){
                    area = S1+S2-((C-E)*(D-F));
                    if (G<=C){
                        area = S1+S2-((G-E)*(D-F));
                    }
                }
                //B in the range of right Rectangle
                else if(b&&!d){
                    area = S1+S2-((C-E)*(H-B));
                    if (G <= C){
                        area = S1+S2-((G-E)*(H-B));
                    }
                }
                else if (b&&d){
                    if (C<=G)
                    {
                        area = S1+S2-((C-E)*(D-B));
                    }
                    else {
                        area = S1 + S2 - ((G-E) * (D-B));
                    }
                }
                else{
                    if (G<=C){
                        area = S1;
                    }
                    else {
                        area = S1+S2-((C-E)*(H-F));
                    }
                }
            }
        }
        //right
        else {
            if (A>=G||B>=H||D<=F){
                area = S1+S2;
            }
            else {
                //insert
                boolean d = D>=F&&D<=H;
                boolean b = B>=F&&B<=H;
                //D in the range of right Rectangle
                if (d&&!b){
                    area = S1+S2-((G-A)*(D-F));
                    if (C<=G){
                        area = S1+S2-((C-A)*(D-F));
                    }
                }
                //B in the range of right Rectangle
                else if(b&&!d){
                    area = S1+S2-((G-A)*(H-B));
                    if (C<=G){
                        area = S1+S2-((C-A)*(H-B));
                    }
                }
                //contain
                else if (b&&d){
                    if (C>G){
                        area = S1+S2-((G-A)*(D-B));
                    }
                    else {
                        area = S1+S2-((C-A)*(D-B));
                    }
                }
                else {
                    if (C<=G){
                        area = S1+S2-((C-A)*(H-F));
                    }
                    else
                    {
                        area = S1+S2-((G-A)*(H-F));
                    }
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        computeArea ca= new computeArea();
        System.out.println(ca.computeArea(-1500000001,0,-1500000000,1,1500000000,0,1500000001,1));
    }
}
