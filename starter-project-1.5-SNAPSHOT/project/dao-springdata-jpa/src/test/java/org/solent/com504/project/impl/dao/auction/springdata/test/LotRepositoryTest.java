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
import org.solent.com504.project.impl.dao.auction.springdata.LotRepository;
import org.solent.com504.project.impl.dao.party.springdata.test.PartyRepositoryTest;
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
public class LotRepositoryTest {
    final static Logger LOG = LogManager.getLogger(PartyRepositoryTest.class);

    @Autowired
    private LotRepository lotRepository = null;
    
    
    @Before
    public void before() {
        LOG.debug("before test running");
        assertNotNull(lotRepository);
        LOG.debug("before test complete");
    }

    
    @Transactional
    @Test
    public void lotCreationTest() {
        LOG.debug("start of lotCreationTest");

        Lot lot1 = new Lot();
        lot1 = lotRepository.save(lot1);
        System.out.println("lot1=" + lot1);

        Long id = lot1.getId();
        Lot lot2 = lotRepository.getOne(id);
        System.out.println("lot2=" + lot2);
        LOG.debug("end of lotCreationTest");
    }

    
}
