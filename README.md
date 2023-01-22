# -CompositionDesignPatternApplication
a GUI client application using by which you can choose a certain folder. Once you select a folder, you should recursively traverse all of its content
\
\
File/Folder combination is a typical example of the composite design pattern. A file has a name, size, extension. A folder has similar attribute (without an extension) plus a list of files or other folders. You are required to write a demonstration application that traverses files and folders in a selected directory. 
\
2.1.	Class diagram	

Design a class diagram showing the above mentioned structure using the composite design pattern.
\
\
2.2.	Traverse a certain folder and read the contents	
\
Implement a GUI client application using by which you can choose a certain folder (see the image below). Once you select a folder, you should recursively traverse all of its contents (files and folders) and fill the required information as follows:		
•	Folder	: only name
•	File	: name, size, extension
After that, your application should fill the tree view with the selected folder and all sub folders. Once you select one of the folders in the tree view, you should show a detailed info about its contents in the output window. 
After traversing, your application should traverse the created structure (your structure) again and calculate the size of all folders by single line call. As an output of this task, show only the code to calculate the size and also a sample output. 
\
\
![image](https://user-images.githubusercontent.com/106669623/213929566-8248f2b3-9941-4cf2-a5a5-d7e716c3c5ff.png)
