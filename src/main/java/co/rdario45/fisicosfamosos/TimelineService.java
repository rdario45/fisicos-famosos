package co.rdario45.fisicosfamosos;

import java.util.ArrayList;
import java.util.List;

public class TimelineService {

    FisicosService fisicosService;

    public void fillTimeline(List<Fisico> fisicos) {
        Application.timeline = Application.timeline + "Año 0";
        for (int i = 0; i<2025; i++){

            if (i % 160 == 0) {
                Application.timeline = Application.timeline + "\n";
            }

            if( fisicosService.includes(fisicos, i) ){
                Application.timeline = Application.timeline + "+";
            } else {
                Application.timeline = Application.timeline + "_";
            }
        }
        Application.timeline = Application.timeline + "\nAño 2025";
        //Application.input = String.join("\n", args);
    }

}
