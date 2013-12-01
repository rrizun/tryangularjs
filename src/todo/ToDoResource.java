package todo;

import java.io.*;
import java.util.*;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import com.google.common.collect.*;

class ToDo {
	private int id;
	private String name;
	private long size;
	private long ts;
	public ToDo(int id, String name, long size, long ts) {
		this.id = id;
		this.name = name;
		this.size = size;
		this.ts = ts;
	}
}

@Path("/")
public class ToDoResource {
	@GET
	@Path("/files")
	public List<ToDo> files() {
		List<ToDo> response = Lists.newArrayList();
		File[] files = new File("/tmp").listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.isFile())
					response.add(new ToDo(++id, file.getName(), file.isFile()?file.length():-1, System.currentTimeMillis()));
			}
		}
		return response;
	}
	private int id;
}
