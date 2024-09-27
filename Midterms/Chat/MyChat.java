package Midterms.Chat;

import java.util.*;
import java.io.*;

public class MyChat{
    static FileWriter writer;
    static File file = new File("chat.txt");
    static Scanner s = new Scanner(System.in);
    static String userInput;

    public static void main(String[] args) throws IOException{
        writer = new FileWriter(file, true); 
        System.out.print("Enter a message you want to send: ");
        userInput = s.nextLine();
        writer.write(userInput + '\n');
        writer.close();
    }
}