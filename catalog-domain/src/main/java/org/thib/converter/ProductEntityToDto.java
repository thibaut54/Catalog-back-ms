package org.thib.converter;

import lombok.AllArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.thib.dto.ProductDto;
import org.thib.entity.Product;

@Component
@AllArgsConstructor
public class ProductEntityToDto implements SuperConverter< Product, ProductDto >{
	/**
	 * Applies this function to the given argument.
	 *
	 * @param product the function argument
	 * @return the function result
	 */
	@Override
	public ProductDto apply( Product product ) {
		final ProductDto productDto = new ProductDto();
		ClassUtils.setIfNotNull( product::getId, id -> productDto.setId( (Long) id ) );
		ClassUtils.setIfNotNull( product::getCreatedDate, createdDate -> productDto.setCreatedDate( ( DateTime ) createdDate ) );
		ClassUtils.setIfNotNull( product::getUpdatedDate, updatedDate -> productDto.setUpdatedDate( ( DateTime ) updatedDate ) );
		ClassUtils.setIfNotNull( product::getDescription, description -> productDto.setDescription( (String ) description ) );
		ClassUtils.setIfNotNull( product::getLabel, label -> productDto.setLabel( (String ) label ) );
		ClassUtils.setIfNotNull( product::getPrice, price -> productDto.setPrice( (Double) price ) );
		ClassUtils.setIfNotNull( product::getVatRate, vatRate -> productDto.setVatRate( (Double) vatRate ) );
		return productDto;
	}


}
