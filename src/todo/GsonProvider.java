package todo;

import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;

import com.google.gson.*;
import com.sun.jersey.core.provider.*;

@Provider
public class GsonProvider extends AbstractMessageReaderWriterProvider<Object> {
	@Override
	public boolean isReadable(Class<?> cls, Type type, Annotation[] annotations, MediaType mediaType) {
		return true;
	}
	@Override
	public Object readFrom(Class<Object> cls, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> headers, InputStream in) throws IOException, WebApplicationException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean isWriteable(Class<?> cls, Type type, Annotation[] annotations, MediaType mediaType) {
		return true;
	}
	@Override
	public void writeTo(Object object, Class<?> cls, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> headers, OutputStream out) throws IOException, WebApplicationException {
		out.write(gson.toJson(object).getBytes());
	}
	static Gson gson = new GsonBuilder().setPrettyPrinting().create();
}