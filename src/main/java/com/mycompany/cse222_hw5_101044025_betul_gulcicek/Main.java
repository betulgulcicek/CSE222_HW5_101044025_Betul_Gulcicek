package com.mycompany.cse222_hw5_101044025_betul_gulcicek;

import java.util.EmptyStackException;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author BETUL
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("***************************** PART 1 *****************************");
        TowersOfHanoi hanoi = new TowersOfHanoi();

        String nDisks = JOptionPane.showInputDialog("Enter number of disks");
        try {
            while (Integer.parseInt(nDisks) <= 0) {
                if(Integer.parseInt(nDisks) == 0)
                    JOptionPane.showMessageDialog(null, "There is no disk");
                else
                    JOptionPane.showMessageDialog(null, "Number of discs can not be smaller than 0");
                nDisks = JOptionPane.showInputDialog("Enter number of disks");
                
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "disk sayisi integer olmali" + e.getMessage());
            return;
        }
        String startPeg = JOptionPane.showInputDialog("Enter start peg (L, M, R)");
        char cStartPeg = startPeg.toUpperCase().charAt(0);
      /*  if (cStartPeg != 'L' || cStartPeg != 'M' || cStartPeg != 'R' || cStartPeg != 'l' || cStartPeg != 'm' || cStartPeg != 'r') {
            startPeg = JOptionPane.showInputDialog("Enter start peg (L, M, R)");
        }*/

        String destPeg = JOptionPane.showInputDialog("Enter destination peg "
                + "(L, M, R), "
                + "but not " + startPeg);
        char cDestPeg = destPeg.toUpperCase().charAt(0);
      /*  if (cDestPeg == cStartPeg || cDestPeg != 'L' || cDestPeg != 'M' || cDestPeg != 'R') {

            destPeg = JOptionPane.showInputDialog("Enter destination peg "
                    + "(L, M, R), "
                    + "but not " + startPeg);
        }*/
        String tempPeg = JOptionPane.showInputDialog("Enter temporary peg "
                + "(L, M, R), "
                + "but not " + startPeg
                + " or " + destPeg);
        char cTempPeg = tempPeg.toUpperCase().charAt(0);
       /* if (cTempPeg != 'L' || cTempPeg != 'M' || cTempPeg != 'R') {
            tempPeg = JOptionPane.showInputDialog("Enter temporary peg "
                    + "(L, M, R), "
                    + "but not " + startPeg
                    + " or " + destPeg);
        }*/
        /*String moves = */
        
        try{
        hanoi.showMovesIterative/*showMoves*/(Integer.parseInt(nDisks),
                        cStartPeg,
                        cDestPeg,
                        cTempPeg);
        }
        catch(EmptyStackException ex)
        {
            System.out.println("Stack is empty " + ex.getMessage());
            return;
        }
       // JOptionPane.showMessageDialog(null, moves);

    }

}

/**
 *
 * Part 2//:Hata olmalı bencede.Node classı private zaten yazmayız bu tip bişey.
 * Sayfa 271de de var zaten istenen method ??
 *
 *
 * Part 3 te list olarak return eden methodların listten extend edilmiş bir şey
 * döndermesi olabilir.(ArrayList gibi) Onun haricinde değişiklilk yapamazsınız.
 * Part2 için LinkedListRec wrapperı olarak yazdım ben,public olmasını unit
 * testiniz için istiyorum.
 */
