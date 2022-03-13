package com.company;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 65500;
        try (Socket clientSocket = new Socket(host, port);
             BufferedReader in = new BufferedReader
                     (new InputStreamReader(clientSocket.getInputStream()));
             PrintWriter out = new PrintWriter(new OutputStreamWriter(clientSocket.getOutputStream()), true);
             Scanner scanner = new Scanner(System.in)) {
            String input;
            while (true) {
                System.out.println("Введите номер для расчета числа Фибоначчи, " +
                        "либо введите 'end' для выхода из программы");
                input = scanner.nextLine();
                out.println(input);
                if ("end".equals(input)) {
                    break;
                }
                System.out.println(in.readLine());
            }

        } catch (IOException e) {
            e.getMessage();
        }
    }

}
