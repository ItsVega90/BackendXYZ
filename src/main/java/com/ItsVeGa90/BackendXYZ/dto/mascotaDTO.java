package com.ItsVeGa90.BackendXYZ.dto;

import lombok.Data;

import java.sql.Date;

@Data
public class mascotaDTO {
    int idm;
    String nombrem;
    especieDTO especiem;
    String razam;
    Date fechanacimientom;
    Date fechaentradam;
    clienteDTO clientem;

    public int getIdm() {
        return idm;
    }

    public void setIdm(int idm) {
        this.idm = idm;
    }

    public String getNombrem() {
        return nombrem;
    }

    public void setNombrem(String nombrem) {
        this.nombrem = nombrem;
    }

    public especieDTO getEspeciem() {
        return especiem;
    }

    public void setEspeciem(especieDTO especiem) {
        this.especiem = especiem;
    }

    public String getRazam() {
        return razam;
    }

    public void setRazam(String razam) {
        this.razam = razam;
    }

    public Date getFechanacimientom() {
        return fechanacimientom;
    }

    public void setFechanacimientom(Date fechanacimientom) {
        this.fechanacimientom = fechanacimientom;
    }

    public Date getFechaentradam() {
        return fechaentradam;
    }

    public void setFechaentradam(Date fechaentradam) {
        this.fechaentradam = fechaentradam;
    }

    public clienteDTO getClientem() {
        return clientem;
    }

    public void setClientem(clienteDTO clientem) {
        this.clientem = clientem;
    }
}
