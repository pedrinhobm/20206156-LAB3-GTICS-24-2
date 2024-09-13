
package com.example.Tarea2_20206156.model.bean;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class Department {

    private int departmentId;

    private String departName;
    private Location location;

    @Override
    public String toString(){
        return departName;
    }


}
