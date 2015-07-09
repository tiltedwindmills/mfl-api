package org.tiltedwindmills.fantasy.mfl;

import java.util.ArrayList;

import retrofit.RetrofitError;
import retrofit.client.Header;
import retrofit.client.Response;

/**
 * Utility operations for testing with {@code Retrofit} library.
 *
 * @author John Daniel
 */
public final class RetrofitUtils {

	/* no public constructor for utils */
	private RetrofitUtils() { }

	/** Retrieves a silly generic error */
	public static final RetrofitError getDummyHttpError() {
		Response response = new Response("some url", 500, "some reason", new ArrayList<Header>(), null);
		RetrofitError error = RetrofitError.httpError("someUrl", response, null, null);
		return error;
	}
}