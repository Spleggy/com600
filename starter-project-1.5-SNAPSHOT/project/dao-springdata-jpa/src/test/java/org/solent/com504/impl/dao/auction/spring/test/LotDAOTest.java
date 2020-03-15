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
import org.solent.com504.project.model.auction.dao.LotDAO;
import org.solent.com504.project.model.auction.dto.Flower;
import org.solent.com504.project.model.auction.dto.Lot;
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
public class LotDAOTest {
    final static Logger LOG = LogManager.getLogger(PartyDAOTest.class);
    
    @Autowired
    private LotDAO lotDao = null;
    
        
    @Before
    public void before() {
        assertNotNull(lotDao);
        lotDao.deleteAll();
    }
    
    @Test
    public void createLotDAOTest() {
        LOG.debug("start of createLotDAOTest");
        // this test simply runs the before method  
        LOG.debug("end of createLotDAOTest");
    }
     @Test
    public void findByIdTest() {
        LOG.debug("start of findByIdTest");
        Lot lot=new Lot();
        Flower flower=new Flower();
        flower.setSciName("TEST_NAME");
        flower.setQuantity(0);
        lot.setFlower(flower);
        lot.setReservePrice(0.0);
        lot.setStartTime("00:00");
        
        lot=lotDao.save(lot);
        LOG.debug("created test lot:"+lot);
        
        Long id=lot.getId();
        Lot lot2=lotDao.findById(id);
        
        assertEquals(lot,lot2);
        LOG.debug("end of findByIdTest");
    }
     @Test
    public void findAllTest() {
        LOG.debug("start of findAllTest");
        for (int i = 1; i < 6; i++) {
            Lot lot=new Lot();
            Flower flower=new Flower();
            flower.setSciName("TEST_NAME_"+i);
            flower.setQuantity(i);
            lot.setFlower(flower);
            lot.setReservePrice(0.0);
            lot.setStartTime("00:00");

            lot=lotDao.save(lot);
            LOG.debug("created test lot:"+lot);
        }
        List<Lot> lot_list=lotDao.findAll();
        assertNotNull(lot_list);
        assertEquals(5, lot_list.size());
        
        LOG.debug("end of findAllTest");
    }
     @Test
    public void saveTest() {
        LOG.debug("start of saveTest");
        Lot lot=new Lot();
        Flower flower=new Flower();
        flower.setSciName("TEST_NAME");
        flower.setQuantity(0);
        lot.setFlower(flower);
        lot.setReservePrice(0.0);
        lot.setStartTime("00:00");
        
        lot=lotDao.save(lot);
        assertNotNull(lot);
        LOG.debug("created test lot:"+lot);
        
        LOG.debug("end of saveTest");
    }
     @Test
    public void deleteByIdTest() {
        LOG.debug("start of deleteByIdTest");
        List<Lot> lot_list=lotDao.findAll();
        assertTrue(lot_list.isEmpty());
        Lot lot=new Lot();
        Flower flower=new Flower();
        flower.setSciName("TEST_NAME");
        flower.setQuantity(0);
        lot.setFlower(flower);
        lot.setReservePrice(0.0);
        lot.setStartTime("00:00");
        
        lot=lotDao.save(lot);
        LOG.debug("created test lot:"+lot);
        lot_list=lotDao.findAll();
        assertNotNull(lot_list);
        
        Long id=lot.getId();
        lotDao.deleteById(id);
        lot_list=lotDao.findAll();
        assertTrue(lot_list.isEmpty());
        
        LOG.debug("end of deleteByIdTest");
    }
     @Test
    public void deleteTest() {
        LOG.debug("start of deleteTest");
        List<Lot> lot_list=lotDao.findAll();
        assertTrue(lot_list.isEmpty());
        Lot lot=new Lot();
        Flower flower=new Flower();
        flower.setSciName("TEST_NAME");
        flower.setQuantity(0);
        lot.setFlower(flower);
        lot.setReservePrice(0.0);
        lot.setStartTime("00:00");
        
        lot=lotDao.save(lot);
        LOG.debug("created test lot:"+lot);
        lot_list=lotDao.findAll();
        assertNotNull(lot_list);
        
        lotDao.delete(lot);
        lot_list=lotDao.findAll();
        assertTrue(lot_list.isEmpty());
        
        LOG.debug("end of deleteTest");
    }
     @Test
    public void deleteAllTest() {
        LOG.debug("start of deleteAllTest");
        List<Lot> lot_list=lotDao.findAll();
        assertTrue(lot_list.isEmpty());
        Lot lot=new Lot();
        Flower flower=new Flower();
        flower.setSciName("TEST_NAME");
        flower.setQuantity(0);
        lot.setFlower(flower);
        lot.setReservePrice(0.0);
        lot.setStartTime("00:00");
        
        lot=lotDao.save(lot);
        LOG.debug("created test lot:"+lot);
        lot_list=lotDao.findAll();
        assertNotNull(lot_list);
        
        lotDao.deleteAll();
        lot_list=lotDao.findAll();
        assertTrue(lot_list.isEmpty());
        
        LOG.debug("end of deleteAllTest");
    }
     @Test
    public void findByFlowerTest() {
        LOG.debug("start of findByFlowerTest");
        Lot lot=new Lot();
        Flower flower=new Flower();
        flower.setSciName("TEST_NAME");
        flower.setQuantity(0);
        lot.setFlower(flower);
        lot.setReservePrice(0.0);
        lot.setStartTime("00:00");
        
        lot=lotDao.save(lot);
        LOG.debug("created test lot:"+lot);
        
        String sciName=lot.getFlower().getSciName();
        List<Lot> lot_list=lotDao.findByFlower(sciName);
        
        assertEquals(lot,lot_list.get(0));
        
        LOG.debug("end of findByFlowerTest");
    }

    
}
