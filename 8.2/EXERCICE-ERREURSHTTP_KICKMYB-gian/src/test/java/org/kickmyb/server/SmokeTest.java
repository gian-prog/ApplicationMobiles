package org.kickmyb.server;

import org.junit.jupiter.api.Test;
import org.kickmyb.server.account.ControllerAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
@ActiveProfiles("test")
class SmokeTest {

	@Autowired
	private ControllerAccount controller;

	@Test
	void contextLoads() throws Exception {
		assertThat(controller).isNotNull();
	}
}