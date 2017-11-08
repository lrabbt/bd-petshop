package br.com.petshop.model.pessoa.horario;

import java.util.Date;

public class Horario {
    private int id;
    private Date dataCompleta;
    
    public Horario() {
    	
    }

    public Horario(int id, Date dataCompleta) {
        this.id = id;
        this.dataCompleta = dataCompleta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataCompleta() {
        return dataCompleta;
    }

    public void setDataCompleta(Date dataCompleta) {
        this.dataCompleta = dataCompleta;
    }
}
