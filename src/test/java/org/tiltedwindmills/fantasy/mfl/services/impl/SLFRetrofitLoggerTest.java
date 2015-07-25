package org.tiltedwindmills.fantasy.mfl.services.impl;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.varia.NullAppender;
import org.junit.After;
import org.junit.Test;

import retrofit.RestAdapter.LogLevel;

/**
 * Tests for {@code org.tiltedwindmills.fantasy.mfl.services.impl.SLFRetrofitLogger}.
 *
 * @author John Daniel
 */
public class SLFRetrofitLoggerTest {


	@After
	public void after() {

		// clear our config after each test.
		LogManager.resetConfiguration();
	}

	@Test
	public void testLog() {

		// not totally sure why this is necessary, but shuts up the SLF "no appenders" noise.
		Logger.getRootLogger().addAppender(new NullAppender());

		SLFRetrofitLogger logger = new SLFRetrofitLogger();
		logger.log("this is a test");

		// not really sure what to do here other than confirm that we didn't throw an exception.
		// testing that the logger actually functioned properly is outside the scope of a "unit" test.
		assert(true);
	}

	@Test
	public void testGetLogLevel_All() {

		Logger log = Logger.getRootLogger();
		log.setLevel(Level.ALL);
		assertTrue(log.isTraceEnabled());
		assertEquals(LogLevel.FULL, SLFRetrofitLogger.getLogLevel());
	}

	@Test
	public void testGetLogLevel_Trace() {

		Logger log = Logger.getRootLogger();
		assertFalse(log.isTraceEnabled());
		log.setLevel(Level.TRACE);
		assertTrue(log.isTraceEnabled());
		assertEquals(LogLevel.FULL, SLFRetrofitLogger.getLogLevel());
	}

	@Test
	public void testGetLogLevel_Debug() {

		Logger log = Logger.getRootLogger();
		log.setLevel(Level.DEBUG);
		assertTrue(log.isDebugEnabled());
		assertEquals(LogLevel.FULL, SLFRetrofitLogger.getLogLevel());
	}

	@Test
	public void testGetLogLevel_Info() {

		Logger log = Logger.getRootLogger();
		log.setLevel(Level.INFO);
		assertTrue(log.isInfoEnabled());
		assertEquals(LogLevel.BASIC, SLFRetrofitLogger.getLogLevel());
	}

	@Test
	public void testGetLogLevel_Warn() {

		Logger log = Logger.getRootLogger();
		log.setLevel(Level.WARN);
		assertTrue(log.isEnabledFor(Level.WARN));
		assertFalse(log.isEnabledFor(Level.INFO));
		assertEquals(LogLevel.NONE, SLFRetrofitLogger.getLogLevel());
	}

	@Test
	public void testGetLogLevel_Error() {

		Logger log = Logger.getRootLogger();
		log.setLevel(Level.ERROR);
		assertTrue(log.isEnabledFor(Level.ERROR));
		assertFalse(log.isEnabledFor(Level.WARN));
		assertEquals(LogLevel.NONE, SLFRetrofitLogger.getLogLevel());
	}
}
