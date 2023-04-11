package com.ItsVeGa90.BackendXYZ.dto;

import lombok.Data;

@Data
public class clienteDTO {
    int idc;
    tipoidDTO tipoidc;
    String identificacionc;
    String nombrec;
    String ciudadc;
    String direccionc;
    String telefonoc;

    public int getIdc() {
        return idc;
    }

    public void setIdc(int idc) {
        this.idc = idc;
    }

    public tipoidDTO getTipoidc() {
        return tipoidc;
    }

    public void setTipoidc(tipoidDTO tipoidc) {
        this.tipoidc = tipoidc;
    }

    public String getIdentificacionc() {
        return identificacionc;
    }

    public void setIdentificacionc(String identificacionc) {
        this.identificacionc = identificacionc;
    }

    public String getNombrec() {
        return nombrec;
    }

    public void setNombrec(String nombrec) {
        this.nombrec = nombrec;
    }

    public String getCiudadc() {
        return ciudadc;
    }

    public void setCiudadc(String ciudadc) {
        this.ciudadc = ciudadc;
    }

    public String getDireccionc() {
        return direccionc;
    }

    public void setDireccionc(String direccionc) {
        this.direccionc = direccionc;
    }

    public String getTelefonoc() {
        return telefonoc;
    }

    public void setTelefonoc(String telefonoc) {
        this.telefonoc = telefonoc;
    }
}
