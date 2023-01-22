package application;

import java.util.ArrayList;

public class file extends Composit{
	String extension;
	long size;
	public String getExtension() {
		return extension;
	}
	public void setExtension(String extension) {
		this.extension = extension;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public file(String name, String extension, long size) {
		super(name);
		this.extension = extension;
		this.size = size;
	}
	public void add(Composit c) { }
	public ArrayList<Composit> getSubFile() {
		return null;
		//throw new UnsupportedOperationException();
	}
	public String display() {
		return(" -"+name + "("+ size+")"+"\n");
		
		
	}

}
