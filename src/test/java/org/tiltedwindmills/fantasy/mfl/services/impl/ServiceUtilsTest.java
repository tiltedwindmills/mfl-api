package org.tiltedwindmills.fantasy.mfl.services.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.nullValue;

import org.joda.time.DateTime;
import org.joda.time.DateTimeUtils;
import org.junit.Test;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.services.impl.ServiceUtils}.
 *
 * @author John Daniel
 */
public class ServiceUtilsTest {

	@Test
	public void safeServerIdStringTest() {
		assertThat(ServiceUtils.safeServerId("1"), is("1"));
	}

	@Test
	public void safeServerIdTestStringNull() {
		assertThat(ServiceUtils.safeServerId(null), is(""));
	}

	@Test
	public void safeServerIdTestStringEmpty() {
		assertThat(ServiceUtils.safeServerId(""), is(""));
	}

	@Test
	public void safeServerIdTestStringZero() {
		assertThat(ServiceUtils.safeServerId("0"), is(""));
	}

	@Test
	public void safeServerIdIntTest() {
		assertThat(ServiceUtils.safeServerId(1), is("1"));
	}

	@Test
	public void safeServerIdTestIntZero() {
		assertThat(ServiceUtils.safeServerId(0), is(""));
	}

	@Test
	public void safeServerIdTestIntNegative() {
		assertThat(ServiceUtils.safeServerId(-1), is(""));
	}

	@Test
	public void getNowTest() {

		DateTime mockDateTime = new DateTime(2015, 3, 13, 6, 52);
		DateTimeUtils.setCurrentMillisFixed(mockDateTime.getMillis());

		String mockDateString = ServiceUtils.getNow();
		assertThat(mockDateString, is("2015-03-13 6:52:00"));

		// return Joda to normal operations.
		DateTimeUtils.setCurrentMillisSystem();
	}

	@Test
	public void getStringForCalendarTest() {

		DateTime dateTime = new DateTime(2015, 4, 16, 8, 2);

		String mockDateString = ServiceUtils.getStringForCalendar(dateTime);
		assertThat(mockDateString, is("2015-04-16 8:02:00"));
	}

	@Test
	public void getCalendarForStringTest() {

		DateTime result = ServiceUtils.getCalendarForString("2015-04-16 8:02:00");

		assertThat(result, is(not(nullValue())));
		assertThat(result.getYear(), is(2015));
		assertThat(result.getMonthOfYear(), is(4));
		assertThat(result.getDayOfMonth(), is(16));
		assertThat(result.getHourOfDay(), is(8));
		assertThat(result.getMinuteOfHour(), is(2));
	}

	@Test
	public void getCalendarForStringTestParseFailure() {

		DateTime result = ServiceUtils.getCalendarForString("some unparseable string");
		assertThat(result, is(nullValue()));
	}

	@Test
	public void getCalendarForStringTestNull() {

		DateTime result = ServiceUtils.getCalendarForString(null);
		assertThat(result, is(nullValue()));
	}

	@Test
	public void getCalendarForStringTestEmpty() {

		DateTime result = ServiceUtils.getCalendarForString("");
		assertThat(result, is(nullValue()));
	}

}
