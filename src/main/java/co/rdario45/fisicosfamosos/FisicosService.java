package co.rdario45.fisicosfamosos;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FisicosService {

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
        Pattern pattern = Pattern.compile("^(\\D*)\\((\\d{4}),(\\d{4})\\)$");

        for( String text : args ){
            Matcher matcher = pattern.matcher(text);
            while (matcher.find()) {
                System.out.println("group 1: " + matcher.group(1));
                System.out.println("group 2: " + matcher.group(2));
                System.out.println("group 3: " + matcher.group(3));
            }
            matcher.matches();
            fisicos.add(new Fisico(matcher.group(1), matcher.group(2), matcher.group(3)));
        }
    }

    public static void populateOne(List<Fisico> fisicos, String text) {
        Pattern pattern = Pattern.compile("^(\\D*)\\((\\d{4}),(\\d{4})\\)$");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println("group 1: " + matcher.group(1));
            System.out.println("group 2: " + matcher.group(2));
            System.out.println("group 3: " + matcher.group(3));
        }
        matcher.matches();
        fisicos.add(new Fisico(matcher.group(1), matcher.group(2), matcher.group(3)));
    }
}
