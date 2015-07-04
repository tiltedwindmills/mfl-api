package org.tiltedwindmills.fantasy.mfl.services.impl;

import java.util.Calendar;

import org.junit.Test;
import org.tiltedwindmills.fantasy.mfl.services.exception.MFLServiceException;


/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.services.impl.AbstractJsonServiceImpl}.
 *
 * @author John Daniel
 */
public class AbstractJsonServiceImplTest {

	private static final String MOCK_SERVICE_ID = "mock service";

	/**
	 * Simple mock class we'll use as a concrete instance of the abstract parent.
	 *
	 * @author John Daniel
	 */
	class MockJsonServiceImpl extends AbstractJsonServiceImpl { }

	@Test
	public void validateYearTest() {

		MockJsonServiceImpl serviceImpl = new MockJsonServiceImpl();
		serviceImpl.validateYear(Calendar.getInstance().get(Calendar.YEAR), MOCK_SERVICE_ID);

		// simply getting through is evidence of success
	}

	@Test(expected = MFLServiceException.class)
	public void validateYearTest_EarlyYear() {

		MockJsonServiceImpl serviceImpl = new MockJsonServiceImpl();
		serviceImpl.validateYear(1979, MOCK_SERVICE_ID);
	}

	@Test(expected = MFLServiceException.class)
	public void validateYearTest_LateYear() {

		MockJsonServiceImpl serviceImpl = new MockJsonServiceImpl();
		serviceImpl.validateYear(Calendar.getInstance().get(Calendar.YEAR) + 1, MOCK_SERVICE_ID);
	}

	@Test
	public void validateLeagueIdTest() {

		MockJsonServiceImpl serviceImpl = new MockJsonServiceImpl();
		serviceImpl.validateLeagueId(10000, MOCK_SERVICE_ID);
		serviceImpl.validateLeagueId(99999, MOCK_SERVICE_ID);

		// simply getting through is evidence of success
	}

	@Test(expected = MFLServiceException.class)
	public void validateLeagueIdTest_Under5Digits() {

		MockJsonServiceImpl serviceImpl = new MockJsonServiceImpl();
		serviceImpl.validateLeagueId(9999, MOCK_SERVICE_ID);
	}

	@Test(expected = MFLServiceException.class)
	public void validateLeagueIdTest_Over5Digits() {

		MockJsonServiceImpl serviceImpl = new MockJsonServiceImpl();
		serviceImpl.validateLeagueId(100000, MOCK_SERVICE_ID);
	}

	@Test
	public void validateServerIdTest() {

		MockJsonServiceImpl serviceImpl = new MockJsonServiceImpl();
		serviceImpl.validateServerId("1", MOCK_SERVICE_ID);
		serviceImpl.validateServerId("99", MOCK_SERVICE_ID);
	}

	@Test(expected = MFLServiceException.class)
	public void validateLeagueIdTest_Null() {

		MockJsonServiceImpl serviceImpl = new MockJsonServiceImpl();
		serviceImpl.validateServerId(null, MOCK_SERVICE_ID);
	}

	@Test(expected = MFLServiceException.class)
	public void validateLeagueIdTest_Empty() {

		MockJsonServiceImpl serviceImpl = new MockJsonServiceImpl();
		serviceImpl.validateServerId("", MOCK_SERVICE_ID);
	}

	@Test(expected = MFLServiceException.class)
	public void validateLeagueIdTest_Alphabetic() {

		MockJsonServiceImpl serviceImpl = new MockJsonServiceImpl();
		serviceImpl.validateServerId("1a", MOCK_SERVICE_ID);
	}

	@Test(expected = MFLServiceException.class)
	public void validateLeagueIdTest_TooManyDigits() {

		MockJsonServiceImpl serviceImpl = new MockJsonServiceImpl();
		serviceImpl.validateServerId("100", MOCK_SERVICE_ID);
	}
}
