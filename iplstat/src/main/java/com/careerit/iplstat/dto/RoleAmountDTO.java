package com.careerit.iplstat.dto;

import lombok.Data;

@Data
public class RoleAmountDTO {
	
		private String roleName;
		private Double amount;
		
		public RoleAmountDTO(String roleName, Double amount) {
			super();
			this.roleName = roleName;
			this.amount = amount;
		}
		public String getRoleName() {
			return roleName;
		}
		public void setRoleName(String roleName) {
			this.roleName = roleName;
		}
		public Double getAmount() {
			return amount;
		}
		public void setAmount(Double amount) {
			this.amount = amount;
		}
		@Override
		public String toString() {
			return "RoleAmountDTO [roleName=" + roleName + ", amount=" + amount + "]";
		}
		
}
