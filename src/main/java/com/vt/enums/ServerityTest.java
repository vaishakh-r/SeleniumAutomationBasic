package com.vt.enums;

public enum ServerityTest {
	CRITICAL {
		@Override
		public String toLowerCase() {

			return "Critical";
		}
	},
	HIGH {
		@Override
		public String toLowerCase() {

			return ServerityTest.CRITICAL.toString();
		}
	},
	MEDIUM {
		@Override
		public String toLowerCase() {
			// TODO Auto-generated method stub
			return null;
		}
	},
	LOW {
		@Override
		public String toLowerCase() {
			// TODO Auto-generated method stub
			return null;
		}
	};
	
	
	public abstract String toLowerCase();
}
