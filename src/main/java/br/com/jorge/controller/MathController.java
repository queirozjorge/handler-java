package br.com.jorge.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jorge.exceptions.UnsupportedMathOperationException;
import br.com.jorge.service.MathService;

@RestController
public class MathController {

	@Autowired
	private MathService mathService;
	
	@RequestMapping(value = "sum/{n1}/{n2}", method = RequestMethod.GET)
	public Double sum(@PathVariable(name = "n1") String n1, @PathVariable(name = "n2") String n2
			) throws UnsupportedMathOperationException {
		return mathService.sum(n1, n2);
	}
	
	@RequestMapping(value = "subtract/{n1}/{n2}", method = RequestMethod.GET)
	public Double subtract(@PathVariable(name = "n1") String n1, @PathVariable(name = "n2") String n2
			) throws UnsupportedMathOperationException {
		return mathService.subtract(n1, n2);
	}
	
	@RequestMapping(value = "multiply/{n1}/{n2}", method = RequestMethod.GET)
	public Double multiply(@PathVariable(name = "n1") String n1, @PathVariable(name = "n2") String n2
			) throws UnsupportedMathOperationException {
		return mathService.multiply(n1, n2);
	}
	
	@RequestMapping(value = "divide/{n1}/{n2}", method = RequestMethod.GET)
	public Double divide(@PathVariable(name = "n1") String n1, @PathVariable(name = "n2") String n2
			) throws UnsupportedMathOperationException {
		return mathService.divide(n1, n2);
	}
	
	@RequestMapping(value = "average/{n1}/{n2}", method = RequestMethod.GET)
	public Double average(@PathVariable(name = "n1") String n1, @PathVariable(name = "n2") String n2
			) throws UnsupportedMathOperationException {
		return mathService.average(n1, n2);
	}
	
	@RequestMapping(value = "squareRoot/{n}", method = RequestMethod.GET)
	public Double squareRoot(@PathVariable(name = "n") String n) throws UnsupportedMathOperationException {
		return mathService.squareRoot(n);
	}
	
}
