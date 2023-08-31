import static org.junit.Assert.*;
import org.junit.Test;



public class Chandrayaan3Test {
    @Test
    public void testChandraan1() {
        Chandarayan3 chandryaan = new Chandarayan3(0,0,0,"N");

        String[] commands = {"f","r","u","b","l"};

        chandryaan.sendMessage(commands);

        assertEquals(0,chandryaan.getX());
        assertEquals(1,chandryaan.getY());
        assertEquals(-1,chandryaan.getZ());
        assertEquals("N",chandryaan.getDir());

    }

    @Test
    public void testChandraan2() {
        Chandarayan3 chandryaan = new Chandarayan3(0,1,0,"Up");

        String[] commands = {"r","f","u","b","r"};

        chandryaan.sendMessage(commands);

        assertEquals(1,chandryaan.getX());
        assertEquals(1,chandryaan.getY());
        assertEquals(-1,chandryaan.getZ());
        assertEquals("S",chandryaan.getDir());

    }

    @Test
    public void testChandraan3() {
        Chandarayan3 chandryaan = new Chandarayan3(0,0,0,"E");

        String[] commands = {"f","f"};

        chandryaan.sendMessage(commands);

        assertEquals(2,chandryaan.getX());
        assertEquals(0,chandryaan.getY());
        assertEquals(0,chandryaan.getZ());
        assertEquals("E",chandryaan.getDir());

    }

    @Test
    public void testChandraan4() {
        Chandarayan3 chandryaan = new Chandarayan3(0,0,0,"S");

        String[] commands = {"b","f","b"};

        chandryaan.sendMessage(commands);

        assertEquals(0,chandryaan.getX());
        assertEquals(1,chandryaan.getY());
        assertEquals(0,chandryaan.getZ());
        assertEquals("S",chandryaan.getDir());

    }

}