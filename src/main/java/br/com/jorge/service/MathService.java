package br.com.jorge.service;

import java.util.Objects;

import org.springframework.stereotype.Service;

import br.com.jorge.exceptions.UnsupportedMathOperationException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MathService {

	public Double sum(String n1, String n2) {
		return validateAndConvertToDouble(n1) + validateAndConvertToDouble(n2);
	}
	
	public Double subtract(String n1, String n2) {
		return validateAndConvertToDouble(n1) - validateAndConvertToDouble(n2);
	}
	
	public Double multiply(String n1, String n2) {
		return validateAndConvertToDouble(n1) * validateAndConvertToDouble(n2);
	}
	
	public Double divide(String n1, String n2) {
		Double n2ForDivide = validateAndConvertToDouble(n2);
		if(n2ForDivide.equals(0D)) {
			throw new UnsupportedMathOperationException("Cannot divide a number by zero!");
		}
		return validateAndConvertToDouble(n1) / n2ForDivide;
	}
	
	public Double average(String n1, String n2) {
		return (validateAndConvertToDouble(n1) + validateAndConvertToDouble(n2)) / 2;
	}
	
	public Double squareRoot(String n) {
		return Math.sqrt(validateAndConvertToDouble(n));
	}
	
	private Double validateAndConvertToDouble(String strNumber) throws UnsupportedMathOperationException {
		if(Objects.isNull(strNumber)) 
			return 0D;
		String number = strNumber.replaceAll(",", ".");
		if(number.matches("[+-]?[0-9]*\\.?[0-9]+")) {
			log.info("The String: {} has been successfully validated", strNumber);
			return Double.valueOf(number);
		} else {
			log.info("The String: {} has not been validated", strNumber);
			throw new UnsupportedMathOperationException("Please, set a numeric value!");
		}
	}
}
