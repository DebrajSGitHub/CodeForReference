package com.builderpattern;

public final class MembershipDetailImmutable {

	

	// Required fields
	private final long membershipId;
	private final String name;
	private final String tier;
	// Optional fields
	private final boolean hasLoungeAccess;
	private final String loungeType;
	private final boolean hasCashback;
	private final double cashbackRate;

	public MembershipDetailImmutable(MembershipBuilder builder) {
		super();
		this.membershipId = builder.membershipId;
		this.name = builder.name;
		this.tier = builder.tier;
		this.hasLoungeAccess = builder.hasLoungeAccess;
		this.loungeType = builder.loungeType;
		this.hasCashback = builder.hasCashback;
		this.cashbackRate = builder.cashbackRate;
	}

	public long getMembershipId() {
		return membershipId;
	}

	public String getName() {
		return name;
	}

	public String getTier() {
		return tier;
	}

	public boolean isHasLoungeAccess() {
		return hasLoungeAccess;
	}

	public String getLoungeType() {
		return loungeType;
	}

	public boolean isHasCashback() {
		return hasCashback;
	}

	public double getCashbackRate() {
		return cashbackRate;
	}
	
	
	@Override
	public String toString() {
		return "MembershipDetails [membershipId=" + membershipId + ", name=" + name + ", tier=" + tier
				+ ", hasLoungeAccess=" + hasLoungeAccess + ", loungeType=" + loungeType + ", hasCashback=" + hasCashback
				+ ", cashbackRate=" + cashbackRate + "]";
	}

	public static class MembershipBuilder { // static inner class
		
		private MembershipDetailImmutable membershipDetailImmutable;
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
		
		public MembershipBuilder(MembershipDetailImmutable membershipDetailImmutable) {
			//this.membershipDetailImmutable = membershipDetailImmutable;
			this.membershipId = membershipDetailImmutable.getMembershipId();
			this.name = membershipDetailImmutable.getName();
			this.tier = membershipDetailImmutable.getTier();
			this.hasLoungeAccess = membershipDetailImmutable.isHasLoungeAccess();
			this.loungeType = membershipDetailImmutable.getLoungeType();
			this.hasCashback = membershipDetailImmutable.isHasCashback();
			this.cashbackRate = membershipDetailImmutable.getCashbackRate();
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

		public MembershipDetailImmutable build() { // build method to create product object
			return new MembershipDetailImmutable(this);
		}

	}

}
