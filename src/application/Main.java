package application;
	
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	String text="";
	 Composit test;
	  TreeView <String>treeView ;
	  TreeItem<String> cRoot;
	  public Composit found=null;
	  Stage primaryStage;
	  BorderPane root;
	@Override
	
	public void start(Stage primaryStage) {
		try {
			 root = new BorderPane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		   
		     //button
		     Button b= new Button("Select Folder");
		     root.setBottom(b);
		     
		     //text area 
		     TextArea textArea = new TextArea();
		     textArea.setEditable(false);
		     root.setCenter(textArea);
		     
		     //stage
			primaryStage.setScene(scene);
			primaryStage.show();
			
			b.setOnAction(event ->{
				 java.nio.file.Path dir = Paths.get(Path());
				 File f=dir.toFile();
			     treeView = new TreeView<>();			  
			     test = new Folder(f.getName());
			     cRoot = new TreeItem<>(test.getName(),getRootIcon());
			     treeView.setRoot(cRoot);
			     setTree1(test, f);
			     setItem(test,cRoot);
			     root.setLeft(treeView);
//				String s=treeView.getSelectionModel().getSelectedItem().getValue();
//				find(s,test);
				//found.display();
//				text=found.display();
				SetText(test);
				textArea.setText(text);
				});
			 
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	
	
//	TreeView<String> setTree() {
//        treeView = new TreeView<>();
//  
//         test = new Folder("Test");
//        cRoot = new TreeItem<>(test.getName(),getRootIcon());
//        treeView.setRoot(cRoot);
//        Composit A = new Folder("Folder A");
//        Composit B = new Folder("Folder B");
//        Composit C = new Folder("Folder c");
//        Composit AA = new Folder("Folder aa");
//	       
//	        AA.add(new file("image1.png",".png",512));
//	        A.add(new file("image2.png",".png",365));
//	        A.add(AA);
//	        B.add(new file("image3.png",".png",1750));
//	        C.add(new file("image4.png C",".png",900));
//	        test.add(A);
//	        test.add(B);
//	        test.add(C);
//	        //test.display();
//	        setsize(test);
//	        setItem(test,cRoot);
//	       
//		return treeView;
//		
//		
//	}
	void setItem(Composit c, TreeItem<String> node) {
		for(Composit com :c.getSubFile()) {
			
			if (com instanceof file) {
				node.getChildren().add(new TreeItem<>(com.name));
			//System.out.print(com.name);
				}
			else{
				TreeItem<String> subnode=new TreeItem<>(com.name,getRootIcon());
				//System.out.print(com.name);
				node.getChildren().add(subnode);
					setItem((Folder)com, subnode);
					
			}
		}
		
		
		
		
		
	}
	 public ImageView getRootIcon() {
		 	ImageView img=new ImageView(new Image(getClass().getResourceAsStream("folder.png")));
		 	img.setFitHeight(10);
		 	img.setFitWidth(10);
	        return img ;
	    }

	 void find(String s,Composit root) {
		 if(s.equals(root.getName()))
			 found=root;
		 else {
			 try {
				 for(Composit com :root.getSubFile()) {
					 if(s.equals(com.getName()))
						 found= com;
					 
					 if(com instanceof file)
						 continue;
					  find(s,com);
					 
					 
				 
				 }
				}
				catch(UnsupportedOperationException e) {
					System.out.println("nnnnnnnnnn");
				
				}
		 }

		
	}
	 void setsize(Composit root) {
		 if(root instanceof file);
		 else {
		 long i=0;
		 for(Composit com :root.getSubFile()) {
			
			 setsize(com);
			 i=i+com.getSize();
		 
		 } 
		 root.setSize(i);
		 }
	 }
	 void SetText(Composit root) {
		 if(root instanceof file)
		 	text=text+"\t"+root.display();
		 else {
		 for(Composit com :root.getSubFile()) {
			 text=text+"\t"+com.display();
			 SetText(com);
			 
		 
		 }
		 } 
	 }
	 String Path() {
		 DirectoryChooser directoryChooser = new DirectoryChooser();
	        directoryChooser.setInitialDirectory(new File("src")); 
	            File selectedDirectory = directoryChooser.showDialog(primaryStage);
	            return selectedDirectory.getAbsolutePath();
	        	 
	 }
	 void setTree1(Composit root, File f) {
		 
		 
	        File[] contents = f.listFiles();
	        for(File fil:contents) {
	        	if(fil.isDirectory()) {
	        		 Composit sub = new Folder(fil.getName());
	        		setTree1( sub,fil);
	        		root.add(sub);
	        		}
	        	else {
	        		Composit sub=new file(fil.getName(),".png",fil.length());
	        		root.add(sub);
	        		}
	        }

	        
	 }
	 }
