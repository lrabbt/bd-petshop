package br.com.petshop.model.pessoa.horario;

import java.util.Date;

public class Horario {
    private Date dataCompleta;
    
    public Horario() {
    	
    }
    public Horario(Date dataCompleta) {
        this.dataCompleta = dataCompleta;
    }

    public Date getDataCompleta() {
        return dataCompleta;
    }

    public void setDataCompleta(Date dataCompleta) {
        this.dataCompleta = dataCompleta;
    }
}
