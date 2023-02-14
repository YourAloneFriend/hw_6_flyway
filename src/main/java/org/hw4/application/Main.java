package org.hw4.application;

import org.hw4.application.service.ClientService;

public class Main {

    private static ClientService clientService = new ClientService();

    public static void main(String[] args) {
        System.out.println(clientService.create("Popovych"));
        System.out.println(clientService.getById(3));
        clientService.setName(4, "Grisha");
        clientService.deleteById(2);
        clientService.listAll().forEach(System.out::println);
    }
}
