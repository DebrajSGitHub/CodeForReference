package com.builderpattern;

public class MembershipDetailImmutableTest {

	public static void main(String[] args) {
		
        MembershipDetailImmutable membershipDetailImmutable = new MembershipDetailImmutable.MembershipBuilder(12566777L,"Akash", "Tier1").setHasLoungeAccess(true).build();
        System.out.println("membershipDetailImmutable"+membershipDetailImmutable);
        
        
        MembershipDetailImmutable membershipDetailImmutableUpdated = new MembershipDetailImmutable.MembershipBuilder(membershipDetailImmutable).setHasCashback(true).build();
        System.out.println("membershipDetailImmutableUpdated"+membershipDetailImmutableUpdated);
        
        
         

	}

}
