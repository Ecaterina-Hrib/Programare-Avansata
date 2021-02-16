/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test1;

/**
 *
 * @author Khety
 */
public class Test1 {

    /**
     * @param nod
     * @param viz
     * @param adiacenta
     * @param n
     */
    public static void DFS(int nod, boolean viz[], int adiacenta[][], int n) {
        int p;
        viz[nod] = true;
        for (p = 1; p <= n; p++) {
            if (viz[p] == false && adiacenta[nod][p] == 1) {
                DFS(p, viz, adiacenta, n);
            }
        }

    }

    public static void main(String[] args) {

        System.out.println("Hello World");
        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        System.out.println(n);  //n-ul initial
//System.out.println(Integer.parseInt("10101",2));  
//System.out.println(Integer.parseInt("FF",16));  
        n = n * 3 + 0b10101 + 0xFF;
        n = n * 6;
        System.out.println(n);//n-ul final
        int sum = 0;
//suma initiala a cifrelor
        while (n != 0) {
            sum = sum + n % 10;
            n = n / 10;
        }
        int cr = 0;
//suma sumei
        while (sum >= 10) {
            while (sum != 0) {
                cr = cr + sum % 10;
                sum = sum / 10;
            }
            sum = cr;
        }
        System.out.println(sum);

        System.out.println("Willy-nilly, this semester I will learn " + languages[sum]);

//exercitiul 2
        //n-ul de la linia de comanda
        n = 0;
        if (args.length == 1) {
            int i = 0;
            if (args[0].matches("[0-9]+")) {
                i = Integer.parseInt(args[0]);
                if (i % 2 != 0) {
                    System.out.println("it s oki");
                    n = i;
                }
            }
        }
// matricea de adiacenta
        n = 7;
        int a[][] = new int[n + 1][n + 1];

        int i, j;
        for (i = 1; i <= n; i++) {
            for (j = i + 1; j <= n; j++) {
                double m = Math.random();
                if (m >= 0.5) {
                    a[i][j] = a[j][i] = 1;
                } 
            }
        }
//geometric form
        for (i = 1; i <= n; i++) {
            for (j = 1; j <= n; j++) {
                if (a[i][j] == 1) {
                    System.out.print("\u2B23");
                } else {
                    System.out.print("\u2B21");
                }
            }
            System.out.print("\n");
        }

        //componenta conexa
        int nr = 0;
        boolean v[] = new boolean[n + 1];
        for (i = 1; i <= n; i++) {
            if (v[i] == false) {
                DFS(i, v, a, n);
                nr++;
            }
        }
        System.out.print("Numarul de comp conexe: ");
        System.out.println(nr);

        //arbore partial
    }
}
