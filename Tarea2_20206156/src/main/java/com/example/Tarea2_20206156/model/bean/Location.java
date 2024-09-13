
package com.example.Tarea2_20206156.model.bean;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Location {

    private int locationId;
    private String locationCity;
    private String locationAddress;

    @Override
    public String toString(){
        return locationCity;
    }



}