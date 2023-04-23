public class Main {
    public static void main(String[] args) {
        Ensemble ensemble = new Ensemble(2);
        ensemble.inserer(3);
        ensemble.inserer(5);
        System.out.println(ensemble.racine);
    }
}