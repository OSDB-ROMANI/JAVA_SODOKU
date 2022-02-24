/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Paolo
 */
public class SoluzioneBase {
    private int[][] tabella;
    
    /**
     * Costruttore
     * @param tabella 
     */
    public SoluzioneBase(int[][] tabella){
        this.tabella = tabella;
    }

    /**
     * verifico se posso mettere il numero nel blocco (3x3)
     * @param num, numero da inserire 
     * @param rig riga della tabella 
     * @param col colonna della tabella 
     * @return true se può essere inserito 
     */
    private boolean verificaBlocco(int num, int rig, int col){
        //calcolo il blocco, %3 perche il blocco è 3x3
        int x = rig - rig%3;
        int y = col - col%3;
        
        for(int i = x; i < x+3; i++){
            for(int j = y; j < y+3; j++){
                if(tabella[i][j]==num){
                    return false;
                }
            }
        }
        return true; 
    }
    
    /**
     * @param num numero da controllare
     * @param rig riga di riferimento
     * @return true se possibile mettere num nella riga
     */
    private boolean verificaRiga(int num, int rig){
        for(int i = 0; i < tabella[rig].length; i++){
            if(tabella[rig][i]==num){
                return false;
            }
        }
        return true; 
    }
    
    /**
     * @param num numero da controllare
     * @param col colonna di riferimento
     * @return true se possibile mettere num nella riga
     */
    private boolean verificaColonna(int num, int col){
        for(int i = 0; i < tabella.length; i++){
            if(tabella[i][col]==num){
                return false;
            }
        }
        return true; 
    }
    
    /**
     * verifico se posso mettere il numero nel blocco (3x3), nella riga
     * e nella colonna
     * @param num, numero da inserire 
     * @param rig riga della tabella 
     * @param col colonna della tabella 
     * @return true se può essere inserito 
     */
    private boolean postoValido(int num, int rig, int col){
        return verificaBlocco(num,rig,col) && verificaRiga(num,rig) && verificaColonna(num,col); 
    }
    
    /**
     * Prova tutte le combinazioni possibili
     * @return true se è possa possibile 
     */
    public boolean soluzione(){
        for(int r = 0; r < tabella.length; r++){
            for(int c = 0; c < tabella[r].length; c++){
                //se la posizione è vuota
                if(tabella[r][c] == 0){
                    //provo ad inserire un numero sa 1 a 9
                    for(int i = 1; i <10; i++){
                        if(postoValido(i, r, c)){
                            tabella[r][c] = i;
                        if(soluzione())
                            return true;
                        else
                            //se non posso inserire il numero torno indietro e metto tutto a 0
                            tabella[r][c] = 0;
                        }
                    }
                    //se non posso inserire il numero
                    return false;
                }
            }
        }
        //se tutte le posizioni sono occupato, soluzione trovata.
        return true;
    }
    
    public void printTabella(){
        for(int riga = 0; riga < tabella.length; riga++){
            if(riga %3 == 0 && riga != 0)
                System.out.println("-----------");
            for(int col = 0; col < tabella[0].length; col++){
                if(col %3 == 0 && col != 0)
                    System.out.print("|");                
                System.out.print(tabella[riga][col]);
            }   
            System.out.println("");
        }
    }    

}
