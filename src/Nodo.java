public class Nodo {

    static int contId;

    int id;
    boolean person;
    Nodo sig;
    Nodo ant;
    boolean cor;

    public Nodo(){
        contId++;
        this.id = contId;
        this.person = false;
    }



}
