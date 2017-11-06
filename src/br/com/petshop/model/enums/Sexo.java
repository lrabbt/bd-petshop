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

    public static Sexo qualSexo(String sexoString){
        if(sexoString.length() == 1){
            if(sexoString.toUpperCase().equals("M"))
                return Sexo.M;
            else if(sexoString.toUpperCase().equals("F"))
                return Sexo.F;
        }

        return null;
    }
}
