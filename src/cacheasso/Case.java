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
public class Case {
    
    private int etiquette;
    private int lru;
    
    public Case(int e, int lru){
        this.etiquette = e ;
        this.lru = lru;
    }
    
    
    public int getEtiquette(){
        return this.etiquette;
    }
    
    public int getLru(){
        return this.lru;
    }
    
    public void incrementeLRU(){
        this.lru+=1;
    }
}
