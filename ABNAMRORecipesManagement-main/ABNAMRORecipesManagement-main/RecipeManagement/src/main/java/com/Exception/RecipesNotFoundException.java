package com.Exception;

public class RecipesNotFoundException extends Exception {
	
		String msg;

		public String getMsg() {
			return msg;
		}

		public void setMsg(String msg) {
			this.msg = msg;
		}

		public RecipesNotFoundException(String msg) {
			super();
			this.msg = msg;
		}
	}
