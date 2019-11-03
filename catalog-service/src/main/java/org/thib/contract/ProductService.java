package org.thib.contract;

import org.thib.dto.ProductDto;

import java.util.List;

public interface ProductService {

	ProductDto getProductDto( Long id );

	List<ProductDto> getProductDtoList( );

	ProductDto save( ProductDto productDto );

	void delete( ProductDto productDto );

	void deleteList( List< Long > idList );
}
