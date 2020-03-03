/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.dao.auction.springdata.test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.solent.com504.project.impl.dao.auction.springdata.BidRepository;
import org.solent.com504.project.impl.dao.auction.springdata.LotRepository;
import org.solent.com504.project.impl.dao.party.springdata.test.PartyRepositoryTest;
import org.solent.com504.project.model.auction.dto.Bid;
import org.solent.com504.project.model.auction.dto.Lot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author 3lelia74
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring.xml"})
public class BidRepositoryTest {
    final static Logger LOG = LogManager.getLogger(PartyRepositoryTest.class);

    @Autowired
    private BidRepository bidRepository = null;
    
    
    @Before
    public void before() {
        LOG.debug("before test running");
        assertNotNull(bidRepository);
        LOG.debug("before test complete");
    }

    
    @Transactional
    @Test
    public void bidCreationTest() {
        LOG.debug("start of bidCreationTest");

        Bid bid1 = new Bid();
       bid1 = bidRepository.save(bid1);
        System.out.println("bid1=" + bid1);

        Long id = bid1.getId();
        Bid bid2 = bidRepository.getOne(id);
        System.out.println("bid2=" + bid2);
        LOG.debug("end of bidCreationTest");
    }

    
    
}
