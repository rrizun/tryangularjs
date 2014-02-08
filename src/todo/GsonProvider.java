package todo;

import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.*;

import com.google.common.io.*;
import com.google.gson.*;

@Provider
public class GsonProvider implements MessageBodyReader<Object>, MessageBodyWriter<Object> {
  @Override
  public boolean isReadable(Class<?> cls, Type type, Annotation[] annotations, MediaType mediaType) {
    return true;
  }
  @Override
  public Object readFrom(Class<Object> cls, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> headers, InputStream in) throws IOException, WebApplicationException {
    return gson.fromJson(new String(ByteStreams.toByteArray(in)), cls);
  }
  @Override
  public boolean isWriteable(Class<?> cls, Type type, Annotation[] annotations, MediaType mediaType) {
    return true;
  }
  @Override
  public long getSize(Object object, Class<?> cls, Type type, Annotation[] annotations, MediaType mediaType) {
    return -1;
  }
  @Override
  public void writeTo(Object object, Class<?> cls, Type type, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> headers, OutputStream out) throws IOException, WebApplicationException {
    out.write(gson.toJson(object).getBytes());
  }
  static Gson gson = new GsonBuilder().setPrettyPrinting().create();
}