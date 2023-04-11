package com.ItsVeGa90.BackendXYZ.dto;

import lombok.Data;

@Data
public class especieDTO {

    int ide;
    String nombree;

    public int getIde() {
        return ide;
    }

    public void setIde(int ide) {
        this.ide = ide;
    }

    public String getNombree() {
        return nombree;
    }

    public void setNombree(String nombree) {
        this.nombree = nombree;
    }
}
