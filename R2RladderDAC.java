import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class R2RladderDAC {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.printf("%1s\n","===========================================" );
        System.out.printf("%1s\n","FUNDAMENTALS OF MIXED SIGNALS");
        System.out.printf("%1s\n","by: Caranzo, Donio, Esparagoza, Gonzaga");
        System.out.printf("%1s\n","ENCE3A | SY 2022-23");
        System.out.printf("%1s\n","===========================================" );

        System.out.printf("\n%1s","Enter Reference Voltage: ");
        double Vref = input.nextDouble();
        System.out.printf("%1s","Enter General Resistance: ");
        double R = input.nextDouble();
        System.out.printf("%1s","Enter Feedback Resistance: ");
        double Rf = input.nextDouble();

        System.out.printf("%1s","Enter Digital Input: ");
        String digital = input.next();


        double z = 0;
        double x = 1;
        double a = 2;
        double b = 4;
        double c = 8;
        double d = 16;

        double i2=0;
        switch (digital){
            case "0000" :
                i2 = 0;
                break;
            case "0001" :
                i2 = (z/a) + (z/b) + (z/c) + (x/d);
                break;
            case "0010" :
                i2 = ((z/a) + (z/b) + (x/c) + (z/d));
                break;
            case "0011" :
                i2 = ((z/a) + (z/b) + (x/c) + (x/d));
                break;
            case "0100" :
                i2 = ((z/a) + (x/b) + (z/c) + (z/d));
                break;
            case "0101" :
                i2 = ((z/a) + (x/b) + (z/c) + (x/d));
                break;
            case "0110" :
                i2 = ((z/a) + (x/b) + (x/c) + (z/d));
                break;
            case "0111" :
                i2 = ((z/a) + (x/b) + (x/c) + (x/d));
                break;
            case "1000" :
                i2 = ((x/a) + (z/b) + (z/c) + (z/d));
                break;
            case "1001" :
                i2 = ((x/a) + (z/b) + (z/c) + (x/d));
                break;
            case "1010" :
                i2 = ((x/a) + (z/b) + (x/c) + (z/d));
                break;
            case "1011" :
                i2 = ((x/a) + (z/b) + (x/c) + (x/d));
                break;
            case "1100" :
                i2 = ((x/a) + (x/b) + (z/c) + (z/d));
                break;
            case "1101" :
                i2 = ((x/a) + (x/b) + (z/c) + (x/d));
                break;
            case "1110" :
                i2 = ((x/a) + (x/b) + (x/c) + (z/d));
                break;
            case "1111" :
                i2 = ((x/a) + (x/b) + (x/c) + (x/d));
                break;
            default: break;
        }

        double vout_temp = -Vref*(Rf/R);
        double vout = vout_temp*(i2);

        System.out.println("Output Voltage: "+round(vout, 3));


        System.out.println("\nSEE FULL RESULTS HERE:");
        System.out.println("Binary          "+"Analog");
        System.out.println("0000           "+0+".000V");
        System.out.println("0001          "+round(vout_temp*((z/a) + (z/b) + (z/c) + (x/d)),3)+"V");
        System.out.println("0010          "+round(vout_temp*((z/a) + (z/b) + (x/c) + (z/d)),3)+"V");
        System.out.println("0011          "+round(vout_temp*((z/a) + (z/b) + (x/c) + (x/d)),3)+"V");
        System.out.println("0100          "+round(vout_temp*((z/a) + (x/b) + (z/c) + (z/d)),3)+"V");
        System.out.println("0101          "+round(vout_temp*((z/a) + (x/b) + (z/c) + (x/d)),3)+"V");
        System.out.println("0110          "+round(vout_temp*((z/a) + (x/b) + (x/c) + (z/d)),3)+"V");
        System.out.println("0111          "+round(vout_temp*((z/a) + (x/b) + (x/c) + (x/d)),3)+"V");
        System.out.println("1000          "+round(vout_temp*((x/a) + (z/b) + (z/c) + (z/d)),3)+"V");
        System.out.println("1001          "+round(vout_temp*((x/a) + (z/b) + (z/c) + (x/d)),3)+"V");
        System.out.println("1010          "+round(vout_temp*((x/a) + (z/b) + (x/c) + (z/d)),3)+"V");
        System.out.println("1011          "+round(vout_temp*((x/a) + (z/b) + (x/c) + (x/d)),3)+"V");
        System.out.println("1100          "+round(vout_temp*((x/a) + (x/b) + (z/c) + (z/d)),3)+"V");
        System.out.println("1101          "+round(vout_temp*((x/a) + (x/b) + (z/c) + (x/d)),3)+"V");
        System.out.println("1110          "+round(vout_temp*((x/a) + (x/b) + (x/c) + (z/d)),3)+"V");
        System.out.println("1111          "+round(vout_temp*((x/a) + (x/b) + (x/c) + (x/d)),3)+"V");


    }
    static double round(double value, int places) {
        if (places < 0)
            throw new IllegalArgumentException();
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
}
