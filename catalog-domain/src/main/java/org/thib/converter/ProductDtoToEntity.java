package org.thib.converter;

import lombok.AllArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;
import org.thib.dto.ProductDto;
import org.thib.entity.Product;

@Component
@AllArgsConstructor
public class ProductDtoToEntity implements SuperConverter< ProductDto, Product  >{
	/**
	 * Applies this function to the given argument.
	 *
	 * @param productDto the function argument
	 * @return the function result
	 */
	@Override
	public Product apply( ProductDto productDto ) {
		final Product product = new Product();
		ClassUtils.setIfNotNull( productDto::getId, id -> product.setId( (Long) id ) );
		ClassUtils.setIfNotNull( productDto::getCreatedDate, createdDate -> product.setCreatedDate( ( DateTime ) createdDate ) );
		ClassUtils.setIfNotNull( productDto::getUpdatedDate, updatedDate -> product.setUpdatedDate( ( DateTime ) updatedDate ) );
		ClassUtils.setIfNotNull( productDto::getDescription, description -> product.setDescription( (String ) description ) );
		ClassUtils.setIfNotNull( productDto::getLabel, label -> product.setLabel( (String ) label ) );
		ClassUtils.setIfNotNull( productDto::getPrice, price -> product.setPrice( (Double) price ) );
		ClassUtils.setIfNotNull( productDto::getVatRate, vatRate -> product.setVatRate( (Double) vatRate ) );
		return product;
	}
}
