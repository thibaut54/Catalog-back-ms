package org.thib.entity;

import lombok.*;
import org.joda.time.DateTime;

import javax.persistence.*;


@Entity
@Table(name = "product")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private DateTime createdDate;
	private DateTime updatedDate;
	private String label;
	private String description;
	private Double price;
	private Double vatRate;
}
