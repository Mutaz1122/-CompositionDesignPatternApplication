package application;

import java.util.ArrayList;

abstract class Composit {
public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

String name;
long size;
public long getSize() {
	return size;
}

public void setSize(long size) {
	this.size = size;
}

public Composit(String name) {
	super();
	this.name = name;
}
abstract void add(Composit c);
abstract ArrayList<Composit> getSubFile();
abstract String  display();
}
