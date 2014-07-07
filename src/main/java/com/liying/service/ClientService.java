package com.liying.service;


public class ClientService {
    
    private String name;
    
    private static ClientService clientService = new ClientService("test the factory method");
    private ClientService(String name) {
        this.name = name;
        
    }

    public static ClientService createInstance() {
      return clientService;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
    public static void main(String[] args) {
        System.setProperty("name", "liying");
        
       String name =  System.getProperty("name");
       System.out.println(System.getProperty("CONTEXT_PATH"));
    }
}


