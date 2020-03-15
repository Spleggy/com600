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
import org.solent.com504.project.impl.dao.spring.test.PartyDAOTest;
import org.solent.com504.project.model.auction.dao.AuctionDAO;
import org.solent.com504.project.model.auction.dto.Auction;
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
public class AuctionDAOTest {
    final static Logger LOG = LogManager.getLogger(PartyDAOTest.class);
        
    @Autowired
    private AuctionDAO auctionDao = null;


    
    @Before
    public void before() {
        assertNotNull(auctionDao);
        auctionDao.deleteAll();
    }
    
    @Test
    public void createAuctionDAOTest() {
        LOG.debug("start of createAuctionDAOTest");
        // this test simply runs the before method
        LOG.debug("end of createAuctionDAOTest");
    }
    @Test
    public void findByIdTest(){
        LOG.debug("start of findByIdTest()");
        Auction auc=new Auction();
        auc.setStartTime("0");
        auc.setEndTime("12");
        auc.setTimePerLot("5");
        
        auc= auctionDao.save(auc);
        LOG.debug("created test auction:"+auc);
        Long id=auc.getId();
        
        Auction auc2=auctionDao.findById(id);
        
        assertEquals(auc,auc2);
        LOG.debug("end of findByIdTest()");
    }
    @Test
    public void findAllTest(){
        LOG.debug("start of findAllTest()");
        for (int i = 1; i < 6; i++) {
            Auction auc=new Auction();
            auc.setStartTime("0"+i);
            auc.setEndTime("1"+i);
            auc.setTimePerLot("5");
            
            auc= auctionDao.save(auc);
            LOG.debug("created test auction:"+auc);
        }
        List<Auction> auc_list=auctionDao.findAll();
        
        assertNotNull(auc_list);
        
        assertEquals(5, auc_list.size());
        
        String msg = "";
        for (Auction aucLoop : auc_list) {
            msg = msg + "\n   " + aucLoop.toString();
        }
        LOG.debug("findAllTest() retrieved:" + msg);
        LOG.debug("end of findAllTest()");
        
    }
    @Test
    public void saveTest(){
        LOG.debug("start of saveTest()");
        LOG.debug("start of findByIdTest()");
        Auction auc=new Auction();
        auc.setStartTime("0");
        auc.setEndTime("12");
        auc.setTimePerLot("5");
        
        auc= auctionDao.save(auc);
        assertNotNull(auc);
        LOG.debug("created and saved auction:"+auc);
        LOG.debug("end of saveTest()");
        
    }
    @Test
    public void deleteByIdTest(){
        LOG.debug("start of deleteByIdTest()");
        List<Auction> auc_list=auctionDao.findAll();
        assertTrue(auc_list.isEmpty());
        Auction auc=new Auction();
        auc.setStartTime("0");
        auc.setEndTime("12");
        auc.setTimePerLot("5");
        
        auc= auctionDao.save(auc);
        LOG.debug("created test auction:"+auc);
        Long id=auc.getId();
        
        auc_list=auctionDao.findAll();
        assertNotNull(auc_list);
        
        auctionDao.deleteById(id);
        auc_list=auctionDao.findAll();
        assertTrue(auc_list.isEmpty());
              
        LOG.debug("end of deleteByIdTest()");
        
    }
    @Test
    public void deleteTest(){
        LOG.debug("start of deleteTest()");
        List<Auction> auc_list=auctionDao.findAll();
        assertTrue(auc_list.isEmpty());
        Auction auc=new Auction();
        auc.setStartTime("0");
        auc.setEndTime("12");
        auc.setTimePerLot("5");
        
        auc= auctionDao.save(auc);
        LOG.debug("created test auction:"+auc);
        
        auc_list=auctionDao.findAll();
        assertNotNull(auc_list);
        
        auctionDao.delete(auc);
        auc_list=auctionDao.findAll();
        assertTrue(auc_list.isEmpty());
        LOG.debug("end of deleteTest()");
        
    }
    @Test
    public void deleteAllTest(){
        LOG.debug("start of deleteAllTest()");
        List<Auction> auc_list=auctionDao.findAll();
        assertTrue(auc_list.isEmpty());
        Auction auc=new Auction();
        auc.setStartTime("0");
        auc.setEndTime("12");
        auc.setTimePerLot("5");
        
        auc= auctionDao.save(auc);
        LOG.debug("created test auction:"+auc);
        
        auc_list=auctionDao.findAll();
        assertNotNull(auc_list);
        
        auctionDao.deleteAll();
        auc_list=auctionDao.findAll();
        assertTrue(auc_list.isEmpty());
       
        LOG.debug("end of deleteAllTest()");
        
    }
    
}
