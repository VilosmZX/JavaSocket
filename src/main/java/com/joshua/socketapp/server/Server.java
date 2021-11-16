package com.joshua.socketapp.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        InputStreamReader inputStreamReader = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;
        ServerSocket serverSocket = null;

        serverSocket = new ServerSocket(8080);
        while(true){
            socket = serverSocket.accept();

            inputStreamReader = new InputStreamReader(socket.getInputStream());
            outputStreamWriter = new OutputStreamWriter(socket.getOutputStream());
            bufferedReader = new BufferedReader(inputStreamReader);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            while(true){
                String msgFromClient = bufferedReader.readLine();
                System.out.println("Client: " + msgFromClient);
                bufferedWriter.write("Message received!");
                bufferedWriter.newLine();
                bufferedWriter.flush();

                if(msgFromClient.equalsIgnoreCase("exit")){
                    break;
                }
            }
            socket.close();
            inputStreamReader.close();
            outputStreamWriter.close();
            bufferedReader.close();
            bufferedWriter.close();


        }


    }
}
