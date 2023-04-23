import static org.junit.jupiter.api.Assertions.*;

public class EnsembleTests {
    @org.junit.jupiter.api.Test
    void inserer0() {
        Ensemble e = new Ensemble( 2 );

        assertEquals( 0, e.nbValeur );
        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"0\">\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void inserer1() {
        Ensemble e = new Ensemble( 2 );

        e.inserer( 33 );

        assertEquals( 1, e.nbValeur );
        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"1\">\n" +
                "    <feuille element=\"33\"/>\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void inserer2() {
        Ensemble e = new Ensemble( 2 );

        e.inserer( 3 );
        e.inserer( 3 );

        assertEquals( 1, e.nbValeur );
        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"1\">\n" +
                "    <feuille element=\"3\"/>\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void inserer3() {
        Ensemble e = new Ensemble( 2 );

        e.inserer( 3 );
        e.inserer( 4 );

        assertEquals( 2, e.nbValeur );
        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"2\">\n" +
                "    <noeud>\n" +
                "        <case i=\"0\">\n" +
                "            <feuille element=\"2\"/>\n" +
                "        </case>\n" +
                "        <case i=\"1\">\n" +
                "            <feuille element=\"1\"/>\n" +
                "        </case>\n" +
                "    </noeud>\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void inserer4() {
        Ensemble e = new Ensemble( 2 );

        e.inserer( 3 );
        e.inserer( 4 );
        e.inserer( 4 );
        e.inserer( 3 );

        assertEquals( 2, e.nbValeur );
        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"2\">\n" +
                "    <noeud>\n" +
                "        <case i=\"0\">\n" +
                "            <feuille element=\"2\"/>\n" +
                "        </case>\n" +
                "        <case i=\"1\">\n" +
                "            <feuille element=\"1\"/>\n" +
                "        </case>\n" +
                "    </noeud>\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void inserer5() {
        Ensemble e = new Ensemble( 2 );

        e.inserer( 3 );
        e.inserer( 5 );

        assertEquals( 2, e.nbValeur );
        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"2\">\n" +
                "    <noeud>\n" +
                "        <case i=\"0\">\n" +
                "            null\n" +
                "        </case>\n" +
                "        <case i=\"1\">\n" +
                "            <noeud>\n" +
                "                <case i=\"0\">\n" +
                "                    <feuille element=\"1\"/>\n" +
                "                </case>\n" +
                "                <case i=\"1\">\n" +
                "                    <feuille element=\"0\"/>\n" +
                "                </case>\n" +
                "            </noeud>\n" +
                "        </case>\n" +
                "    </noeud>\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void inserer6() {
        Ensemble e = new Ensemble( 2 );

        e.inserer( 3 );
        e.inserer( 5 );
        e.inserer( 8 );

        assertEquals( 3, e.nbValeur );
        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"3\">\n" +
                "    <noeud>\n" +
                "        <case i=\"0\">\n" +
                "            <feuille element=\"4\"/>\n" +
                "        </case>\n" +
                "        <case i=\"1\">\n" +
                "            <noeud>\n" +
                "                <case i=\"0\">\n" +
                "                    <feuille element=\"1\"/>\n" +
                "                </case>\n" +
                "                <case i=\"1\">\n" +
                "                    <feuille element=\"0\"/>\n" +
                "                </case>\n" +
                "            </noeud>\n" +
                "        </case>\n" +
                "    </noeud>\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void inserer7() {
        Ensemble e = new Ensemble( 2 );

        e.inserer( 8 );
        e.inserer( 16 );

        assertEquals( 2, e.nbValeur );
        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"2\">\n" +
                "    <noeud>\n" +
                "        <case i=\"0\">\n" +
                "            <noeud>\n" +
                "                <case i=\"0\">\n" +
                "                    <noeud>\n" +
                "                        <case i=\"0\">\n" +
                "                            <noeud>\n" +
                "                                <case i=\"0\">\n" +
                "                                    <feuille element=\"1\"/>\n" +
                "                                </case>\n" +
                "                                <case i=\"1\">\n" +
                "                                    <feuille element=\"0\"/>\n" +
                "                                </case>\n" +
                "                            </noeud>\n" +
                "                        </case>\n" +
                "                        <case i=\"1\">\n" +
                "                            null\n" +
                "                        </case>\n" +
                "                    </noeud>\n" +
                "                </case>\n" +
                "                <case i=\"1\">\n" +
                "                    null\n" +
                "                </case>\n" +
                "            </noeud>\n" +
                "        </case>\n" +
                "        <case i=\"1\">\n" +
                "            null\n" +
                "        </case>\n" +
                "    </noeud>\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void inserer8() {
        Ensemble e = new Ensemble( 4 );

        e.inserer( 90 );
        e.inserer( 29 );
        e.inserer( 50 );

        assertEquals( 3, e.nbValeur );
        assertEquals( "<ensemble ratio=\"4\" nbValeur=\"3\">\n" +
                "    <noeud>\n" +
                "        <case i=\"0\">\n" +
                "            null\n" +
                "        </case>\n" +
                "        <case i=\"1\">\n" +
                "            <feuille element=\"7\"/>\n" +
                "        </case>\n" +
                "        <case i=\"2\">\n" +
                "            <noeud>\n" +
                "                <case i=\"0\">\n" +
                "                    <feuille element=\"3\"/>\n" +
                "                </case>\n" +
                "                <case i=\"1\">\n" +
                "                    null\n" +
                "                </case>\n" +
                "                <case i=\"2\">\n" +
                "                    <feuille element=\"5\"/>\n" +
                "                </case>\n" +
                "                <case i=\"3\">\n" +
                "                    null\n" +
                "                </case>\n" +
                "            </noeud>\n" +
                "        </case>\n" +
                "        <case i=\"3\">\n" +
                "            null\n" +
                "        </case>\n" +
                "    </noeud>\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void inserer9() {
        Ensemble e = new Ensemble( 7 );

        e.inserer( 0 );
        e.inserer( 1 );
        e.inserer( 2 );
        e.inserer( 3 );
        e.inserer( 4 );
        e.inserer( 5 );
        e.inserer( 6 );

        assertEquals( 7, e.nbValeur );
        assertEquals( "<ensemble ratio=\"7\" nbValeur=\"7\">\n" +
                "    <noeud>\n" +
                "        <case i=\"0\">\n" +
                "            <feuille element=\"0\"/>\n" +
                "        </case>\n" +
                "        <case i=\"1\">\n" +
                "            <feuille element=\"0\"/>\n" +
                "        </case>\n" +
                "        <case i=\"2\">\n" +
                "            <feuille element=\"0\"/>\n" +
                "        </case>\n" +
                "        <case i=\"3\">\n" +
                "            <feuille element=\"0\"/>\n" +
                "        </case>\n" +
                "        <case i=\"4\">\n" +
                "            <feuille element=\"0\"/>\n" +
                "        </case>\n" +
                "        <case i=\"5\">\n" +
                "            <feuille element=\"0\"/>\n" +
                "        </case>\n" +
                "        <case i=\"6\">\n" +
                "            <feuille element=\"0\"/>\n" +
                "        </case>\n" +
                "    </noeud>\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void appartient0() {
        Ensemble e = new Ensemble( 2 );

        assertFalse( e.appartient( 6 ) );
    }

    @org.junit.jupiter.api.Test
    void appartient1() {
        Ensemble e = new Ensemble( 2 );

        e.inserer( 45 );

        assertFalse( e.appartient( 8 ) );
        assertTrue( e.appartient( 45 ) );
    }

    @org.junit.jupiter.api.Test
    void appartient2() {
        Ensemble e = new Ensemble( 2 );

        e.inserer( 23 );
        e.inserer( 24 );

        assertFalse( e.appartient( 9 ) );
        assertTrue( e.appartient( 23 ) );
        assertTrue( e.appartient( 24 ) );
    }

    @org.junit.jupiter.api.Test
    void appartient3() {
        Ensemble e = new Ensemble( 2 );

        e.inserer( 8 );
        e.inserer( 16 );

        assertFalse( e.appartient( 4 ) );
        assertTrue( e.appartient( 8 ) );
        assertTrue( e.appartient( 16 ) );
        assertFalse( e.appartient( 32 ) );
    }

    @org.junit.jupiter.api.Test
    void appartient4() {
        Ensemble e = new Ensemble( 2 );

        e.inserer( 8 );
        e.inserer( 9 );
        e.inserer( 5 );

        assertFalse( e.appartient( 3 ) );
        assertTrue( e.appartient( 8 ) );
        assertTrue( e.appartient( 9 ) );
        assertTrue( e.appartient( 5 ) );
    }

    @org.junit.jupiter.api.Test
    void appartient5() {
        Ensemble e = new Ensemble( 4 );

        e.inserer( 50 );
        e.inserer( 29 );
        e.inserer( 90 );

        assertFalse( e.appartient( 30 ) );
        assertTrue( e.appartient( 90 ) );
        assertTrue( e.appartient( 29 ) );
        assertTrue( e.appartient( 50 ) );
    }

    @org.junit.jupiter.api.Test
    void appartient6() {
        Ensemble e = new Ensemble( 11 );

        e.inserer( 1 );
        e.inserer( 2 );
        e.inserer( 3 );
        e.inserer( 4 );
        e.inserer( 5 );
        e.inserer( 6 );
        e.inserer( 7 );
        e.inserer( 8 );
        e.inserer( 9 );
        e.inserer( 10 );
        e.inserer( 11 );

        assertFalse( e.appartient( 0 ) );
        assertFalse( e.appartient( 12 ) );
        assertTrue( e.appartient( 1 ) );
        assertTrue( e.appartient( 2 ) );
        assertTrue( e.appartient( 3 ) );
        assertTrue( e.appartient( 4 ) );
        assertTrue( e.appartient( 5 ) );
        assertTrue( e.appartient( 6 ) );
        assertTrue( e.appartient( 7 ) );
        assertTrue( e.appartient( 8 ) );
        assertTrue( e.appartient( 9 ) );
        assertTrue( e.appartient( 10 ) );
        assertTrue( e.appartient( 11 ) );
    }

    @org.junit.jupiter.api.Test
    void supprimer0() {
        Ensemble e = new Ensemble(2);

        e.supprimer( 5 );

        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"0\">\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void supprimer1() {
        Ensemble e = new Ensemble(2);

        e.inserer( 21 );

        e.supprimer( 21 );

        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"0\">\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void supprimer2() {
        Ensemble e = new Ensemble(2);

        e.inserer( 23 );
        e.inserer( 14 );

        e.supprimer( 23 );

        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"1\">\n" +
                "    <noeud>\n" +
                "        <case i=\"0\">\n" +
                "            <feuille element=\"7\"/>\n" +
                "        </case>\n" +
                "        <case i=\"1\">\n" +
                "            null\n" +
                "        </case>\n" +
                "    </noeud>\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void supprimer3() {
        Ensemble e = new Ensemble(2);

        e.inserer( 15 );
        e.inserer( 34 );

        e.supprimer( 34 );
        e.supprimer( 15 );

        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"0\">\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void supprimer4() {
        Ensemble e = new Ensemble(2);

        e.inserer( 22 );
        e.inserer( 57 );
        e.inserer( 34 );

        e.supprimer( 22 );
        e.supprimer( 34 );

        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"1\">\n" +
                "    <noeud>\n" +
                "        <case i=\"0\">\n" +
                "            null\n" +
                "        </case>\n" +
                "        <case i=\"1\">\n" +
                "            <feuille element=\"28\"/>\n" +
                "        </case>\n" +
                "    </noeud>\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void supprimer5() {
        Ensemble e = new Ensemble(2);

        e.inserer( 16 );
        e.inserer( 32 );

        e.supprimer( 16 );

        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"1\">\n" +
                "    <noeud>\n" +
                "        <case i=\"0\">\n" +
                "            <noeud>\n" +
                "                <case i=\"0\">\n" +
                "                    <noeud>\n" +
                "                        <case i=\"0\">\n" +
                "                            <noeud>\n" +
                "                                <case i=\"0\">\n" +
                "                                    <noeud>\n" +
                "                                        <case i=\"0\">\n" +
                "                                            <feuille element=\"1\"/>\n" +
                "                                        </case>\n" +
                "                                        <case i=\"1\">\n" +
                "                                            null\n" +
                "                                        </case>\n" +
                "                                    </noeud>\n" +
                "                                </case>\n" +
                "                                <case i=\"1\">\n" +
                "                                    null\n" +
                "                                </case>\n" +
                "                            </noeud>\n" +
                "                        </case>\n" +
                "                        <case i=\"1\">\n" +
                "                            null\n" +
                "                        </case>\n" +
                "                    </noeud>\n" +
                "                </case>\n" +
                "                <case i=\"1\">\n" +
                "                    null\n" +
                "                </case>\n" +
                "            </noeud>\n" +
                "        </case>\n" +
                "        <case i=\"1\">\n" +
                "            null\n" +
                "        </case>\n" +
                "    </noeud>\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void supprimer6() {
        Ensemble e = new Ensemble(2);

        e.inserer( 16 );
        e.inserer( 32 );

        e.supprimer( 16 );
        e.supprimer( 32 );

        assertEquals( "<ensemble ratio=\"2\" nbValeur=\"0\">\n" +
                "</ensemble>\n", e.toString() );
    }

    @org.junit.jupiter.api.Test
    void supprimer7() {
        Ensemble e = new Ensemble(4);

        e.inserer( 3 );
        e.inserer( 20 );
        e.inserer( 13 );
        e.inserer( 18 );

        e.supprimer( 20 );

        assertEquals( "<ensemble ratio=\"4\" nbValeur=\"3\">\n" +
                "    <noeud>\n" +
                "        <case i=\"0\">\n" +
                "            null\n" +
                "        </case>\n" +
                "        <case i=\"1\">\n" +
                "            <feuille element=\"3\"/>\n" +
                "        </case>\n" +
                "        <case i=\"2\">\n" +
                "            <feuille element=\"4\"/>\n" +
                "        </case>\n" +
                "        <case i=\"3\">\n" +
                "            <feuille element=\"0\"/>\n" +
                "        </case>\n" +
                "    </noeud>\n" +
                "</ensemble>\n", e.toString() );
    }

}