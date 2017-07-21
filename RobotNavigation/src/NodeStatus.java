
public enum NodeStatus {
	  Start {
	      public String toString() {
	          return "Start";
	      }
	  },

	  Goal {
	      public String toString() {
	          return "Goal";
	      }
	  },	
	  Restricted {
	      public String toString() {
	          return "Restricted Node";
	      }
	  },
	  Allowed {
	      public String toString() {
	          return "Allowed Node";
	      }
	  }	 
}
