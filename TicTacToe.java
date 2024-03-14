package com.Java.TicTacToe;

//boxNum1,mark1 - "Entered by Player-1".     //boxNum2,mark2 - "Entered by Player-1".

import java.util.*;
class TicTacToe{
    static char Board[][];//2D Rectangular Array which takes Character 'X' or 'O' during runtime.
    static char mark1, mark2;//used to input 'X' or 'O' during Runtime.
    static int boxNum1 ,boxNum2; //used to input box numbers (1-9) during Runtime.
    public TicTacToe() {
        Board = new char[3][3];   //Constructor that initializes the Array
        initialize();  //Invoking the method named as 'initialize' which is mentioned below
    }

    //Initializing the Array of chars with 'numbers' (char type -- contains "/u0000"(unicode) by default)
    static void initialize() {
        int count = 1;          //count is used to count the box numbers as the loops starts to run(i.e Empty boxes are placed with numbers from 1-9)
        for (int i = 0; i < Board.length; i++) {
            for (int j = 0; j < Board[i].length; j++) {
              String s = String.valueOf(count);                 //Each counted number is converted into char type since the array is the char type.
              char ch = s.charAt(0);
                Board[i][j] = ch;                                //numbers which is char type are now placed within the array accordingly.
                count++;
            }
        }
    }



    //Method to Display the Board!! (2D-Array)
    static void dispBoard() {                                   //Each time when this method is invoked it will display the updated value entered by Players!!
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

    //Method to Place the player entered Marks over the Board!!  (Populating the 2D-Array!!)
    static void placeMark(int boxNum, char mark) {//This method is invoked each time in Player-1 and Player-2 sections if the players enters the valid details
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
        dispBoard();//After populating the 2D Array(Board) ,immediately displaying the Updated Board again.
        checkColWin();//After each entry checking for possible column wins.
        checkRowWin();//After each entry checking for possible row wins.
        checkDiagWin();//After each entry checking for possible diagonal wins.
    }



    //                                 For "Player-1" -- Method, if-else conditions, Exception handling and required method calls
    static void player1() {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.println("Player-1 Enter the Box Number and Mark :");
            boxNum1 = sc.nextInt();
            mark1 = sc.next().charAt(0);
        }
        catch (InputMismatchException e){      //Exception handled successfully that occurs when invalid input entered by the Player1!
            System.out.println("You've Entered Invalid Input");
        }

        if (boxNum1!=boxNum2 && mark1!=mark2 && boxNum1 >= 1 && boxNum1 <=9 && (mark1 == 'X' || mark1 == 'O'|| mark1 == 'x' || mark1 == 'o')) {
            placeMark(boxNum1, mark1);//Sending the Player-1 entered parameters to populate the Array(Board) only If the above condition satisfies.
        } else {
            System.out.println("Please Enter the Valid Details\n");
            player1();//If the above if-condition fails ,Giving Player1 another chance to enter.
        }
    }


    //                           For "Player-2" -- Method, if-else conditions, Exception handling and required method calls
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

        if( boxNum2 == boxNum1 || mark2 == mark1 ){//Here, the simple logic is when the player-2 entered MARK is equal to player-1 entered MARK, then this will display the error message.
            System.out.println("Sorry!! Box Number OR the Mark is Already taken by Player-1\n");
            player2();//Giving Player-2 another chance
        }

        //Verification before populating 2D Array (The Board) !!

        else if ( boxNum2>=1 && boxNum2<=9 && (mark2=='X' || mark2=='O' || mark2 == 'x' || mark2 == 'o') ) {  //If the above if-condition fails that means player-2 entered the unique details and hence here it comes for the verification of player-2 entered details
            placeMark(boxNum2, mark2);//Sending the Player-2 entered parameters to populate the Array(Board) only If the above else-if condition satisfies.
        }
        else {
            System.out.println("Please Enter the Valid Details\n");
            player2();//If the else-if condition fails ,Giving Player-2 Another chance to enter the details.
        }
    }


    //                                                  Checking Column-wise Win!
    static void checkColWin() {
        for (int j = 0; j < 3; j++) {//The logic is, if all the entered char's in the columns of the 2d_array are same then it declares the win and finally exit code is executed in this method.
            if (Board[0][j] == Board[1][j] && Board[1][j] == Board[2][j]) {
                System.out.println("Congratulations!! You've Won the GAME ");
                System.exit(0);   //To exit the Game After a Win... i.e The control exits the program Normally
            }
        }

    }
    //                                                  Checking Row-wise Win!!
    static void checkRowWin(){
        for(int i=0; i < 3; i++){
            if(Board[i][0]==Board[i][1] && Board[i][1]==Board[i][2] ){
                System.out.println("Congratulations!! You've Won the GAME ");
                System.exit(0);           //To exit the Game After a Win... i.e The control exits the program Normally
            }
        }
    }
    //                                                  Checking Diagonal Win!!
    static void checkDiagWin(){
        if(Board[0][0]==Board[1][1] && Board[1][1]==Board[2][2] ||Board[0][2]==Board[1][1] && Board[1][1]==Board[2][0]){
            System.out.println("Congratulations!! You've Won the GAME ");
            System.exit(0);            //To exit the Game After a Win... i.e The Control Exits the program Normally.
        }
    }

}
