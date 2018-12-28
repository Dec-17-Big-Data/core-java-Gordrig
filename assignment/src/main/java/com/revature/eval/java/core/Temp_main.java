package com.revature.eval.java.core;

import java.util.Optional;
import java.util.function.Function;

public class Temp_main {
	
	Optional<Boolean> opFunc() {
		Optional.of(true);
		
		return Optional.empty();
	}
	
	static Function<String, Boolean> myFunc = (String str) -> {
		System.out.println(str); 
		return false;
	};
	
	//myFunc.@call("abc");
	
	public static void otherMain(String[] args) {
		//opFunc.get();
	}
	

}
