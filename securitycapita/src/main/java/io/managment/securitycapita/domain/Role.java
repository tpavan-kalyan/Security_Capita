package io.managment.securitycapita.domain;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@AllArgsConstructor
@JsonInclude(NON_DEFAULT)
@SuperBuilder
@NoArgsConstructor
public class Role {

	private Long id;
	private String name;
	private String permission;
	
}
