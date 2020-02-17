/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  cgallen
 * Created: 01-Feb-2020
 */

select party0_.id as id1_0_0_, 
user2_.id as id1_2_1_, 
party0_.addressLine1 as addressL2_0_0_,
 party0_.addressLine2 as addressL3_0_0_, 
party0_.country as country4_0_0_, 
party0_.county as county5_0_0_, 
party0_.latitude as latitude6_0_0_, party0_.longitude as longitud7_0_0_,
 party0_.mobile as mobile8_0_0_, party0_.number as number9_0_0_,
 party0_.postcode as postcod10_0_0_, party0_.telephone as telepho11_0_0_, 
party0_.enabled as enabled12_0_0_, party0_.firstName as firstNa13_0_0_, 
party0_.partyRole as partyRo14_0_0_, party0_.partyStatus as partySt15_0_0_, 
party0_.secondName as secondN16_0_0_, party0_.uuid as uuid17_0_0_,
 user2_.addressLine1 as addressL2_2_1_, user2_.addressLine2 as addressL3_2_1_,
 user2_.country as country4_2_1_, user2_.county as county5_2_1_, 
user2_.latitude as latitude6_2_1_, user2_.longitude as longitud7_2_1_, 
user2_.mobile as mobile8_2_1_, user2_.number as number9_2_1_, 
user2_.postcode as postcod10_2_1_,
 user2_.telephone as telepho11_2_1_,
 user2_.enabled as enabled12_2_1_, 
user2_.firstName as firstNa13_2_1_,
 user2_.password as passwor14_2_1_,
 user2_.secondName as secondN15_2_1_,
 user2_.username as usernam16_2_1_, 
users1_.party_id as party_id2_3_0__,
 users1_.user_id as user_id1_3_0__ 
from Party party0_ left outer join user_party users1_ on party0_.id=users1_.party_id 
left outer join user user2_ on users1_.user_id=user2_.id

23:56:28.305 [http-nio-8084-exec-67] [o.h.l.Loader] DEBUG org.hibernate.loader.Loader - Result set row: 0
