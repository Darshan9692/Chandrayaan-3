import static org.junit.Assert.*;
import org.junit.Test;



public class Chandrayaan3Test {
    @Test
    public void testChandraan() {
        Chandrayan3 chandryaan = new Chandrayan3("N",new int[]{0,0,0});

        assertEquals("N", chandryaan.dir);
        assertArrayEquals(new int[] { 0, 0, 0 }, chandryaan.coordinates);

        Chandrayan3 obj = new Chandrayan3("N",new int[]{0,0,0});
        char[] commands = { 'f', 'r', 'u', 'b', 'l' };

        obj.handleMove(commands);

        assertEquals("N", obj.dir);
        assertArrayEquals(new int[] { 0, 1, -1 }, obj.coordinates);


        Chandrayan3 obj1 = new Chandrayan3("N",new int[]{0,0,0});
        char[] commands1 = { 'f', 'b' , 'b'};

        obj1.handleMove(commands1);

        assertEquals("N", obj1.dir);
        assertArrayEquals(new int[] { 0, -1, 0 }, obj1.coordinates);

    }
}