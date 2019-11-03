package org.thib.dto;

import lombok.*;
import org.joda.time.DateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class ProductDto {

	private Long id;
	private DateTime createdDate;
	private DateTime updatedDate;
	private String label;
	private String description;
	private Double price;
	private Double vatRate;
}
