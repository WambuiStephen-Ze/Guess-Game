Pet Guess Game
Description
Pet Guess Game is a simple Java Swing GUI application where the user guesses which pet is shown in the image. The game randomly displays an image of a pet, and the player must choose the correct pet name using radio buttons.
If the user guesses correctly, a success message is displayed and a new game starts. If the user guesses incorrectly, the number of attempts decreases. After 3 wrong attempts, the game locks for 30 seconds before restarting.

Features
Graphical User Interface using Java Swing
Random pet image selection
Multiple choice answers using radio buttons
Maximum of 3 attempts per round
Game locks for 30 seconds after 3 wrong guesses
Automatic restart after lock period

Pets in the Game
The game randomly selects one of the following pets:
Bird
Cat
Dog
Rabbit
Pig

How the Game Works
The program starts and displays a random pet image.
The player selects the pet name using the radio buttons.
If the guess is correct:
A "Correct! Well done." message appears.
A new round starts.
If the guess is wrong:
The attempts counter increases.
The user is informed how many attempts remain.
After 3 incorrect guesses:
The game locks for 30 seconds.
Buttons are disabled during the lock.
A new round automatically starts after the timer.

Requirements
Java JDK 8 or later
Pet images saved in the same project folder

Required image files:
bird.jpeg
cat.jpeg
dog.jpeg
rabbit.jpeg
pig.jpeg
How to Run the Program
Compile
javac PetGuessGame.java

Run
java PetGuessGame

Project Structure
PetGuessGame.java
bird.jpeg
cat.jpeg
dog.jpeg
rabbit.jpeg
pig.jpeg


Technologies Used
Java
Java Swing (GUI)
Event Handling
Random Class
