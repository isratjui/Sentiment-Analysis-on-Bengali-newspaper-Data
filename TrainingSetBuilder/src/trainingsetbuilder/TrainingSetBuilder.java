/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trainingsetbuilder;

import java.util.Scanner;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author jui
 */
public class TrainingSetBuilder {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Please Do not close the program while it's running.\nEnter e to exit the Program",
                "Warning",
                JOptionPane.WARNING_MESSAGE);
        System.out.println("Welcome to the Training Set Buider.");
        System.out.println("A sentence (tweet) will be showed in the interaction pane.");
        System.out.println("If you think the sentence is positive, enter '+'");
        System.out.println("If you think the sentence is negative, enter '-'");
        System.out.println("If you think the sentence is neutral, enter '0'");
        System.out.println("If you enter otherwise, the program will get stopped.");
        System.out.println("--------------------------------------------------------------\n\n");

        File f = new File("output1.txt");
        if (f.exists() && !f.isDirectory()) {

        } else {
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output1.txt")));
        }

        try {
            BufferedReader br = new BufferedReader(new FileReader(new File("input1.txt")));
            BufferedWriter bw = new BufferedWriter(new FileWriter(new File("output2.txt")));
            BufferedReader br1 = new BufferedReader(new FileReader(new File("output1.txt")));

            for (String s1 = br1.readLine(); s1 != null; s1 = br1.readLine()) {
                String s = br.readLine();
                bw.write(s1);
                bw.newLine();
                bw.flush();
            }

            main:
            for (String s = br.readLine(); s != null; s = br.readLine()) {
                
                System.out.println(s);

                String sentiment = sc.nextLine();
                if (sentiment.equals("e") || sentiment.equals("")) {

                    BufferedWriter bw1 = new BufferedWriter(new FileWriter(new File("output1.txt")));
                    BufferedReader br2 = new BufferedReader(new FileReader(new File("output2.txt")));

                    for (String ss = br2.readLine(); ss != null; ss = br2.readLine()) {
                        bw1.write(ss);
                        bw1.newLine();
                        bw1.flush();
                    }

                    bw.flush();
                    System.exit(0);
                }

                switch (sentiment) {
                    case "+":
                        bw.write("|positive|,|"+s);
                        
                        bw.write("|");
                        bw.newLine();
                        bw.flush();
                        break;
                    case "-":
                        bw.write("|negative|,|"+s);
                        
                        bw.write("|");
                        bw.newLine();
                        bw.flush();
                        break;
                    case "0":
                        bw.write("|neutral|,|"+s);

                        bw.write("|");
                        bw.newLine();
                        bw.flush();
                        break;

                    /*case "e":
                            bw.flush();
                            break main;*/
                    default:
                        bw.flush();
                        break main;
                }
            }

            BufferedWriter bw1 = new BufferedWriter(new FileWriter(new File("output1.txt")));
            BufferedReader br2 = new BufferedReader(new FileReader(new File("output2.txt")));

            for (String s = br2.readLine(); s != null; s = br2.readLine()) {
                bw1.write(s);
                bw1.newLine();
                bw1.flush();
            }
        } catch (Exception e) {
            System.out.println("File read/write failed.");
        }
    }
}
