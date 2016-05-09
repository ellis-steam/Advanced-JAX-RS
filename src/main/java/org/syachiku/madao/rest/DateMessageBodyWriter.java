package org.syachiku.madao.rest;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Date;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.TEXT_PLAIN)
public class DateMessageBodyWriter implements MessageBodyWriter<Date>{

	@Override
	public long getSize(Date t, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		// TODO Auto-generated method stub
		//method deprecated, change return 0 to return -1 and forget it.
		return -1;
	}

	@Override
	public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
		return Date.class.isAssignableFrom(type);
	}

	@Override
	public void writeTo(Date date, Class<?> type,
			Type type1, Annotation[] antns,
			MediaType mt, MultivaluedMap<String, Object> mm, OutputStream out)
			throws IOException, WebApplicationException {

			out.write(date.toString().getBytes());
	}
	
}
