import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class QuantizationDecoding {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.printf("%1s\n","===========================================" );
        System.out.printf("%1s\n","FUNDAMENTALS OF MIXED SIGNALS");
        System.out.printf("%1s\n","by: Caranzo, Donio, Esparagoza, Gonzaga");
        System.out.printf("%1s\n","ENCE3A | SY 2022-23");
        System.out.printf("%1s\n","===========================================" );

        System.out.printf("\n%1s","Enter vmin: ");
        double v_min = input.nextInt();
        System.out.printf("%1s","Enter vmax: ");
        double v_max = input.nextDouble();
        System.out.printf("%1s","Enter maximum bits: ");
        int max_bits = input.nextInt();

        //System.out.printf("%1s","Values t: ");
        //int max_bits = input.nextInt();


        double q_level = round(Math.pow(2, max_bits),3);
        double step_size = round((v_max-v_min)/q_level, 3);


        System.out.printf("\n%1s","Quantization Level: "+(int)q_level);
        System.out.printf("\n%1s","Step Size: "+step_size);
        System.out.printf("\n%1s","TABLE");
        System.out.printf("\n%1s\n","=================================" );
        System.out.printf("%1s%10s%9s\n", "Binary", "Voltage", "Level");
        System.out.printf("%1s\n","=================================" );

        System.out.printf("%1s%20s\n", toBinary(0, max_bits-1), round(v_min,3)+ "        "+0);
        for (int i = 1; i < q_level; i++){
            v_min = round(v_min+step_size, 3);
            System.out.printf("%1s%20s\n", toBinary(i, max_bits-1), v_min+ "        "+i);
        }
    }
    static String toBinary(int n, int f)    {
        for (int i = f; i >= 0; i--) {
            int k = n >> i;
            if ((k & 1) > 0)
                System.out.printf("1");
            else
                System.out.printf("0");
        }
        return "";
    }
    static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}