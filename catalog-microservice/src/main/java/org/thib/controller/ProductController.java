package org.thib.controller;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.thib.contract.ProductService;
import org.thib.dto.ProductDto;
import org.thib.exception.MyResourceNotFoundException;
import org.thib.utils.RestPreconditions;
import org.thib.utils.SingleResourceRetrievedEvent;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin("*")
public class ProductController {

	private ProductService productService;
	private ApplicationEventPublisher eventPublisher;

	public ProductController( ProductService productService,
	                          ApplicationEventPublisher eventPublisher ) {
		this.productService = productService;
		this.eventPublisher = eventPublisher;
	}

	@GetMapping("product/{id}")
	public ProductDto productDto( @PathVariable("id") Long id, HttpServletResponse response){
		try {
			ProductDto productDto = RestPreconditions.checkFound( productService.getProductDto( id ) );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return productDto;
		}
		catch ( MyResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NOT_FOUND, "Product not found", ex );
		}
	}

	@GetMapping("products")
	public List<ProductDto> productDtoList(HttpServletResponse response){
		try {
			List<ProductDto> productDtoList = RestPreconditions.checkFound( productService.getProductDtoList( ) );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return productDtoList;
		}
		catch ( MyResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "No product found", ex );
		}
	}

	@PutMapping("product")
	public ProductDto update( @RequestBody ProductDto productDto, HttpServletResponse response ){
		try {
			RestPreconditions.checkFound( productDto );
			ProductDto productDtoToSave	= productService.save( productDto );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
			return productDtoToSave;
		}
		catch ( MyResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "Product to save is null", ex );
		}
	}

	@DeleteMapping("product")
	public void delete( @PathVariable("id") Long id, HttpServletResponse response ){
		try {
			RestPreconditions.checkFound(  id );
			productService.delete( id );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
		}
		catch ( MyResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "Product to delete is null", ex );
		}
	}

	@DeleteMapping("products/{idList}")
	public void deleteList( @PathVariable("idList") List<Long> idList, HttpServletResponse response ){
		try {
			RestPreconditions.checkFound( idList );
			productService.deleteList( idList );
			eventPublisher.publishEvent( new SingleResourceRetrievedEvent(this, response) );
		}
		catch ( MyResourceNotFoundException ex ){
			throw new ResponseStatusException( HttpStatus.NO_CONTENT, "Product list to delete is null", ex );
		}
	}
}
