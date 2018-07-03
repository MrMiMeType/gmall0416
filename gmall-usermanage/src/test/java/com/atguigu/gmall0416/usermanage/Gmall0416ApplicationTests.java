package com.atguigu.gmall0416.usermanage;
import com.atguigu.gamll0416.service.UserManageService;
import com.atguigu.gmall0416.bean.UserAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Gmall0416ApplicationTests {

	@Autowired
	UserManageService userManageService;

	@Test
	public void showAddressList() {
		List<UserAddress> userAddressList = userManageService.getUserAddressList("2");
		for (UserAddress userAddress : userAddressList) {
			System.err.println("userAddress = " + userAddress);
		}
	}

}
