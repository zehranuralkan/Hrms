package com.example.Hrms.core.utilities.results;

public class  DataResult<T> extends Result{
	//T generic 
		private T data;
	
		public DataResult(T data,boolean success, String message) {
			super(success, message);
			//base sınıfın constructorlarını çalıştımaya yarar
			this.data=data;
		}

		public DataResult(T data,boolean success) {
			super(success);
			//base sınıfın constructorlarını çalıştımaya yarar
			this.data=data;
		}
		public T getData() {
			return this.data;
		}
	}
