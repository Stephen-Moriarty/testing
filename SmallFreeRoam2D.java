import java.util.Scanner;
public class SmallFreeRoam2D {
    static Scanner k = new Scanner(System.in);
    public static void main(String[] args){
        char[][] matrix = new char[5][5];
        char cont[] = {'w','a','s','d'}; //The controls
        int[] p = {2,3};
        int[] g = {4,2};
        boolean atGoal = false;
        System.out.println("This \"game\" has regular keyboard controls w,a,s,d.");
        System.out.println("w=up, a=left, s=down, d=right.\n");
        //Field filler
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix.length; j++){
                matrix[i][j] = '0';
            }
        }
        do{
            
            //It is important to know the difference between 
            //the filler and the printer.
            //Which obviously I do not.
            //Filler
            for(int i=0; i<p.length; i++){
                for(int j=0; j<p.length; j++){
                    //I was hoping I could make this work with if else statements but it didn't come to fruition
                    //matrix[g[0]][g[1]] = 'g';//This is kind of cringe of me
                    if(i==matrix[g[0]][g[1]]){
                        matrix[i][j] = 'g';
                    }else if(i==p[0] || j==p[1]){
                        matrix[p[0]][p[1]] = 'p';
                    }else{
                        matrix[i][j] = '0';
                    }
                    
                    //matrix[i][j] = '0';
                    
                }
            }
            System.out.print("Your current postition is:(");
            //To show the "coordinates" of the player
            for(int i=0; i<p.length; i++){
                    System.out.print(p[i]);System.out.print(",");
            }
            System.out.print(") (y,x)");

            System.out.println();
            //Printer
            for(int i=0; i<matrix.length; i++){
                for(int j=0; j<matrix.length; j++){
                    System.out.print(matrix[i][j] + " ");
                }
                System.out.println();
            }
            
            System.out.println();
            //Prompt
            System.out.print("Where do you want to move\n>");
            String playChoice="0";
            playChoice = k.next();
            char move = '0';
            move = playChoice.charAt(0);

            System.out.println();
            //Keep player in bounds!
            if(p[0]<0){
                p[0]=0;
            }else if(p[1]<0){
                p[1]=0;
            }else if(p[0]==matrix.length){
                p[0]=matrix.length-1;
            }else if(p[1]==matrix.length){
                p[1]=matrix.length-1;
            }
            
            //Changing the player's position into new position and changing old position to "empty" field
            if(move==cont[0]){//w
                matrix[p[0]][p[1]] = '0';
                matrix[p[0]--][p[1]]= 'p';
            }else if(move==cont[1]){//a
                matrix[p[0]][p[1]] = '0';
                matrix[p[0]][p[1]--]= 'p';
            }else if(move==cont[2]){//s
                matrix[p[0]][p[1]] = '0';
                matrix[p[0]++][p[1]]= 'p';
            }else if(move==cont[3]){//d
                matrix[p[0]][p[1]] = '0';
                matrix[p[0]][p[1]++]= 'p';
            }else{
                System.out.println("I am sorry but that is not an option. :/");
            }

            if(p[0]==g[0]&&p[1]==g[1]){
                atGoal= true;
                System.out.println("You got to the goal.");
            }else{
                atGoal= false;
            }
        }while(!atGoal);
    }
}

