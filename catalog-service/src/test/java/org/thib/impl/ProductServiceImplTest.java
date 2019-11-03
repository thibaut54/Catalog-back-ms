package org.thib.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.thib.dto.ProductDto;
import org.thib.entity.Product;
import org.thib.repository.ProductRepository;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@DisplayName( "Testing ProductService" )
class ProductServiceImplTest {

	@Mock
	ProductRepository productRepository;

	@InjectMocks
	ProductServiceImpl productServiceImp;


	@BeforeEach
	void setUp() throws Exception{
		MockitoAnnotations.initMocks( this );
//		when( productEntityToDto.apply( any() ) ).thenReturn( new ProductDto() );
	}

	@Test
	final void testgetProductDto() {

		Product productMock = Product.builder()
									.id( 2L )
									.description( "description updated 2" )
									.label( "produit mocké" )
									.price( 15.95 )
									.vatRate( 5.5 )
                                .build();

		when(productRepository.findById( anyLong() )).thenReturn( Optional.ofNullable( productMock ) );

//		when( productEntityToDto.apply( any() ) ).thenReturn( new ProductDto() );

		final ProductDto productDto = productServiceImp.getProductDto( 15L );

		Assertions.assertNotNull( productDto );
		Assertions.assertEquals( "produit mocké", productDto.getLabel() );
	}

}
