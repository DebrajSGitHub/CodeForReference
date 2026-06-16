package com.builderpattern;

public class MembershipTest {

	public static void main(String[] args) {
		MembershipDetails membershipdetail = new MembershipDetails.MembershipBuilder(155667L, "Richard", "Tier1").setCashbackRate(5.0).build();
		System.out.println("membershipdetail" +membershipdetail);
		
	
		
	}

}

//MembershipDetails.MembershipBuilder(1555678L, "Adam", "Tier1")
