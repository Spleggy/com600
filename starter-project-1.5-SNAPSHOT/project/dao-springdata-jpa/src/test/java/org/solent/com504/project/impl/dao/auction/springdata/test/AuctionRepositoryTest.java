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
import org.solent.com504.project.impl.dao.auction.springdata.AuctionRepository;
import org.solent.com504.project.impl.dao.party.springdata.test.PartyRepositoryTest;
import org.solent.com504.project.model.auction.dto.Auction;
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
public class AuctionRepositoryTest {
    
    final static Logger LOG = LogManager.getLogger(PartyRepositoryTest.class);

    @Autowired
    private AuctionRepository auctionRepository = null;
    
    
    @Before
    public void before() {
        LOG.debug("before test running");
        assertNotNull(auctionRepository);
        LOG.debug("before test complete");
    }

    
    @Transactional
    @Test
    public void auctionCreationTest() {
        LOG.debug("start of auctionCreationTest");

        Auction auction1 = new Auction();
        auction1 = auctionRepository.save(auction1);
        System.out.println("auction1=" + auction1);

        Long id = auction1.getId();
        Auction auction2 = auctionRepository.getOne(id);
        System.out.println("auction2=" + auction2);
        LOG.debug("end of auctionCreationTest");
    }

}
