package com.Java.TicTacToe;

//boxNum1,mark1 - "Entered by Player-1".     //boxNum2,mark2 - "Entered by Player-1".

import java.util.*;
class TicTacToe{
    static char Board[][];//2D Rectangular Array which takes Character 'X' or 'O' during runtime.
    static char mark1, mark2;//To take 'X' or 'O' during Runtime.
    static int boxNum1 ,boxNum2; //To take box numbers (1-9) during Runtime.
    public TicTacToe() {
        Board = new char[3][3];   //Constructor that initializes the Array and Gives ' ' value instead of Default values
        initialize();
    }

    //Initializing the Array of chars with 'Space' coz it contains "/u0000"(unicode) by default.
    static void initialize() {
        int count = 1;
        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board[i].length; j++) {
              String s = String.valueOf(count);  char ch = s.charAt(0);
                Board[i][j] = ch;
                count++;
            }
        }
    }






    //To Display the Board!! (2D-Array)
    static void dispBoard() {                                                    //Each time when this method is invoked it will display the updated value entered by Players!!
        System.out.println("-------------");

        for (int i = 0; i < Board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < Board[i].length; j++) {
                System.out.print(Board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    //Placing the Marks over the Board!!  (Populating the 2D-Array!!)
    static void placeMark(int boxNum, char mark) {
        switch (boxNum) {
            case 1 -> Board[0][0] = mark;// The Symbol "->" is a part of Enhanced Switch statement introduced in Java-12 by using which we can avoid writing
            case 2 -> Board[0][1] = mark;// break keyword in each case.
            case 3 -> Board[0][2] = mark;
            case 4 -> Board[1][0] = mark;
            case 5 -> Board[1][1] = mark;
            case 6 -> Board[1][2] = mark;
            case 7 -> Board[2][0] = mark;
            case 8 -> Board[2][1] = mark;
            case 9 -> Board[2][2] = mark;
        }
        dispBoard();//After populating the 2D Array(Board) ,immediately displaying the Updated Board.
        checkColWin();//After each entry checking for possible wins.
        checkRowWin();
        checkDiagWin();
    }

    //                                                               " Player-1 "
    static void player1() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Player-1 Enter the Box Number and Mark :");
            boxNum1 = sc.nextInt();
            mark1 = sc.next().charAt(0);
        }
        catch (InputMismatchException e){                              //Exception handled successfully that occurs when invalid input entered by the Player1!!
            System.out.println("You've Entered Invalid Input");
        }
        if (boxNum1!=boxNum2 && mark1!=mark2 && boxNum1 >= 1 && boxNum1 <=9 && (mark1 == 'X' || mark1 == 'O'|| mark1 == 'x' || mark1 == 'o')) {
            placeMark(boxNum1, mark1);//Sending the Player-1 parameters to populate the Array(Board) only If the above condition satisfies.
        } else {
            System.out.println("Please Enter the Valid Details\n");
            player1();//If the condition fails ,Giving Player1 another chance.
        }
    }

    //                                                               " Player-2 "
    static void player2() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Player-2 Enter the Box Number and the Mark :");
            boxNum2 = sc.nextInt();
            mark2 = sc.next().charAt(0);
        }
        catch (InputMismatchException e){                              //Exception handled successfully that occurs when invalid input entered by the Player2!!
            System.out.println("You've Entered Invalid Input");
        }

        if( boxNum2 == boxNum1 || mark2 == mark1 ){
            System.out.println("Sorry!! Box Number OR the Mark is Already taken by Player-1");
            player2();//Giving Player1 another chance
        }

        //Verification before populating 2D Array (The Board) !!

        else if ( boxNum2>=1 && boxNum2<=9 && (mark2=='X' || mark2=='O' || mark2 == 'x' || mark2 == 'o') ) {
            placeMark(boxNum2, mark2);//Sending the Player-2 parameters to populate the Array(Board) only If the above condition satisfies.
        }
        else {
            System.out.println("Please Enter the Valid Details\n");
            player2();//If the condition fails ,Giving Player-2 Another chance.
        }
    }

    //                                                  Checking Column-wise Win!
    static void checkColWin() {
        for (int j = 0; j < 3; j++) {
            if (Board[0][j] != ' ' && Board[0][j] == Board[1][j] && Board[1][j] == Board[2][j]) {
                System.out.println("Congratulations!! You've Won the GAME ");
                System.exit(0);                             //To exit the Game After a Win... i.e The control exits the program Normally
            }
        }//for

    }
    //                                                  Checking Row-wise Win!!
    static void checkRowWin(){
        for(int i=0; i < 3; i++){
            if(Board[i][0]!= ' ' && Board[i][0]==Board[i][1] && Board[i][1]==Board[i][2] ){
                System.out.println("Congratulations!! You've Won the GAME ");
                System.exit(0);           //To exit the Game After a Win... i.e The control exits the program Normally
            }
        }//for
    }
    //                                                  Checking Diagonal Win!!
    static void checkDiagWin(){
        if(Board[0][0]!=' ' && Board[0][0]==Board[1][1] && Board[1][1]==Board[2][2] || Board[0][2]!=' ' && Board[0][2]==Board[1][1] && Board[1][1]==Board[2][0]){
            System.out.println("Congratulations!! You've Won the GAME ");
            System.exit(0);            //To exit the Game After a Win... i.e The Control Exits the program Normally.
        }
    }

}
