package dev.rost.afterthrowingtwice;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mockingDetails;

@SpringBootTest
class AfterThrowingTwiceApplicationTests {

	@Autowired
	AdvisedService service;

	@SpyBean
	AdvisedServiceAspect aspect;


	@Test
	@DisplayName("when: AdvisedService#doSomething invoked ==> then: AdvisedServiceAspect works twice")
	void test() {
		assertThrows(RuntimeException.class, service::doSomething);

		then(aspect).should().afterThrowingException(any(RuntimeException.class));
		then(aspect).should().afterThrowingException(any(Exception.class));
		assertThat(mockingDetails(aspect).getInvocations().size())
				.isEqualTo(2);
	}
}
