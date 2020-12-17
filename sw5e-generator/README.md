## SW5e Module Generator

This will read the SW5e website API data and generate a Fantasy Grounds module.

#### Current state of development

__EXTREME__  early alpha.  Most things are hard-coded and sloppy.  I would not use this if I were you.

----
#### Setup and Data Acquisition 

A design decision was made to not directly grab the data from the SW5e API.  By downloading the JSON data into a local file, we can track changes over time and get a better idea how these changes might affect our modules.

Get Items(Equipment) from [SW5e Equipment API](https://sw5eapi.azurewebsites.net/api/equipment)

Get Spells(Powers) from [SW5e Power API](https://sw5eapi.azurewebsites.net/api/power)

Save into the root folder of the project with the names **equipment.json** and **spells.json**.

I "prettify" the data files and sort by the name field using this [online JSON editor](http://jsoneditoronline.org/)

#### Screen Layout

__Module Name__ 

This field contains the name you wish your module to be published as.  This name will appear in your Fantasy Grounds (FG) Library list.

__As Folder__ 

This selections turns on the development mode.  

* When *off* it will create a module file and place it in the folder indicated by the *Module Folder* field.
	* If a developer mode folder has been created prior to the *off* build, the folder will be removed.
* When *on* it will create the module files in a folder with the *Module Name* in the folder indicated by the *Module Folder* field.
	* If a standard module file has been created prior to the *on" build, the file will be removed.



