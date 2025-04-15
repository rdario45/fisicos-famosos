package org.example.fisicosfamosos;

import java.util.List;

public class FisicoService {

    public static boolean includes(List<Fisico> fisicos, int i) {
        for( Fisico fisico : fisicos  ){
            if( fisico.getNacimientoAsInt() <= i && fisico.getMuerteAsInt() >= i){
                return true;
            }
        }
        return false;
    }

    public static void populate(List<Fisico> fisicos, String[] args) throws Exception {
        if(args.length == 0) {
            throw new Exception("no arguments");
        }
        for( String text : args ){
            String content = text.substring(1,text.length()-1);
            System.out.println(content);
            String[] fisicoArray = content.split(",");
            if(fisicoArray.length != 3){
                throw new Exception("cada registro debe tener 3 elementos");
            }
            Fisico fisico = new Fisico(fisicoArray[0], fisicoArray[1], fisicoArray[2]);
            fisicos.add(fisico);
        }
    }
}
