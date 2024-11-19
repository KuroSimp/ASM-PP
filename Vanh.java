import java.util.ArrayList;

public class Vanh {
    public static void main(String[] args) {
        ArrayList<Double> Number = new ArrayList<Double>();
        Number.add(1.2);
        Number.add(3.4);
        Number.add(2.1);
        Number.add(2.1);
        double Total = 0;
        for(int i = 0;i < Number.size(); i++ ){
            Total += Number.get(i);
            

        }
        System.out.println(Total);
    }
}
