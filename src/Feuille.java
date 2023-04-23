package inf2120.tp3;

/**
 * Cette classe permet de contenir un élément de l'ensemble.
 */
class Feuille extends NoeudAbstrait {
    protected int element;

    public Feuille(int element) {
        this.element = element;
    }

    @Override
    public void jolieToString(JolieAffichage jolie) {
        jolie.afficherElementComplet(
                new JolieAffichage.Element("feuille"),
                new JolieAffichage.Attribut("element", "" + element)
        );
    }

    @Override
    public String toString() {
        JolieAffichage jolie = new JolieAffichage();
        jolieToString( jolie );

        return jolie.resultat();
    }
}
