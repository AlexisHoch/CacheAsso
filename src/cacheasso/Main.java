/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacheasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author pedago
 */
public class Main {
    
    public static void main(String[] args) throws FileNotFoundException {
        int[] entrees = {2, 4};
        int[] nmbLignes = {3, 4, 5};
        
        for(int e:entrees){
            for(int l:nmbLignes){
                
                CacheAsso ca = new CacheAsso(l, e, 32);

                File file = new File("matrice10.txt");
                Scanner sc  = new Scanner(file);

                while(sc.hasNextLine()){
                    String ligne = sc.nextLine();
                    String[] splits = ligne.split(":");
                    int octets = Integer.parseInt(splits[0]);
                    //System.out.println("octets : "+String.valueOf(octets));
                    ca.addOctets(octets);
                }
                
                System.out.println("Nmb de lignes : "+String.valueOf(Math.pow(2, l)));
                System.out.println("Nmb d'entrees :"+String.valueOf(e));
                System.out.println("Succes : "+String.valueOf(ca.getSucces()));
                System.out.println("Echecs : "+String.valueOf(ca.getEchecs()));
            }
        }
        
    }
    
}
