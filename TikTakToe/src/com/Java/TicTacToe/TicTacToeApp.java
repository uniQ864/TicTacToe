package com.Java.TicTacToe;

class TicTacToeApp{
    public static void main(String[] args) {
        new TicTacToe();//No need of creating the Object as all the methods are Static To execute the Constructor of TicTac class.
        TicTacToe.dispBoard();
        System.out.println("So..Before you Play kindly read the set of Rules :\n");
        System.out.println("1)There are totally 9 boxes are given to you");
        System.out.println("2)You Can't enter the Box number Beyond what is allocated to you");
        System.out.println("3)For One player either 'X' or 'O' is the MARK");
        System.out.println("4)Players not allowed to Enter the Box Number or MARK which is already taken by Another player\n");

        while(true){
            TicTacToe.player1();
            TicTacToe.player2();
        }
    }
}


