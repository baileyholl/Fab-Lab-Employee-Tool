# Fab-Lab-Employee-Tool
A simple java tool that stores information on employees and can visually display those who are working in a layout that allows students to quickly see who is available to assist them on certain machinery or software. 

# Launch
When the application is started, two screens will load. One scene is composed of only 6 boxes while the other scene has 6 boxes, a list and menu options.

The screen with 6 boxes is the *display screen*. This is the screen that is displayed on the TV through airplay. 
The other screen is the *edit screen*. This screen controls what displays on the *display screen* and provides tools to change and add new employees to the lists.
Displays are synced between both screens.

# Adding new files
To add new data, go to Edit -> Add.
A new screen will appear that will prompt for a name, description, and image. The recommended image size is 200x266 otherwise the display may not work properly.
Hitting OK will create the local text and image files. These files can be accessed in folders by going to File -> Open Folders.
**Important:** Once new files are added, you MUST refresh the view through File -> Refresh. This forces the local list to update and repull all data into the application.

# Editing Existing Files
Currently, the only way to edit an existing description or image is to go to Edit -> Add and use the same name as the file you want to edit. Alternatively, you can edit the files directly found in their folders through File -> Open Folders. Files are stored with the name given in the original creation. Any edits or new files must be readded to the list using Edit -> Refresh.

# Displaying Employee Data
Once files have been added, employee data can be moved to display by clicking on a name from the list and going to Edit -> Move. The image and description will appear in the next available box. The display may be removed by going to Edit -> Delete -> Box(N). This will remove the data from the display box but will not delete local data. Data displayed on the edit screen is also displayed on the *display screen*.
