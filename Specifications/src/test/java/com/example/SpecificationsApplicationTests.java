package com.example;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpecificationsApplication.class)
@WebAppConfiguration
public class SpecificationsApplicationTests {

	@Autowired
	private UserRepository repository;

	private User userJohn;
	private User userTom;

	@Before
	public void init() {
		userJohn = new User();
		userJohn.setFirstName("John");
		userJohn.setLastName("Doe");
		userJohn.setEmail("john@doe.com");
		userJohn.setAge(22);
		repository.save(userJohn);

		userTom = new User();
		userTom.setFirstName("Tom");
		userTom.setLastName("Doe");
		userTom.setEmail("tom@doe.com");
		userTom.setAge(26);
		repository.save(userTom);
	}

	@Test
	public void givenLast_whenGettingListOfUsers_thenCorrect() {
		UserSpecification spec =
				new UserSpecification(new SearchCriteria("lastName", ":", "doe"));

		List<User> results = repository.findAll(spec);

//		assertThat(userJohn, isIn(results));
//		assertThat(userTom, isIn(results));
	}


	@Test
	public void givenFirstAndLastName_whenGettingListOfUsers_thenCorrect() {
		UserSpecification spec1 =
				new UserSpecification(new SearchCriteria("firstName", ":", "john"));
		UserSpecification spec2 =
				new UserSpecification(new SearchCriteria("lastName", ":", "doe"));

		List<User> results = repository.findAll(Specifications.where(spec1).and(spec2));

//		assertThat(userJohn, isIn(results));
//		assertThat(userTom, not(isIn(results)));
	}

	@Test
	public void givenLastAndAge_whenGettingListOfUsers_thenCorrect() {
		UserSpecification spec1 =
				new UserSpecification(new SearchCriteria("age", ">", "25"));
		UserSpecification spec2 =
				new UserSpecification(new SearchCriteria("lastName", ":", "doe"));

		List<User> results =
				repository.findAll(Specifications.where(spec1).and(spec2));

//		assertThat(userTom, isIn(results));
//		assertThat(userJohn, not(isIn(results)));
	}

	@Test
	public void givenWrongFirstAndLast_whenGettingListOfUsers_thenCorrect() {
		UserSpecification spec1 =
				new UserSpecification(new SearchCriteria("firstName", ":", "Adam"));
		UserSpecification spec2 =
				new UserSpecification(new SearchCriteria("lastName", ":", "Fox"));

		List<User> results =
				repository.findAll(Specifications.where(spec1).and(spec2));

//		assertThat(userJohn, not(isIn(results)));
//		assertThat(userTom, not(isIn(results)));
	}

	@Test
	public void givenPartialFirst_whenGettingListOfUsers_thenCorrect() {
		UserSpecification spec =
				new UserSpecification(new SearchCriteria("firstName", ":", "jo"));

		List<User> results = repository.findAll(spec);

//		assertThat(userJohn, isIn(results));
//		assertThat(userTom, not(isIn(results)));
	}
}
