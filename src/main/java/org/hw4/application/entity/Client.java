package org.hw4.application.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Client {
    private int id;

    private String name;

    @Override
    public String toString(){
        return String.format("User:\n\tid = %d\n\tname = %s\n", id, name);
    }
}
