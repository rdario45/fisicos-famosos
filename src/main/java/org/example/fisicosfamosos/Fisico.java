package org.example.fisicosfamosos;

public class Fisico {

    String nombre;
    String nacimiento;
    String muerte;

    public Fisico(String s, String s1, String s2) {
        nombre = s;
        nacimiento = s1;
        muerte = s2;
    }

    @Override
    public String toString() {
        return "Fisico{" +
                "nombre='" + nombre + '\'' +
                ", nacimiento='" + nacimiento + '\'' +
                ", muerte='" + muerte + '\'' +
                '}';
    }

    public int getNacimientoAsInt(){
        return Integer.valueOf(nacimiento);
    }

    public int getMuerteAsInt() {
        return Integer.valueOf(muerte);
    }
}
