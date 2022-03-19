package com.careerit.iplstat.main;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
class Appointment{
		private int id;
		private String pname;
		private String dname;
		private String pmobile;
		private String email;
		
		/*private Appointment(AppointmentBuilder ab) {
			this.id = ab.id;
			this.pmobile = ab.pmobile;
			this.email = ab.email;
			this.pname = ab.pname;
			this.dname = ab.dname;
			
		}
		public static AppointmentBuilder builer() {
			return new AppointmentBuilder();
		}
		static class AppointmentBuilder{
			private int id;
			private String pname;
			private String dname;
			private String pmobile;
			private String email;
			public AppointmentBuilder id(int id) {
				this.id = id;
				return this;
			}
			public AppointmentBuilder pname(String pname) {
				this.pname = pname;
				return this;
			}
			public AppointmentBuilder dname(String dname) {
				this.dname = dname;
				return this;
			}
			public AppointmentBuilder pmobile(String pmobile) {
				this.pmobile = pmobile;
				return this;
			}
			public AppointmentBuilder email(String email) {
				this.pemail = email;
				return this;
			}
			public Appointment build() {
				return new Appointment(this);
			}
			}
			*/
	
		
}

public class Manager {

		public static void main(String[] args) {
			Appointment app = Appointment.builder()
					                     .id(1001)
					                     .pname("ABC")
					                     .dname("XYZ")
					                     .pmobile("999999")
					                     .email("abc@xyz.com")
					                     .build();
		}
}
