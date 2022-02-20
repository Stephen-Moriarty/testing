import java.util.Scanner;
public class Maze{
    static Scanner k = new Scanner(System.in);
    public static void main(String[] args){
        //Scanner k = new Scanner(System.in);
        char[] controls = {'w','a','s','d'};
        
        char[][] pPos = new char[5][5];
        char[][] court = new char[5][5];
        char[][] newPos = new char[5][5];

        
        char player = 'p';
        final char goal = court[1][4];
        

        
        boolean atEnd = false;
        System.out.println("You are 'p'.");
        System.out.println("This is your field:");
        
        printCourt(court);
        printP(pPos);
        // printNew(newPos);
        
        
        do{
        fill(changeP(court,newPos),pPos);
        //findPos(pDecide(),controls,pPos);
        checkPEnd(atEnd,changeP(court, findPos(pDecide(), controls, pPos)),goal,pPos);
        }while(!atEnd);
        if(atEnd){
            System.out.println("You won");
        }
    }

    public static void fill(char[][] court, char[][] pPos){
        int x = 0;
        int y = 0;
        for(int i=0; i<court.length; i++){
            for(int j=0; j<court.length; j++){
                if(court[i][j]=='p'){
                    court[i][j]='p';
                }
                    court[i][j] = '|';
            }
        }
        for(int i=0; i<court.length; i++){
            for(int j=0; j<court.length; j++){
                System.out.print(court[i][j] + " ");
            }
            System.out.println("");
        }
        

    }

    /* 
    I need to figure out a way to make it where 
    the players can move but also keep track of where 
    the player is and where the player went.

    Maybe by making a position tracker 
    which brings back the postion back to "fill"
    which brings it back to the controls?
    */
    
    public static char pDecide(){
        char[] controls = {'w','a','s','d'};
        System.out.print("Where would you like to move?\n>");
        String choice = "0";
        char playerChoice = '0';
        choice = k.next();
        playerChoice = choice.charAt(0);
        // I will probably change this to a switch case later because in it's current state it is very ineficcient
        if (playerChoice == controls[3]){
            playerChoice = controls[3];
        }else if(playerChoice == controls[2]){
            playerChoice = controls[2];
        }else if(playerChoice == controls[1]){
            playerChoice = controls[1];
        }else if(playerChoice == controls[0]){
            playerChoice = controls[0];
        }else{
            System.out.println("Wrong!");
            pDecide();
        }
        return playerChoice;
    }
    //oldPos will be court and then new pos will be court plus direction
    public static char[][] findPos(char playerChoice, char[] controls, char[][] pPos){
        char[][] newPos = new char[5][5];
        int x = 0;
        int y = 0;
        if (playerChoice == controls[3]){
            //d
            //court is the one that changes in the END
            pPos[y][x++] = newPos[y][x];
            newPos[y][x] = 'p';
            pPos[y][x] = '0';
            //newPos[y][x] = player;
        }else if(playerChoice == controls[2]){
            //s
            newPos[y++][x] = newPos[y][x];
            newPos[y][x] = 'p';
            pPos[y][x] = '0';
        }else if(playerChoice == controls[1]){
            //a
            newPos[y][x--] = newPos[y][x];
            newPos[y][x] = 'p';
            pPos[y][x] = '0';
        }else if(playerChoice == controls[0]){
            //w
            newPos[y--][x] = newPos[y][x];
            newPos[y][x] = 'p';
            pPos[y][x] = '0';
        }else{
            pDecide();
        }
        return newPos;
    }

    public static char[][] changeP(char[][] court, char[][] newPos){
        int x = 0;
        int y = 0;
        for(int i=0; i<court.length; i++){
            for(int j=0; j<court.length; j++){
                if(newPos[i][j] == 'p'){
                    court[i][j] = newPos[i][j];
                    y=i;
                    x=j;
                }  
            }
        }
        for(int i=0; i<court.length; i++){
            for(int j=0; j<court.length; j++){
                System.out.print(court[i][j]);
            }
            System.out.println();
        }
        System.out.println(court.toString());
        return court;
    }

    //if(atEnd){System.out.println("You won.")}
    public static boolean checkPEnd(boolean atEnd, char[][] court, char goal, char[][] pPos){
        atEnd = false;
        int x = 0;
        int y = 0;
        for(int i=0; i<court.length; i++){
            for(int j=0; j<court.length; j++){
                if(court[i][j] == pPos[i][j]){
                    x=j;
                    y=i;
                }
            }
        }
        if(court[x][y] == goal){
            atEnd = true;
        }else{
            atEnd = false;
        }
        return atEnd;
    }
    
    //
    public static void printP(char[][] pPos){
        System.out.println("pPos");
        for(int i=0; i<pPos.length; i++){
            for(int j=0; j<pPos.length; j++){
                    pPos[i][j] = '0';
            }
        }
        for(int i=0; i<pPos.length; i++){
            for(int j=0; j<pPos.length; j++){
                System.out.print(pPos[i][j]);
            }
            System.out.println("");
        }
        
    }

    public static void printNew(char[][] newPos){
        System.out.println("newPos");
        for(int i=0; i<newPos.length; i++){
            for(int j=0; j<newPos.length; j++){
                newPos[i][j] = '0';
            }
        }
        for(int i=0; i<newPos.length; i++){
            for(int j=0; j<newPos.length; j++){
                System.out.print(newPos[i][j]);
            }
            System.out.println("");
        }
        
    }

    public static void printCourt(char[][] court){
        System.out.println("Court");
        for(int i=0; i<court.length; i++){
            for(int j=0; j<court.length; j++){
                    court[i][j] = '|';
            }
        }
        for(int i=0; i<court.length; i++){
            for(int j=0; j<court.length; j++){
                System.out.print(court[i][j]);
            }
            System.out.println("");
        }

    }
}