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
public class sudoku {
    public static void main (String[] args){
        int[][] tabella ={
            {8, 0, 0, 0, 0, 0, 1, 0, 0},
            {0, 4, 0, 0, 6, 0, 0, 0, 5},
            {0, 0, 0, 0, 0, 2, 0, 7, 0},
            {0, 5, 8, 0, 2, 0, 0, 0, 4},
            {0, 0, 0, 0, 0, 0, 0, 6, 2},
            {0, 7, 0, 3, 9, 0, 0, 0, 0},
            {0, 0, 0, 9, 0, 0, 0, 8, 0},
            {4, 0, 3, 0, 0, 0, 9, 0, 0},
            {2, 0, 0, 0, 1, 8, 0, 0, 0}         
        };

        SoluzioneBase sb = new SoluzioneBase(tabella);
        sb.soluzione();
        sb.printTabella();
    }
}
