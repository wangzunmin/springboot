import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zun.configure.ApplicationConfiguration;
import com.zun.entity.User;
import com.zun.mapper.UserMapper;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationConfiguration.class)
public class Spring {

	@Autowired
	private UserMapper userMapper;
	
	@Test
	public void userTest(){
//		int insert = userMapper.insert("小红", "xiaohong");
		User findByName = userMapper.findByName("小明");
//		System.out.println(insert);
		System.out.println(findByName);
	}
}
