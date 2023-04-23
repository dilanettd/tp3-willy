package inf2120.tp3;

/**
 * Cette classe contient l'information pour un Noeud.
 * Il permet de lier plusieurs enfants dans la structure.
 */
class Noeud extends NoeudAbstrait {
    protected NoeudAbstrait[] enfants;

    public Noeud(int ratio) {
        enfants = new NoeudAbstrait[ratio];
    }

    @Override
    public void jolieToString(JolieAffichage jolie) {
        JolieAffichage.Element eNoeud = new JolieAffichage.Element("noeud");
        JolieAffichage.Element eCase = new JolieAffichage.Element("case");
        jolie.afficherElementDebut(eNoeud);

        for (int i = 0; i < enfants.length; ++i) {
            jolie.afficherElementDebut(eCase,
                    new JolieAffichage.Attribut("i", "" + i)
            );
            if (null == enfants[i]) {
                jolie.afficherChaine("null");
            } else {
                enfants[i].jolieToString(jolie);
            }
            jolie.afficherElementFin(eCase);
        }

        jolie.afficherElementFin(eNoeud);
    }

    @Override
    public String toString() {
        JolieAffichage jolie = new JolieAffichage();
        jolieToString( jolie );

        return jolie.resultat();
    }
}
