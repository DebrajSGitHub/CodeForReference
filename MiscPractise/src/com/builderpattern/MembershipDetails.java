package com.builderpattern;


public class MembershipDetails {
	
	
	@Override
	public String toString() {
		return "MembershipDetails [membershipId=" + membershipId + ", name=" + name + ", tier=" + tier
				+ ", hasLoungeAccess=" + hasLoungeAccess + ", loungeType=" + loungeType + ", hasCashback=" + hasCashback
				+ ", cashbackRate=" + cashbackRate + "]";
	}





		// Required fields
	    private long membershipId;
	    private String name;
	    private String tier;
	    // Optional fields
	    private boolean hasLoungeAccess;
	    private String loungeType;
	    private boolean hasCashback;
	    private double cashbackRate;
	    
	    
		public MembershipDetails(MembershipBuilder builder) {
		super();
		this.membershipId = builder.membershipId;
		this.name =builder.name;
		this.tier = builder.tier;
		this.hasLoungeAccess = builder.hasLoungeAccess;
		this.loungeType = builder.loungeType;
		this.hasCashback = builder.hasCashback;
		this.cashbackRate = builder.cashbackRate;
	}


		
		
		
		public long getMembershipId() {
			return membershipId;
		}





		public void setMembershipId(long membershipId) {
			this.membershipId = membershipId;
		}





		public String getName() {
			return name;
		}





		public void setName(String name) {
			this.name = name;
		}





		public String getTier() {
			return tier;
		}





		public void setTier(String tier) {
			this.tier = tier;
		}





		public boolean isHasLoungeAccess() {
			return hasLoungeAccess;
		}





		public void setHasLoungeAccess(boolean hasLoungeAccess) {
			this.hasLoungeAccess = hasLoungeAccess;
		}





		public String getLoungeType() {
			return loungeType;
		}





		public void setLoungeType(String loungeType) {
			this.loungeType = loungeType;
		}





		public boolean isHasCashback() {
			return hasCashback;
		}





		public void setHasCashback(boolean hasCashback) {
			this.hasCashback = hasCashback;
		}





		public double getCashbackRate() {
			return cashbackRate;
		}





		public void setCashbackRate(double cashbackRate) {
			this.cashbackRate = cashbackRate;
		}





		public static class MembershipBuilder { // static inner class
			private long membershipId;
		    private String name;
		    private String tier;
		    // Optional fields
		    private boolean hasLoungeAccess;
		    private String loungeType;
		    private boolean hasCashback;
		    private double cashbackRate;

			public MembershipBuilder(long membershipId, String name, String tier) {// constructor with mandatory fields
				this.membershipId = membershipId;
				this.name = name;
				this.tier = tier;
			}

			public MembershipBuilder setHasLoungeAccess(boolean hasLoungeAccess) {
				this.hasLoungeAccess = hasLoungeAccess;
				return this;
			}
			
			public MembershipBuilder setLoungeType(String loungeType) {
				this.loungeType = loungeType;
				return this;
			}
			
			public MembershipBuilder setHasCashback(boolean hasCashback) {
				this.hasCashback = hasCashback;
				return this;
			}
			
			public MembershipBuilder setCashbackRate(double cashbackRate) {
				this.cashbackRate = cashbackRate;
				return this;
			}

			public MembershipDetails build() { // build method to create product object
				return new MembershipDetails(this);
			}

		}

}
