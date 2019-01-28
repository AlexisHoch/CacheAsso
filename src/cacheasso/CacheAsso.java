/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cacheasso;

/**
 *
 * @author pedago
 */
public class CacheAsso {
    
    private Case cases[][];
    private int nmbEntrees;
    private int succes;
    private int echecs;
    private int tailleBloc;
    private int n;
    
    public CacheAsso(int n, int nbE, int taille){
        //this.cases = new Case[(int)(Math.pow(2, n))];
        this.n = n;
        this.cases = new Case[(int)(Math.pow(2, n))][nbE];
        for(int i = 0; i< (int)(Math.pow(2, n)); i++){
            for(int j = 0; j<nbE; j++){
                this.cases[i][j]=new Case(-1, j+1);
            }
        }
        this.nmbEntrees = nbE;
        this.succes=0;
        this.echecs=0;
        this.tailleBloc = taille;
        
    
    }
    
    
    public int getSucces(){
        return this.succes;
    }
    
    public int getEchecs(){
        return this.echecs;
    }
    
    public void incrementSE(char c){
        if(c=='s'){
            this.succes+=1;
        }
        if(c=='e'){
            this.succes+=1;
        }
        else{
            System.out.println("Erreur d'incrémentation");
        }
    }
    
    
    public void addOctets(int octets){
        int ligne=(int) ((octets/this.tailleBloc)%Math.pow(2, this.n));
        int etiquette=(int) ((octets/this.tailleBloc)/Math.pow(2, this.n));
        //System.out.println("ligne : "+String.valueOf(ligne));
        //System.out.println("etiquette : "+String.valueOf(etiquette));
        
        
        
        int j = 0;
      
        while(j<nmbEntrees){
        
            if(this.cases[ligne][j].getEtiquette()!=etiquette){
                j+=1;
            }
            else{
                this.succes+=1;
                j=nmbEntrees+1;
            }
        }

        
        if(j==nmbEntrees){
            this.echecs+=1;
            for(int k = 0 ; k<nmbEntrees; k++){
                this.cases[ligne][k].incrementeLRU();
                
                if(this.cases[ligne][k].getLru()==nmbEntrees+1){
                    this.cases[ligne][k]=new Case(etiquette, 1);
                }
            }
        }
        
    }
}
