package org.thib.helper;

import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.thib.repository.ProductRepository;

@Component
@AllArgsConstructor
public class DbPopulator implements CommandLineRunner {

	private ProductRepository productRepository;


	@Override
	public void run( String... args ) throws Exception {

//		System.out.println( "CONSUMER APP RUN" );
//
//		productRepository.deleteAll();
//
//		List< Product > productList = new ArrayList<>();
//
//		for(int i = 0; i < 50 ; i++){
//			List<Double> givenList = Arrays.asList( VatRate.vat206 , VatRate.vat55 );
//			Random rand = new Random();
//			Double randomElement = givenList.get(rand.nextInt(givenList.size()));
//
//			productList.add( Product.builder( )
//					                 .label( String.format( "Produit %d", i + 1 ) )
//					                 .description( String.format( "Description %d", i + 17)  )
//					                 .price( ( double ) (10 + i) )
//					                 .createdDate( DateTime.now( ) )
//					                 .vatRate( randomElement )
//					                 .build( ));
//		}
//
//		productRepository.saveAll( productList );

	}
}
