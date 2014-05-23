package urlqueryparser;import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class QueryStringTest {

    @Test
    public void countsEmptyQuery() {
        assertEquals(0, new QueryString("").count());
    }

    @Test
    public void manyQueries() {
        assertEquals(3, new QueryString("test=farbe&groesse=M&seite=5").count());
    }

    @Test
    public void valueForOnePair(){
        assertEquals("blau", new QueryString("farbe=blau").value("farbe"));
    }

    @Test
    public void valueForUnknowValue(){
        assertNull(new QueryString("farbe=blau").value("seite"));
    }

    @Test
    public void valueForOnePairRot(){
        assertEquals("rot", new QueryString("farbe=rot").value("farbe"));
    }

    @Test
    public void valueForOnePairGroesse(){
        assertEquals("M", new QueryString("groesse=M").value("groesse"));
    }

    @Test
    public void valueForGroesseWithManyPairs(){
        assertEquals("M", new QueryString("groesse=M&farbe=blaue").value("groesse"));
    }

    @Test
    public void valueForGroesseWithWrongPairs(){
        assertEquals("M", new QueryString("groesse=M&farbe").value("groesse"));
    }

    @Test
    public void valueForGroesseWithFourPairs(){
        assertEquals("4", new QueryString("groesse=M&farbe=blau&seite=4&bla=blub").value("seite"));
    }

    @Test
    public void valueForGroesseWithEmptyValue(){
        assertEquals("4", new QueryString("groesse=M&farbe=&seite=4&bla=blub").value("seite"));
    }

}
