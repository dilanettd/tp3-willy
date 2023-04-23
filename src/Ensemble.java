package inf2120.tp3;

/**
 * Structure représentant un Ensemble de valeur entière.
 * Ces valeurs doivent être positives.  Le comportement de
 * la structure n'est pas définie pour des valeurs négatives.
 * Cette structure permet l'insertion et la suppression
 * d'élément.  Aussi, elle permet de consulter l'appartenance
 * d'un élément et le nombre d'élément contenu.
 *
 * Lorsque bien équilibré, cette structure effectue ces
 * tâche en O(log n).
 *
 * Lors de la construction, vous devez indiquer la taille
 * des noeuds (ratio).  Cette valeur est utilisé pour
 * déterminer le nombre d'enfant possible pour chaque noeud.
 *
 * Cette valeur influence les performances.  C'est la base du
 * logarithme pour l'algorithme de recherche.  Par contre, une
 * grande valeur va demander une plus grande utilisation de la
 * mémoire pour des ensembles de valeurs dispersées.
 */
public class Ensemble {
    protected NoeudAbstrait racine = null;

    public int nbValeur = 0;
    public int ratio = 0;

    /**
     * Constructeur.
     *
     * Ce constructeur construit un ensemble vide.
     * @param ratio Indique la taille maximum (nombre d'enfants)
     *              pour chaque noeud de l'arbre utilisé pour
     *              représenter l'ensemble.
     */
    public Ensemble( int ratio ) {
        this.ratio = ratio;
    }

    /**
     * Retourne le nombre d'élément qu'il y a dans l'ensemble.
     * @return la taille de l'ensemble.
     */
    public int getNbValeur() {
        return nbValeur;
    }

    /**
     * Ajoute un élément dans l'ensemble.
     *
     * Si cet élément n'était pas dans l'ensemble, il est
     * ajouté.  Sinon, l'ensemble n'est pas modifié.
     * @param element L'élément à ajouter.  L'élément ajouté
     *                ne doit pas être négatif.
     */
    public void inserer( int element ) {
    }

    /**
     * Supprime un élément de l'ensemble.
     *
     * Si cet élément était dans l'ensemble, alors il est
     * supprimé.  Sinon, l'ensemble n'est pas modifié.
     * @param element L'élément à supprimer.  L'élément
     *                supprimé ne doit pas être négatif.
     */
    public void supprimer( int element ) {
    }

    /**
     * Vérifie l'appartenance d'un élément à l'ensemble.
     *
     * @param element L'élément cible.  Ne doit pas être négatif.
     * @return true si l'élément est dans l'ensemble, false sinon.
     */
    public boolean appartient( int element ) {
        return false;
    }

    /**
     * Construit une représentantion 'pretty print' de l'ensemble.
     *
     * Cette représentation est en format XML.
     * @param jolie
     */
    public void jolieToString( JolieAffichage jolie ) {
        JolieAffichage.Element eEnsemble = new JolieAffichage.Element( "ensemble" );
        jolie.afficherElementDebut( eEnsemble,
                new JolieAffichage.Attribut( "ratio", "" + ratio ),
                new JolieAffichage.Attribut( "nbValeur", "" + nbValeur )
                );

        if( null != racine ) {
            racine.jolieToString( jolie );
        }

        jolie.afficherElementFin( eEnsemble );
    }

    @Override
    public String toString() {
        JolieAffichage jolie = new JolieAffichage();
        jolieToString( jolie );

        return jolie.resultat();
    }
}
