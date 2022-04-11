package seminar.seminar1.g1058;

import java.util.DoubleSummaryStatistics;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        System.out.println("Seminar 1 1058.");
//        for (String arg:args){
//            System.out.print(arg+" ");
//        }
        int n = Integer.parseInt(args[0]), a = Integer.parseInt(args[1]), b = Integer.parseInt(args[2]);
        int[][] x = new int[n][n];
        for (int i = 0; i < n; i++) {
            x[i][i] = 1;
            for (int j = 0; j < i; j++) {
                x[i][j] = a;
                x[j][i] = b;
            }
        }
        for (int[] linie : x) {
            print(linie);
        }

        Scanner scanner = new Scanner(System.in);
        int numarGrupe = Integer.parseInt(scanner.nextLine().trim());
        int[] nrGrupe = new int[numarGrupe];
        int[][] note = new int[numarGrupe][];
        for (int i=0;i<numarGrupe;i++){
            String[] t = scanner.nextLine().split(",");
            nrGrupe[i] = Integer.parseInt(t[0].trim());
            int m = t.length-1;
            note[i] = new int[m];
            for (int j=0;j<m;j++){
                note[i][j] = Integer.parseInt(t[j+1].trim());
            }
        }

//        Sectiune completata in afara spatiului seminarului

//        System.out.println("Grupe:");
//        print(nrGrupe);
        System.out.println("Note si medii:");
        for (int i=0;i<note.length;i++){
            System.out.println(nrGrupe[i]+":");
            DoubleSummaryStatistics s = new DoubleSummaryStatistics();
            for (int nota:note[i]){
                System.out.print(nota+" ");
                s.accept(nota);
            }
            System.out.println("\n"+s.getAverage());
        }
    }

    private static void print(int[] v) {
        for (int i = 0; i < v.length - 1; i++) {
            System.out.print(v[i] + ",");
        }
        System.out.println(v[v.length - 1]);
    }
}
