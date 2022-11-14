package achat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import lombok.extern.slf4j.Slf4j;
import tn.esprit.rh.achat.entities.Produit;
import tn.esprit.rh.achat.repositories.ProduitRepository;
import tn.esprit.rh.achat.services.ProduitServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
@RunWith(MockitoJUnitRunner.class)
@Slf4j
public class ProduitTest {
	ProduitRepository produitRepository = Mockito.mock(ProduitRepository.class);


	@InjectMocks
	ProduitServiceImpl produitService;
	
	@Test
	public void testRetrieveProduit() {

	Produit prod = new Produit( null, "222kk", "jhhhf", 2033, null, null, null, null, null);
	prod.setIdProduit(1L);

	Mockito.when(produitRepository.findById(1L)).thenReturn(Optional.of(prod));
	produitService.retrieveProduit(1L);
	Assertions.assertNotNull(prod);

	log.info(prod.toString());
	log.info(" Resultat Test RetrieveProduit : Done!");

	}
	@Test
	public void createProduitTest()
	{

	Produit prod2 = new Produit(null,"test", "test1",25888 , null, null, null, null, null);
	prod2.setIdProduit(2L);

	produitService.addProduit(prod2);
	verify(produitRepository, times(1)).save(prod2);
	log.info(String.valueOf(prod2.getIdProduit()));
	log.info(" Resultat Test  createProduitTest : Done!");
	}

	
	
	

	@Test
	public void TestDeleteProduit(){

	Produit prod3 = new Produit(null,"mouna", "zgh",88588 , null, null, null, null, null);
	prod3.setIdProduit(8L);



	Mockito.lenient().when(produitRepository.findById(prod3.getIdProduit())).thenReturn(Optional.of(prod3));

	produitService.deleteProduit(8L);
	verify(produitRepository).deleteById(prod3.getIdProduit());

	
	log.info(" Resultat Test DeleteeProduit : Done ! ");
	}
	@Test
		public void getAllProduitTest()
		{
		List<Produit> produits = new ArrayList<Produit>();
		
		produits.add(new Produit(null,"test2", "test22",888 , null, null, null, null, null));
		produits.add(new Produit(null,"test11", "test11",2588 , null, null, null, null, null));
		produits.add(new Produit(null,"testt", "teest1",2500 , null, null, null, null, null));
		
	
		when(produitService.retrieveAllProduits()).thenReturn(produits);
		//test
		List<Produit> prodList =  produitService.retrieveAllProduits();
		assertEquals(3,prodList.size());
		log.info(" Resultat Test getAllCategorieProduit : Done ! ");
	
		}


}

