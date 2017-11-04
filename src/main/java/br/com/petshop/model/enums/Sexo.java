package br.com.petshop.model.enums;

public enum Sexo {
    M("Macho"),
    F("Femea")
    ;

    private String sexo;

    Sexo(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }
}
