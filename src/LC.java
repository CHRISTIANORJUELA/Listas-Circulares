import javax.swing.*;
// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class LC {
    Nodo cab = null;
    Nodo fin = null;
    Nodo movil = null;

    public static void initWheel(LC lc) {
        Nodo nodo;
        for (int i = 0; i < 25; i++) {
            nodo = new Nodo();
            if (lc.cab == null) {
                lc.cab = nodo;
                lc.cab.ant = lc.fin;
                lc.cab.sig = lc.fin;
                lc.cab.cor = true;
                lc.fin = nodo;
                lc.fin.ant = lc.cab;
                lc.fin.sig = lc.cab;
            } else {
                nodo.ant = lc.fin;
                nodo.sig = lc.cab;
                lc.fin.sig = nodo;
                lc.fin = nodo;
            }
        }
    }


    public static void show(LC lc){
        lc.movil = lc.cab;
        int cont = 1;
        while (cont<=3){
            System.out.println("Carruzel "+lc.movil.id+(lc.movil.person?" tiene personas ":" No tiene personas "));
            lc.movil = lc.movil.sig;
            if (lc.movil.cor){
                System.out.println("Vuelta "+cont);
                cont++;
            }
        }
        resetLC(lc);
    }

    private static void resetLC(LC lc) {
        int contBack = 0;
        lc.movil = lc.cab;
        while (contBack<=1){
            lc.movil.person = false;
            if (lc.movil.cor){
                contBack++;
            }
            lc.movil = lc.movil.sig;
        }
    }


    public static void addPerson(LC lc){
        lc.movil = lc.cab;
        while (true){
            if (lc.movil.person==false){
                lc.movil.person = true;
                break;
            }
            lc.movil = lc.movil.sig;
        }
    }

    public static void main(String[] args) {
        LC lc = new LC();
        initWheel(lc);
        while (true){
            switch (JOptionPane.showInputDialog("1. Agregar personas a la rueda \n 2.Girar la rueda")){
                case "1":
                    addPerson(lc);
                    break;
                case "2":
                    show(lc);
                    break;
            }
        }
    }
}