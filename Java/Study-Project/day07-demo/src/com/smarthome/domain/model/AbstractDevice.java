package com.smarthome.domain.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractDevice implements Device{
    private int id;
    private String name;
    private boolean status;

    @Override
    public void turn() {
        status = !status; // 切换状态
    }
}
