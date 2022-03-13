package com.company;

import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        int port = 65500;
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true) {
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String input = in.readLine();
                while (input != null) {
                    if ("end".equals(input)) {
                        serverSocket.close();
                        out.println("Сервер закрыт");
                        break;
                    } else {
                        try {
                            int number = Integer.parseInt(input.trim());
                            out.println("Число - " + fiboCalculate(number));
                        } catch (NumberFormatException e) {
                            out.println("Повторите ввод");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public static String fiboCalculate (int number) {
        int n0 = 1;
        int n1 = 1;
        int n2 = 0;
        for(int i = 3; i <= number; i++){
            n2 = n0 + n1;
            n0 = n1;
            n1 = n2;
        }
        return String.valueOf("N-ное число Фибоначчи - " + n2);
    }
}
