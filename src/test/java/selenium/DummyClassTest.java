package selenium;

import org.apache.logging.log4j.*;
import org.testng.annotations.Test;

public class DummyClassTest {

	private static Logger log=LogManager.getLogger(DummyClassTest.class.getName());
	@Test
	public void dummymethod1() {
		// TODO Auto-generated method stub
        log.info("This is just for logInfo test for 1");
		
		log.error("This is just for logError test for 1");
		
		log.fatal("This is just for logFatal test for 1");
		
		log.debug("This is just for logDebug test for 1");
		
		System.out.println("print method2");
		
		String str;
		
	}

}
