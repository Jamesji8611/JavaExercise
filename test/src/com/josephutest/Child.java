package com.josephutest;

	public class Child {
		/**
		 * id, beforeChild, nextChild
		 */
		private int id;
		private Child beforeChild;
		private Child nextChild;
		
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public Child getBeforeChild() {
			return beforeChild;
		}
		public void setBeforeChild(Child beforeChild) {
			this.beforeChild = beforeChild;
		}
		public Child getNextChild() {
			return nextChild;
		}
		public void setNextChild(Child nextChild) {
			this.nextChild = nextChild;
		}
	}
