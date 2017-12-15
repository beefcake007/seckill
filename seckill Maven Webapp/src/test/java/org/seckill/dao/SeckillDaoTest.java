package org.seckill.dao;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Seckill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 配置spring和junit整合,junit启动时加载springIOC容器
 * spring-test,junit
 * @author fanye
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
public class SeckillDaoTest {

	//注入dao实现类依赖
	@Resource
	private SeckillDao seckillDao;
	
	@Test
	public void testQueryById() {
		//fail("Not yet implemented");
		long id=1000;
		Seckill seckill=seckillDao.queryById(id);
		System.out.println(seckill.getName());
		System.out.println(seckill);
		/**
		 * 1000元秒杀iphone6
			Seckill [seckillId=1000, name=1000元秒杀iphone6, number=100, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Fri Dec 01 19:11:52 CST 2017]

		 */
	}

	@Test
	public void testQueryAll() {
		//fail("Not yet implemented");
		//java没有保存形参的记录：queryAll(int offet,int limit) -> queryAll(arg0,arg1)
		List<Seckill> seckills = seckillDao.queryAll(0, 100);
        for (Seckill seckill : seckills) {
            System.out.println(seckill);
        }
        /**
         * Seckill [seckillId=1000, name=1000元秒杀iphone6, number=100, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Fri Dec 01 19:11:52 CST 2017]
			Seckill [seckillId=1001, name=500元秒杀ipad2, number=200, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Fri Dec 01 19:11:52 CST 2017]
			Seckill [seckillId=1002, name=300元秒杀小米4, number=300, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Fri Dec 01 19:11:52 CST 2017]
			Seckill [seckillId=1003, name=200元秒杀红米note, number=400, startTime=Sun Nov 01 00:00:00 CST 2015, endTime=Mon Nov 02 00:00:00 CST 2015, createTime=Fri Dec 01 19:11:52 CST 2017]
         */
	}

	@Test
	public void testReduceNumber() {
		//fail("Not yet implemented");
		Date killTime = new Date();
		int updateCount=seckillDao.reduceNumber(1000L, killTime);
		System.out.println("updateCount="+updateCount);
		//updateCount=0
	}

	
}
