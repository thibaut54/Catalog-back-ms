package org.thib.impl;

import lombok.AllArgsConstructor;
import org.joda.time.DateTime;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.thib.contract.ProductService;
import org.thib.converter.ProductDtoToEntity;
import org.thib.converter.ProductEntityToDto;
import org.thib.dto.ProductDto;
import org.thib.entity.Product;
import org.thib.repository.ProductRepository;

import java.util.List;
import java.util.Objects;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

	private ProductRepository productRepository;
	private ProductEntityToDto productEntityToDto;
	private ProductDtoToEntity productDtoToEntity;

	@Override
	public ProductDto getProductDto( Long id ){
		ProductDto productDto = new ProductDto();
		BeanUtils.copyProperties( Objects.requireNonNull( productRepository.findById( id ).orElse( null ) ), productDto );
//		return productEntityToDto.apply( Objects.requireNonNull( productRepository.findById( id ).orElse( null ) ) );
		return productDto;
	}

	@Override
	public List<ProductDto> getProductDtoList( ){
		return productEntityToDto.convertToList( productRepository.findAll());
	}

	@Override
	public ProductDto save( ProductDto productDto ){
		productDto.setUpdatedDate( DateTime.now() );
		productRepository.save( productDtoToEntity.apply( productDto ) );
		return productDto;
	}

	@Override
	public void delete( Long id ){
		 productRepository.delete( productRepository.findById( id ).orElse( null ) );
	}

	@Override
	public void deleteList( List< Long > idList ){
		List< Product > productList = productRepository.findAllById( idList );
		productRepository.deleteAll( productList );
	}
}
