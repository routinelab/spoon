package spoon;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class ApplicationTests {

	private static final Logger log = LoggerFactory.getLogger(ApplicationTests.class);

	@Autowired
	ApplicationContext context;

	@Test
	public void contextLoads() {

		String[] beans = context.getBeanDefinitionNames();
		Arrays.sort(beans);

		log.info("-------------------------------------------------------");
		for (String bean : beans) {
			log.info(bean);
		}
		log.info("-------------------------------------------------------");

	}

}
