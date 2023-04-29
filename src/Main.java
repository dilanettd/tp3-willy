public class Main {
    public static void main(String[] args) {
        Ensemble ensemble = new Ensemble(2);
        ensemble.inserer(15);
        ensemble.inserer(34);
        ensemble.supprimer(34);
        ensemble.supprimer(15);
        System.out.println(ensemble.racine);
    }
}