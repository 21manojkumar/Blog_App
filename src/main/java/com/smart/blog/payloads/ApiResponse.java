package com.smart.blog.payloads;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse {

//	public ApiResponse() {
//		// TODO Auto-generated constructor stub
//		
//		
//		private String message="good";
//		
//		
//	}

	
	public ApiResponse(String string, boolean b) {
		// TODO Auto-generated constructor stub
	}
	private String message;
	private boolean success;
	
}
