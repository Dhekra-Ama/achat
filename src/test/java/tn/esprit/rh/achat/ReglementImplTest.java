package tn.esprit.rh.achat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import tn.esprit.rh.achat.entities.Reglement;
import tn.esprit.rh.achat.services.IReglementService;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ReglementImplTest {
	@Autowired
	IReglementService ReglementService;

	@Test
	public void testAddReglement() {
		List<Reglement> Reglements = ReglementService.retrieveAllReglements();
		int expected=Reglements.size();
		Reglement s = new Reglement(1L, 50,45,false, null, null);
		Reglement savedReglement= ReglementService.addReglement(s);

		assertEquals(expected+1, ReglementService.retrieveAllReglements().size());
		assertNotNull(savedReglement.getIdReglement());
		ReglementService.retrieveReglement(savedReglement.getIdReglement());

	}

	


}