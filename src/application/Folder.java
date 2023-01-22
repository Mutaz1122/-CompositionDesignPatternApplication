package application;

import java.util.ArrayList;

import javafx.scene.control.TreeItem;

public class Folder extends Composit {
	public Composit found=null;
	ArrayList<Composit> SubFile = new ArrayList<Composit>();
	long size=0;
	
	
	public Folder(String name) {
		super(name);
	}

public void add(Composit c) {
	
	SubFile.add(c);
//	for(Composit com :getSubFile()) {
		size=size+c.getSize();	
//}
	
	
}

public long getSize() {
	return size;
}

public void setSize(int size) {
	this.size = size;
}

public ArrayList<Composit> getSubFile() {
	return SubFile;
}

public Composit getFound() {
	return found;
}

public void setFound(Composit found) {
	this.found = found;
}

public void setSubFile(ArrayList<Composit> subFile) {
	SubFile = subFile;
}
public String display() {
	return (name + "("+ size+")"+"\n");
//	for(Composit com :getSubFile()) {
//		com.display();
//
//	
//	
//}
	
}

}