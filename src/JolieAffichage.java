package inf2120.tp3;

public class JolieAffichage {
    public record Attribut ( String nom, String valeur ) {}
    public record Element ( String nom ) {}
    private String resultat;
    private static final String INDENTATION = "    ";
    private int nbTab;

    public JolieAffichage() {
        resultat = "";
    }

    public String resultat() {
        return resultat;
    }

    public void afficherElementComplet( Element e, Attribut ... ta ) {
        afficherEnteteElement(e, ta);
        resultat += "/>\n";
    }

    public void afficherElementDebut( Element e, Attribut ... ta ) {
        afficherEnteteElement(e, ta);
        resultat += ">\n";
        ++ nbTab;
    }

    public void afficherElementFin( Element e ) {
        -- nbTab;
        indenter();
        resultat += "</" + e.nom() + ">\n";
    }

    public void afficherChaine( String s ) {
        indenter();
        resultat += s + "\n";
    }

    private void afficherEnteteElement(Element e, Attribut[] ta) {
        indenter();
        resultat += "<" + e.nom();
        for( Attribut a : ta) {
            resultat += " " + a.nom() + "=\"";
            resultat += a.valeur() + "\"";
        }
    }

    private void indenter() {
        for( int i = 0; i < nbTab; ++ i ) {
            resultat += INDENTATION;
        }
    }
}
