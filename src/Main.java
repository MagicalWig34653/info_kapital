import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanMain = new Scanner(System.in);
        System.out.println("Welches SparProgramm brauchen Sie (1 oder 2 oder 3) (Ob du richtig stehst siehst du wenn das Licht angeht!):");
        int auswahl = scanMain.nextInt();

        if (auswahl == 1) {
            kapital_1();
        } else if (auswahl == 2) {
            kapital_2();
        } else if (auswahl == 3) {
            kapital_3();
        } else {
            System.out.println("Error!");
        }
    }
    public static void kapital_1() {
        Scanner scan = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        System.out.println("Wie viel Kapital hast du: ");
        double kapital = scan.nextDouble();
        System.out.println("Wie viel Zinssatz (pro Monat, in %) hast du: ");
        double zinssatz = scan.nextDouble();
        System.out.println("Wie viel Laufzeit (in Monaten) hast du: ");
        int laufzeit = scan.nextInt();

        double zinssatzCalc = zinssatz / 100;
        
        double kapitalBra;

        for (int i = 0; i < laufzeit; i++) {
            kapitalBra = kapital * zinssatzCalc;
            kapital = kapital + kapitalBra;
        }
        System.out.println("Ihr kapital beträgt nun: " + decimalFormat.format(kapital) + " Euronen");
    }


    public static void kapital_2() {
        Scanner scan = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        System.out.println("Wie viel Kapital hast du: ");
        double kapital = scan.nextDouble();
        System.out.println("Wie viel Zinssatz (pro Monat, in %) hast du: ");
        double zinssatz = scan.nextDouble();
        System.out.println("Wie viel Endkapital hast du: ");
        double endkapital = scan.nextDouble();

        System.out.println("Ihre Laufzeit beträgt: " + Math.round(ln((endkapital/kapital)) / ln(1 + (zinssatz / 100))) + " Jahre!");


    }
    public static void kapital_3() {
        Scanner scan = new Scanner(System.in);
        DecimalFormat decimalFormat = new DecimalFormat("0.00");

        System.out.println("Wie viel Kapital hast du: ");
        double bringtZurBank = scan.nextDouble();
        System.out.println("Wie viel Zinssatz (pro Jahr, in %) hast du: ");
        double zinssatz = scan.nextDouble();
        double kapiCalc = 0;
        int jahren = 0;

        double zinssatzCalc = zinssatz / 100;
        double kapiReal = bringtZurBank;
        while (kapiReal <= (bringtZurBank * 2)) {
            kapiCalc = kapiReal * zinssatzCalc;
            kapiReal = kapiReal + kapiCalc;
            jahren++;
        }
        System.out.println("Sie müssen: " + jahren + " Jahre warten um ihr Kapi zu verdoppeln!!!!");

    }
    public static double ln(double x) {
        double log = 0.0D;
        double t = (x - 1.0D) / (x + 1.0D);
        for (int i = 0; i < 100; i++) {
            log += Math.pow(t, (2.0D * i + 1.0D)) / (2.0D * i + 1.0D);
        }
        log *= 2.0D;
        return log;
    }
}
