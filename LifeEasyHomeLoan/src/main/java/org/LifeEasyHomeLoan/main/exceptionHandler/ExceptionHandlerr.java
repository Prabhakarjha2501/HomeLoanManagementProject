package org.LifeEasyHomeLoan.main.exceptionHandler;

import org.LifeEasyHomeLoan.main.exception.CustomerNotFoundException;
import org.LifeEasyHomeLoan.main.exception.PdfNotGenerated;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerr {
	 @ExceptionHandler(value=PdfNotGenerated.class)
		public ResponseEntity<String> PdfNotGenerated(){
		
			return new ResponseEntity<>("pdfgenrate",HttpStatus.NOT_FOUND);		
		}
	 @ExceptionHandler(value=CustomerNotFoundException.class)
		public ResponseEntity<String> CustomerNotFoundException(){
		
			return new ResponseEntity<>("this id is not found",HttpStatus.NOT_FOUND);		
		}

}
