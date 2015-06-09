package org.tiltedwindmills.fantasy.mfl.services.exception;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Test;


public class MFLServiceExceptionTest {

	@Test
	public void emptyConstructorTest() {

		try {
			throw new MFLServiceException();

		} catch (Throwable t) {

			assertThat(t, is(not(nullValue())));
			assertThat(t, instanceOf(MFLServiceException.class));
			assertThat(t.getCause(), is(nullValue()));
			assertThat(t.getMessage(), is(nullValue()));
		}
	}

	@Test
	public void stringConstructorTest() {

		try {
			throw new MFLServiceException("An exception");

		} catch (Throwable t) {

			assertThat(t, is(not(nullValue())));
			assertThat(t, instanceOf(MFLServiceException.class));
			assertThat(t.getCause(), is(nullValue()));
			assertThat(t.getMessage(), is("An exception"));
		}
	}

	@Test
	public void throwableConstructorTest() {

		try {

			OutOfMemoryError outOfMemoryError = new OutOfMemoryError("a child exception");
			throw new MFLServiceException(outOfMemoryError);

		} catch (Throwable t) {

			assertThat(t, is(not(nullValue())));
			assertThat(t, instanceOf(MFLServiceException.class));
			assertThat(t.getCause(), instanceOf(OutOfMemoryError.class));
			assertThat(t.getCause().getMessage(), is("a child exception"));
		}
	}

	@Test
	public void stringAndThrowableConstructorTest() {

		try {

			Throwable throwable = new Throwable("a child exception");
			throw new MFLServiceException("a custom message", throwable);

		} catch (Throwable t) {

			assertThat(t, is(not(nullValue())));
			assertThat(t, instanceOf(MFLServiceException.class));
			assertThat(t.getCause(), instanceOf(Throwable.class));
			assertThat(t.getCause().getMessage(), is("a child exception"));
			assertThat(t.getMessage(), is("a custom message"));
		}
	}
}
