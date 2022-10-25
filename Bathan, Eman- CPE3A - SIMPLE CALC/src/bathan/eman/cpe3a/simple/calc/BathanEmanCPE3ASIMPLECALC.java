
package bathan.eman.cpe3a.simple.calc;

import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.util.Scanner;

/**
 * CREATED BY: BATHAN, EMANUEL Q.
 * DESCRIPTION: CREATING A SIMPLE CALCULATOR PROGRAM
 * USING JOPTION
 */
public class BathanEmanCPE3ASIMPLECALC {
	public static void main(String args[]) {
            
                String choice;
                Scanner scanner = new Scanner(System.in);
                while (true){
		choice = JOptionPane.showInputDialog("""
                                                     WECOME TO MY SIMPLE CALCULATOR
                                                     
                                                     Before we start
                                                     
                                                     Please Choose an operation:
                                       
                                                      '+' Add
                                                      '-' Subtract
                                                      'x' Multiply
                                                      '/' Divide
                                                      'S' To find the squareroot
                                                      'E' Exit """);
                 
                
               try{
                   switch (choice) {
                        case "+":
                              String num1_add = 
                              JOptionPane.showInputDialog("Enter first number:");
                              String num2_add =
                              JOptionPane.showInputDialog("Enter Second number:");
                              JOptionPane.showMessageDialog(null,Integer.parseInt(num1_add) + Integer.parseInt(num2_add));
                                break;
                                
                        case "-":
                              String num1_minus = 
                              JOptionPane.showInputDialog("Enter first number:");
                              String num2_minus =
                              JOptionPane.showInputDialog("Enter Second number:");
                              JOptionPane.showMessageDialog(null, Integer.parseInt(num1_minus) - Integer.parseInt(num2_minus));
                              break;
                             
                        case "x":
                              String num1_mult =
                              JOptionPane.showInputDialog("Enter first number:");
                              String num2_mult =
                              JOptionPane.showInputDialog("Enter Second number:");
                              JOptionPane.showMessageDialog(null,Integer.parseInt(num1_mult) * Integer.parseInt(num2_mult));
                              break;
                             
                         case "/":
                              String num1_divide =
                              JOptionPane.showInputDialog("Enter first number:");
                              String num2_divide =
                              JOptionPane.showInputDialog("Enter Second number:");
                              JOptionPane.showMessageDialog(null, Integer.parseInt(num1_divide) / Integer.parseInt(num2_divide));         
                              break;
                        
                        case "S":   
                             String square =
                             JOptionPane.showInputDialog("Enter a Number that you want to square");
                             
                              int  root = Integer.parseInt(square);                             
                              JOptionPane.showMessageDialog(null, "Result: "+ Math.sqrt(root),
                         "Square Root", JOptionPane.PLAIN_MESSAGE); 
                               break;
                              
                        case "E":
                                JOptionPane.showMessageDialog(null,"THANK YOU FOR USING MY PROGRAM \n \n  THE PROGRAM IS SHUTTINGDOWN IN ....... ");
                                System.exit(0);
                                break;
                        default:
                           JOptionPane.showMessageDialog(null,"You Entered an invalid Input. \n Please try again, Thank you <3.");
                           break;
                    }
                   
                    }catch (NumberFormatException el){
                    ImageIcon Tryagain = new ImageIcon("https://media0.giphy.com/media/8VEcV7zZZzbjU0P5XT/200w.gif?cid=82a1493b3ye2jmaufawdydlg92fuxnqluvrt9afa62z1h48m&rid=200w.gif&ct=s");
                    JOptionPane.showMessageDialog(null, "You Entered an invalid Input. \n Please try again, Thank you <3.", "Display Image", JOptionPane.INFORMATION_MESSAGE, Tryagain);
                    scanner = new Scanner(System.in);
               }    
        }
        
    }
}
