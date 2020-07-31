# A5_SEG2105
Final Assignment for SEG2105. Sokoban: The Game

About the Code:
The language used to create this game is Java and to create the UI, I have used something called java
applets which is somewhat similar to Android Studios. There are a lot of built in Classes like JButton,
Panel, JLable, JMenuBar and Built-in functions such as .add .setActionListener .setActionCommand .setLayout etc.
These functions/classes helped me create the UI for the game and really helped me to portray my ideas on the 
screen. The java code mainly consists of for loops and 2D array operations like setting the index value to something else,
incrementing the index value of the array, etc. Basic java coding but really helpful in making of this game and anybody can
understand it if they have the basic knowledge of java.

Hints on how to Modify the system:
If you wanted to add something lets say an undo button, then you create a JButton and label it "Undo"
and add an Actionlistener and ActionCommand so that the button will some operation to it. And under actionPerformed 
method you can call the button and either have the undo function codded there or make another undo function like how
I did for the reset button and then call it under that "command intialization". The idea behind making this button would
simply be that if the button is pressed than set the array's character block to its previous postion which would mean
decrementing the index of that specific character and the block that the character moved.

Layout/Design:
My design inspiration was mainly from the game that I used to play when I was a kid. The applet is 300 in width and 
200 in heightI googled some grid levels for Sokoban and based on that I arranged the 2D array to make it look like the grid. 
Each number represent an image that is displayed as a block. The images are picked from Google Images. The background 
color was also decided by me using Paint. The instructions and all the written aspect of the game were all done by me. 

To Run the Applet:
In your command prompt navigate to where the assignment folder is located and make sure the .java file is there
Then compile the java program by typing: javac FinalGame.java
Then in the command prompt type: appletviewer FinalGame.html
In the folder there already exists a FinalGame.html file which is created from my java compiler so you would not need to create another.
and after typing that command a window(applet) should pop displaying my splash screen.
In the event that the .html file is not there then use this: 

//<html>
  <head>
    <title>
       The FinalGame applet
    </title>
  </head>
  <body>
    <h2>
      Here is the FinalGame applet
    </h2>
    <hr>
    <applet code="FinalGame.class" width="300" height="200">
    </applet>
    <hr>
  </body>
//<html>


and save it as .html file in the same folder and compile it using the command that I mentioned above
In this applet if you notice you will have a navigation option in the top bar and you can navigate to any screen you like.

I really enjoyed programming this and making my own game.

Thank you
