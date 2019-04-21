import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

public class EquipmentTest {
	private static Equipment equipment = new Equipment();

	
	
	@Before
	public void setUp() throws Exception {
		equipment.SetName("BrewerOne");
		equipment.SetSize(100.0);
	}

	@Test
	public void testGetName() {
		assertTrue(equipment.GetName().equals("BrewerOne"));
	}

	@Test
	public void testGetSize() {
		assertTrue(equipment.GetSize() == 100);
	}

	@Test
	public void testSetName() {
		equipment.SetName("BrewerTwo");
		assertTrue(equipment.GetName().equals("BrewerTwo"));
	}

	@Test
	public void testSetSize() {
		equipment.SetSize(200);
		assertTrue(equipment.GetSize() == 200);
	}

	@Test
	public void testConvert_L_mL() {
		assertTrue(equipment.convert_L_mL(1) == 1000);
	}

}
