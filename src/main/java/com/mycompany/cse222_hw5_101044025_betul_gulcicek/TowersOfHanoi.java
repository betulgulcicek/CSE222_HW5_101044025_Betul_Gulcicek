/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.cse222_hw5_101044025_betul_gulcicek;

/**
 *
 * @author BETUL
 */
import static java.lang.Math.pow;
import java.util.EmptyStackException;
import java.util.Stack;
import javax.swing.*;

/**
 * Class that solves Towers of Hanoi problem.
 *
 * @author Koffman and Wolfgang
 *
 */
public class TowersOfHanoi {

    Stack source;
    Stack destination;
    Stack auxiliary;
    int diskNum;

    public TowersOfHanoi() {
        source = new Stack();
        destination = new Stack();
        auxiliary = new Stack();
    }

    /**
     * Recursive method for "moving" disks. pre: startPeg, destPeg, tempPeg are
     * different.
     *
     * @param n is the number of disks
     * @param startPeg is the starting peg
     * @param destPeg is the destination peg
     * @param tempPeg is the temporary peg
     * @return A string with all the required disk moves
     */
    public String showMoves(int n, char startPeg,
            char destPeg, char tempPeg) {
        if (n == 1) {
            return "Move disk 1 from peg " + startPeg
                    + " to peg " + destPeg + "\n";
        } else { // Recursive step
            return showMoves(n - 1, startPeg, tempPeg, destPeg)
                    + "Move disk " + n + " from peg " + startPeg
                    + " to peg " + destPeg + "\n"
                    + showMoves(n - 1, tempPeg, destPeg, startPeg);
        }
    }

    /**
     *
     * 1. Calculate the total number of moves required i.e. "pow(2, n) - 1" here
     * n is number of disks.
     *
     * 2. If number of disks (i.e. n) is even then interchange destination pole
     * and auxiliary pole.
     *
     * 3. for i = 1 to total number of moves: if i%3 == 1: legal movement of top
     * disk between source pole and destination pole if i%3 == 2: legal movement
     * top disk between source pole and auxiliary pole if i%3 == 0: legal
     * movement top disk between auxiliary pole and destination pole
     */
    /**
     *
     * @param n
     * @param startPeg
     * @param destPeg
     * @param tempPeg
     * @return
     */
    public void showMovesIterative(int n, char startPeg, char destPeg, char tempPeg) {
        int movesNumber;
        movesNumber = (2 ^ n) - 1;
        char cTempPeg;
        // n even: destPeg ile tempPeg degisir
        if (n % 2 == 0) {
            cTempPeg = destPeg;
            destPeg = tempPeg;
            tempPeg = cTempPeg;
        }
        // source peg filling - buyuk disk altta olacak
        for (int i = n; i >= 1; i--) {

            source.push(i);
        }

        for (int i = 1; i <= movesNumber; i++) {

            //  legal movement top disk between auxiliary pole and destination pole 
            if (i % 3 == 0) //  moveDisksBetweenTwoPoles(aux, dest, a, d);
            {
                if (!auxiliary.empty() && !destination.empty()) {
                     changeDiskPeg(auxiliary, destination, tempPeg, destPeg);
                }
                else
                {
                    throw new EmptyStackException();
                }

            }
            // legal movement of top disk between source pole and destination pole
            if (i % 3 == 1) {
                if (!source.empty() && !destination.empty()) {
                     changeDiskPeg(source, destination, startPeg, destPeg);
                }
                else
                {
                    throw new EmptyStackException();
                }

            }
            // legal movement top disk between source pole and auxiliary pole	
            if (i % 3 == 2) {
                if (!source.empty() && !auxiliary.empty()) {
                     changeDiskPeg(source, auxiliary, startPeg, tempPeg);
                }
                else
                {
                    throw new EmptyStackException();
                }
            }

        }
        //return "dur bi";
    }

    public void changeDiskPeg(Stack source, Stack destination, char sourcePeg, char destPeg) {
        int sourceDisk, destDisk;
        sourceDisk = (int) source.pop();
        destDisk = (int) destination.pop();

        if (source.empty()) {
            source.push(destDisk);
             move(destDisk, destPeg, sourcePeg);
        } else if (destination.empty()) {
            source.push(sourceDisk);
             move(sourceDisk, sourcePeg, destPeg);
        } else if (sourceDisk > destDisk) {
            source.push(sourceDisk);
            source.push(destDisk);
             move(destDisk, destPeg, sourcePeg);
        } else {// sourceDisk < destDisk
            destination.push(destDisk);
            destination.push(sourceDisk);
             move(sourceDisk, sourcePeg, destPeg);
        }
    }

    public void move(int n, char startPeg, char destPeg) {
        //JOptionPane.showMessageDialog(null, 
        System.out.println(
                "Move disk " + n + " from peg " + startPeg
                + " to peg " + destPeg + "\n");
    }

}
