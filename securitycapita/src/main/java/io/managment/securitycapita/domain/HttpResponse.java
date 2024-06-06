package io.managment.securitycapita.domain;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_DEFAULT;

import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@JsonInclude(NON_DEFAULT)
@SuperBuilder
public class HttpResponse {
	protected String timeStamp;
	protected int statusCode;
	protected HttpStatus status;
	protected String response;
	protected String message;
	protected String developerMessage;
	protected Map<?, ?> data;
}
