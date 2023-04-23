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
        if(this.nbValeur==0){
            this.racine = new Feuille(element);
            this.nbValeur++;
        }else if (this.nbValeur==1){
           Feuille feuille =  (Feuille) this.racine;
           int premierElement = feuille.getElement();
           if(premierElement!=element){
               Noeud noeud = new Noeud(this.ratio);
               noeud.getEnfants()[premierElement%this.ratio] = new Feuille(premierElement/this.ratio);
               noeud.getEnfants()[element%this.ratio] = new Feuille(element/this.ratio);
               this.racine = noeud;
               this.nbValeur++;
           }
        }else {
            Noeud noeud = (Noeud) this.racine;
            insertRecursive(element, noeud);
        }
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
        if(this.nbValeur>0){
            if (this.nbValeur==1){
                Feuille feuille =  (Feuille) this.racine;
                int premierElement = feuille.getElement();
                if(premierElement==element){
                    this.racine=null;
                    this.nbValeur--;
                }
            } else {
                Noeud noeud = (Noeud) this.racine;
                supprimerRecursive(element, noeud,null,-1);
                supprimerNoeudsNull( noeud,null,-1);
            }
        }
    }

    /**
     * Vérifie l'appartenance d'un élément à l'ensemble.
     *
     * @param element L'élément cible.  Ne doit pas être négatif.
     * @return true si l'élément est dans l'ensemble, false sinon.
     */
    public boolean appartient( int element ) {
        Boolean resultat = false;
        if (this.nbValeur>0 ) {
         if (this.nbValeur==1) {
             Feuille feuille = (Feuille) this.racine;
             int premierElement = feuille.getElement();
             if (premierElement == element) {
                 resultat = true;
             }
         }else {
                Noeud noeud = (Noeud) this.racine;
             resultat = rechercheRecursive(element,noeud);
            }

        }
        return resultat;
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

    /**
     * Cette methode vérifie si un noeud est plain
     * @param noeud Le noeud cible.
     * @param element à insérer.
     * @return true si l'indice est vide, false sinon.
     */

    public void insertRecursive(int element, Noeud noeud){
        NoeudAbstrait enfant  = noeud.getEnfants()[element%ratio];
        if (enfant == null) {
            noeud.getEnfants()[(element)%ratio] = new Feuille(element/this.ratio);
            this.nbValeur++;
        } else if (enfant instanceof Feuille) {
            Feuille feuille = (Feuille) noeud.getEnfants()[element%ratio];
           int  premierElement = feuille.getElement();
            if (premierElement == element/this.ratio) {
                return;
            } else {
                Noeud noeud1 = new Noeud(this.ratio);
                noeud1.getEnfants()[premierElement%this.ratio] =  new Feuille(premierElement/this.ratio);
                noeud1.getEnfants()[(element/this.ratio)%this.ratio] =  new Feuille(element/(this.ratio*this.ratio));
                noeud.getEnfants()[element%ratio]=noeud1;
                this.nbValeur++;
            }

        }else {
            insertRecursive(element/this.ratio, (Noeud) noeud.getEnfants()[element%ratio]);
        }
    }

    public Boolean rechercheRecursive(int element, Noeud noeud){
        Boolean resultat = false;
        NoeudAbstrait enfant  = noeud.getEnfants()[element%this.ratio];
        if (enfant != null) {
            if (enfant instanceof Feuille){
                Feuille feuille = (Feuille) enfant;
                if(feuille.getElement() == element/this.ratio){
                    return true;
                }
            } else if(enfant instanceof Noeud) {
                resultat = rechercheRecursive(element/this.ratio, (Noeud) enfant);
            }
        }
        return resultat;
    }


    private void supprimerRecursive(int element, Noeud noeud, Noeud parent,int index) {
        NoeudAbstrait enfant = noeud.getEnfants()[element%ratio];
        if (enfant instanceof Feuille) {
            Feuille feuille = (Feuille) enfant;
            if (feuille.getElement() == element/this.ratio) {
                noeud.getEnfants()[element%ratio] = null;
                nbValeur--;
                if (noeud.estVide()) {
                    if(parent!=null){
                        parent.getEnfants()[index]=null;
                    }
                }
            }
        } else {
            supprimerRecursive(element / this.ratio, (Noeud)  noeud.getEnfants()[element%this.ratio],noeud,element % this.ratio);
        }

    }

    public void supprimerNoeudsNull(Noeud noeud, Noeud parent, int index) {
        for (int i = 0; i < this.ratio; i++) {
            NoeudAbstrait enfant = noeud.getEnfants()[i];
            if (enfant instanceof Noeud) {
                supprimerNoeudsNull((Noeud) enfant, noeud, i);
            } else if (enfant == null) {
                noeud.getEnfants()[i] = null;
            }
        }
        if (noeud.estVide() && parent != null) {
            parent.getEnfants()[index] = null;
        }
    }

}
