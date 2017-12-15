package org.seckill.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SuccessKilledDaoTest {

	@Resource
	private SuccessKilledDao successKilledDao;
	
	@Test
	public void testInsertSuccessKilled() {
		//fail("Not yet implemented");
		long id = 1001L;
        long phone = 13502181181L;
        int insertCount = successKilledDao.insertSuccessKilled(id, phone);
        System.out.println("insertCount=" + insertCount);
        //第一次insertCount=1
        //第二次insertCount=0
	}

	@Test
	public void testQueryByIdWithSeckill() {
		//fail("Not yet implemented");
		long id = 1001L;
        long phone = 13502181181L;
        SuccessKilled successKilled=successKilledDao.queryByIdWithSeckill(id, phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSeckill());
        /**
         * SuccessKilled [seckillId=1001, userPhone=13502181181, state=0, createTime=Sat Dec 02 13:59:18 CST 2017]
			Seckill [seckillId=1001, name=500元秒杀ipad2, number=200, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Fri Dec 01 19:11:52 CST 2017]
         */
	}

}
