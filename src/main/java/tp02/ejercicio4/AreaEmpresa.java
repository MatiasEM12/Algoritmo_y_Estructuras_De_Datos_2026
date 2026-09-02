package tp02.ejercicio4;

import java.lang.invoke.StringConcatFactory;

public class AreaEmpresa {

    private String identificacion;
    private int tardanza;


    public AreaEmpresa(String identificacion, int tardanza) {
        this.identificacion = identificacion;
        this.tardanza = tardanza;
    }

    public int getTardanza(){
        return this.tardanza;
    }
}
