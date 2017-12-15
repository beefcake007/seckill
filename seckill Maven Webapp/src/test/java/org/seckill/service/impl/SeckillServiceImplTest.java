package org.seckill.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.entity.Seckill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml","classpath:spring/spring-service.xml"})
public class SeckillServiceImplTest {

	private final Logger logger=LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private SeckillService seckillService;
	
	@Test
	public void testGetSeckillList() {
		//fail("Not yet implemented");
		List<Seckill> list=seckillService.getSeckillList();
		logger.info("list={}",list);
	}

	@Test
	public void testGetById() {
		//fail("Not yet implemented");
		long id=1000;
		Seckill seckill=seckillService.getById(id);
		logger.info("seckill={}",seckill);
	}

	@Test
	public void testExportSeckillUrl() {
		//fail("Not yet implemented");
		long id=1000;
		Exposer exposer=seckillService.exportSeckillUrl(id);
		logger.info("exposer={}",exposer);
		//exposer=Exposer [exposed=true, md5=c2945686e8543f9898ecbf6bcaa3fea7, seckillId=1000, now=0, start=0, end=0]
	}

	@Test
	public void testExecuteSeckill() {
		//fail("Not yet implemented");
		long id=1000;
		long phone=15367898767L;
		String md5="c2945686e8543f9898ecbf6bcaa3fea7";
		try {
			SeckillExecution executtion=seckillService.executeSeckill(id, phone, md5);
			logger.info("execution={}",executtion);
		} catch (RepeatKillException e) {
			logger.info(e.getMessage());
		}catch (SeckillCloseException e) {
			logger.info(e.getMessage());
		}
		//execution=SeckillExecution [seckillId=1000, state=1, stateInfo=秒杀成功, successKilled=SuccessKilled [seckillId=1000, userPhone=15367898767, state=0, createTime=Sat Dec 02 16:46:10 CST 2017]]
	}
	
	//测试代码完整逻辑，注意可重复执行
	@Test
	public void testSeckillLogic() throws Exception{
		long id=1001;
		Exposer exposer=seckillService.exportSeckillUrl(id);
		if(exposer.isExposed()){
			logger.info("exposer={}",exposer);
			long phone=15367898767L;
			String md5=exposer.getMd5();
			try {
				SeckillExecution executtion=seckillService.executeSeckill(id, phone, md5);
				logger.info("execution={}",executtion);
			} catch (RepeatKillException e) {
				logger.info(e.getMessage());
			}catch (SeckillCloseException e) {
				logger.info(e.getMessage());
			}
		}else{
			//秒杀未开启
			logger.warn("exposer={}",exposer);
		}
	}

	@Test
	public void executeSeckillProcedure(){
		long seckillId=1000;
		long phone=12334565678L;
		Exposer exposer=seckillService.exportSeckillUrl(seckillId);
		if(exposer.isExposed()){
			String md5=exposer.getMd5();
			SeckillExecution execution=seckillService.executeSeckillProcedure(seckillId, phone, md5);
			logger.info(execution.getStateInfo());
		}
	}
}
