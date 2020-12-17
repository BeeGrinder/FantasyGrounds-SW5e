## SW5e Module Generator

This will read the SW5e website API data and generate a Fantasy Grounds module.

#### Current state of development

__EXTREME__  early alpha.  Most things are hard-coded and sloppy.  I would not use this if I were you.

----
#### Data Acquisition 

A design decision was made to not directly grab the data from the SW5e API.  By downloading the JSON data into a local file, we can track changes over time and get a better idea how these changes might affect our modules.

Get Items(Equipment) from [SW5e Equipment API](https://sw5eapi.azurewebsites.net/api/equipment)

Get Spells(Powers) from [SW5e Power API](https://sw5eapi.azurewebsites.net/api/power)

Save into the root folder of the project with the names **equipment.json** and **spells.json**.

I "prettify" the data files and sort by the name field using this [online JSON editor](http://jsoneditoronline.org/)