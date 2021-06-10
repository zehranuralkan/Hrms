package com.example.Hrms.core.utilities.results;

public class Result {
	private boolean success;
	//bu işlem başarılı mı 
	private String message;
	//yaptığımız işlemin mesaj bilgisi 
	public Result(boolean success) {
		this.success=success;
		}
	public Result(boolean success,String message) {
		this(success);
		this.message=message;
	}
	public boolean isSuccess() {
		return this.success;
	}
	public String getMessage() {
		return this.message;
	}

}
