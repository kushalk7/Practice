package QLearning1;

import java.io.*;
import java.util.*;

public class tt {

    String s = "";
    public static void main(String[] args) {
    	String s = "";
        Stack stack = new Stack();
        Scanner in = new Scanner(System.in);
        int noOfSteps = in.nextInt();
        String[] steps = new String[noOfSteps];
        int k;
        for (int i=0 ; i < noOfSteps; i++) {
            steps[i] = in.nextLine();
        }
        for (int i=0 ; i < noOfSteps ; i ++ ) {
            String[] splits = steps[i].split(" ");
            switch(Integer.parseInt(splits[0])) {
                case 1: //Append
                        stack.add(s);
                        s = s.concat(splits[1]);
                        //stack.add(new Operation(1,splits[1]));
                        break;
                case 2:  //Delete
                        stack.add(s);
                        k = Integer.parseInt(splits[1]);
                        s = s.substring(0,s.length()-1-k);
                        //stack.add(new Operation(2,k));
                        break;
                case 3:  //Print
                        k = Integer.parseInt(splits[1]);
                        System.out.println(s.charAt(k));
                        break;
                case 4:  //Undo
                        //Operation opr = (Operation)stack.pop();
                        s = (String)stack.pop();
                        break;
            }   
        }
        
        
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
    } 
    /*
    class Operation {
        int opr;
        String args;
        public Operation(int o, String a) {
            this.opr = o;
            this.args = a;
        }
        public int getOpr() {
            return opr;
        }
        public String getArgs() {
            return args;
        }
    }*/
    
}