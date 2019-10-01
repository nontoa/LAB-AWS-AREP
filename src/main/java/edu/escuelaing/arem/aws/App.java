/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.escuelaing.arem.aws;

import java.net.*;

/**
 *
 * @author Nicolas
 */
public class App {
    
    public static int numClientes =10; 
    public static URL url;
    
    public static void main(String[] args) throws Exception {       
        
        url = new URL ("https://proyectoarep.herokuapp.com/index.html");
        
        ClientThread[] hilos = new ClientThread[numClientes];
        
        for (int i=0;i<numClientes ; i++){
            hilos[i] = new ClientThread(url);
        }
        
        for (int i=0;i<numClientes ; i++){
            hilos[i].start();
        }
        
        for (int i=0;i<numClientes ; i++){
            hilos[i].join();
        }
        
        System.out.println("Finish");
    }
    
   
    
}
