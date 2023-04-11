package com.ItsVeGa90.BackendXYZ.dto;

import lombok.Data;

@Data
public class tipoidDTO {

    int idt;
    String nombret;

    public int getIdt() {
        return idt;
    }

    public void setIdt(int idt) {
        this.idt = idt;
    }

    public String getNombret() {
        return nombret;
    }

    public void setNombret(String nombret) {
        this.nombret = nombret;
    }
}
