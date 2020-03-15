/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.impl.dao.auction.spring.test;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.solent.com504.impl.dao.auction.spring.test.AuctionDAOTest.LOG;
import org.solent.com504.project.impl.dao.spring.test.PartyDAOTest;
import org.solent.com504.project.model.auction.dao.BidDAO;
import org.solent.com504.project.model.auction.dto.Bid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author anton
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"/spring.xml"})
@Transactional
public class BidDAOTest {
    final static Logger LOG = LogManager.getLogger(PartyDAOTest.class);
    
    @Autowired
    private BidDAO bidDao = null;
    
    @Before
    public void before() {
        assertNotNull(bidDao);
        bidDao.deleteAll();
    }
    
    @Test
    public void createBidDAOTest() {
        LOG.debug("start of createBidDAOTest");
        // this test simply runs the before method    
        LOG.debug("end of createBidDAOTest");
    }
    @Test
    public void findByIdTest() {
        LOG.debug("start of findByIdTest");
        Bid bid=new Bid();
        bid.setAmount(100.0);
        bid.setBid_time("00:00");
        bid=bidDao.save(bid);
        LOG.debug("created test bid:"+bid);
        
        Long id=bid.getId();
        Bid bid2=bidDao.findById(id);
        assertEquals(bid,bid2);
        LOG.debug("end of findByIdTest");
    }
    @Test
    public void findAllTest() {
        LOG.debug("start of findAllTest");
        for (int i = 1; i < 6; i++) {
            Bid bid=new Bid();
            bid.setAmount(100.0);
            bid.setBid_time("00:00"+i);
            bid=bidDao.save(bid);
            LOG.debug("created test bid:"+bid);
        }
        
        List<Bid> bid_list=bidDao.findAll();
        assertNotNull(bid_list);
        assertEquals(5, bid_list.size());
        LOG.debug("end of findAllTest");
    }
    @Test
    public void saveTest() {
        LOG.debug("start of saveTest");
        Bid bid=new Bid();
        bid.setAmount(100.0);
        bid.setBid_time("00:00");
        bid=bidDao.save(bid);
        assertNotNull(bid);
        LOG.debug("created test bid:"+bid);
        
        LOG.debug("end of saveTest");
    }
    @Test
    public void deleteByIdTest() {
        LOG.debug("start of deleteByIdTest");
        List<Bid> bid_list=bidDao.findAll();
        assertTrue(bid_list.isEmpty());
        
        Bid bid=new Bid();
        bid.setAmount(100.0);
        bid.setBid_time("00:00");
        bid=bidDao.save(bid);
        
        Long id=bid.getId();
        bid_list=bidDao.findAll();
        assertNotNull(bid_list);
        
        bidDao.deleteById(id);
        bid_list=bidDao.findAll();
        assertTrue(bid_list.isEmpty());
        
        LOG.debug("end of deleteByIdTest");
    }
    @Test
    public void deleteTest() {
        LOG.debug("start of deleteTest");
        List<Bid> bid_list=bidDao.findAll();
        assertTrue(bid_list.isEmpty());
        
        Bid bid=new Bid();
        bid.setAmount(100.0);
        bid.setBid_time("00:00");
        bid=bidDao.save(bid);
        
        bid_list=bidDao.findAll();
        assertNotNull(bid_list);
        
        bidDao.delete(bid);
        bid_list=bidDao.findAll();
        assertTrue(bid_list.isEmpty());
        
        LOG.debug("end of deleteTest");
    }
    @Test
    public void deleteAllTest() {
        LOG.debug("start of deleteAllTest");
        List<Bid> bid_list=bidDao.findAll();
        assertTrue(bid_list.isEmpty());
        
        Bid bid=new Bid();
        bid.setAmount(100.0);
        bid.setBid_time("00:00");
        bid=bidDao.save(bid);
        
        bid_list=bidDao.findAll();
        assertNotNull(bid_list);
        
        bidDao.deleteAll();
        bid_list=bidDao.findAll();
        assertTrue(bid_list.isEmpty());
        
        LOG.debug("end of deleteAllTest");
    }
    
}
