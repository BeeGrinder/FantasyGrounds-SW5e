![alt text](https://github.com/BeeGrinder/FantasyGrounds-SW5e/blob/master/SW5EBW.png "SW5e")
# FantasyGrounds-SW5e
#### A FantasyGrounds module to implement SW5e game

SW5e is a user created (Home-brew) set of Races, Classes, NPCs, etc. that works within the 5e ruleset.

[SW5e Website](https://sw5e.com/)

[SW5e Subreddit](https://www.reddit.com/r/sw5e/)

[SW5e Fantasy Grounds Forum Thread](https://www.fantasygrounds.com/forums/showthread.php?47628-SW5e-a-star-wars-home-brew-on-the-5e-rule-set)

---

|Sub-Project | Status | Notes |
| --- | --- | -- |
|SW5e Player Book.mod | Released. | Classes, Races, Backgrounds, Feats, Skills, etc. |
|SW5e Supplement.mod | Released. | Powers (Spells) and Items/Equipement |
|SW5e NPC Manual.mod | Released. | NPCs and some vehicles |
|Ruleset Extension | Released. | Fantasy Grounds Classic ruleset modifications extension |

See the FG Forum post for news about current projects and module changes underway.

---

__Fantasy Grounds Unity(FGU)__ : Please note this is not tested in FGU.  Use at your own risk.

---

### Fantasy Grounds User Information

#### Installation
##### Please Help - I need play testing done, please report any errors, omissions or typos.

* To install the module(s) for use in Fantasy Grounds, download the file(s) in the module directory of this project into your Fantasy Grounds modules directory *(...\Fantasy Grounds\modules)*.  Then load sw5e modules using the Library->Modules selections.

   Download module files from [here](https://github.com/BeeGrinder/FantasyGrounds-SW5e/tree/master/modules)
 
* To install the extension, download *__sw5e.ext__* and place in your extensions directory *(...\Fantasy Grounds\extensions)*. When creating/loading your campaign, make sure to select extension *__sw5e__* from the list.  Currently only works with FG Classic.

   Download the extension file from [here](https://github.com/BeeGrinder/FantasyGrounds-SW5e/tree/master/extensions)

* __*IMPORTANT:*__ Read the __Reference__ section of each module in Fantasy Grounds any notes or special instructions.

#### Creating your sw5e campaign

* When creating your new campaign in FG for SW5e, select the 5e rule-set (All the SW5e content is dependent on the base 5e rule-set).
* Once you select the 5e rule-set, the sw5e extension will appear in the extension window.  Select it.

  Note: It's best to only load SW5e modules and extensions. I cannot guarantee compatibility with other module or extensions.
* Once your campaign opens, go to *__Library__* then *__Modules__* and open the *__SW5e Player Book__*, *__SW5e Supplement__*, and *__SW5e NPC Manual__*.

__New Starship Rules__

These new rules basically has ships as complex as a player character with character sheets. I would suggest providing your players with their ship's sheet and using the FG interface for a star map, token movement, and dice rolling. But, at this time I don't know of a way to implement the starship combat of SW5e into the FG system.

### Developer Information

The *__par5e__* directory is for the text files that are parsed into the *__Player Book__* module and the "source" of the module content. The current player book module is 99% compiled using PAR5e v0.0.9-b62.  I've added a sed script to add the level 3 sub-class choices to the output XML.

The *__NPCEngineer__* directory is for the text files that are parsed into the *__NPC Book__* module and the "source" of the module content. [NPC Engineer website](http://www.masq.net/)

The *__supplement-mod__* directory contains all Force and Tech Powers (spells) and Items/Equipment source.  It is maintained through editing the source XML.

The *__ext-src__* dirctory is for the extension sources.

#### Release Goals
* Initial Release (V1.0)
   * Playable Races, Classes, Backgrounds, Feats, Equipment, Spells, NPCs from the sw5e PDF *__core__* documents.
   * If the data is readily available and easily parsed, some expanded content *__may__* be included.
   * Powers will still be called spells in the FG interface.

---

__EDITORIAL__

In my opinion Fantasy Grounds (FG) is one of the best TTRPG platforms available.  The ability to customize and modify the game rules and contents is unsurpassed.  The skeuomorphic interface receives a lot of criticism, but this issue just takes a little extra time to become familiar with the UI paradigm.  I have not seen another system with an equivalent level of gameplay automation.  The FG automation makes the GMs job much easier. 

Customizing FG is complex but powerful.  By learning how the rule system (Lua language scripts) and the data storage (XML files) are arranged, you can implement just about anything in this interface.  With the release of the Unity version, the future of this game system is significantly improved.  Especially if/when sound and animation are added. 

The SW5e ruleset should probably have its dependency on the FG 5e ruleset removed and converted to use the FG ruleset called “Core RPG”.  The Core RPG ruleset should be used as the base for SW5e because SW5e has deviated a lot from its 5e roots.  By moving to the Core RPG base, things like the space combat system and other features that are not well translated into the 5e ruleset could be implemented without having to figure out how to reengineer it through the true 5e ruleset. 

---
###### This project is not endorsed by, directly affiliated with, maintained, authorized, or sponsored by the SW5e project, Fantasy Grounds, Smiteworks, NPCEngineer, rob2e, or Wizards of the Coast. All product and company names are the registered trademarks of their original owners. The use of any trade name or trademark is for identification and reference purposes only and does not imply any association with the trademark holder of their product brand.
![Creative Commons Logo](https://i.creativecommons.org/l/by-nc/3.0/us/88x31.png)

This project is open source and released under the [Creative Commons Attribution NonCommercial 3.0 License](http://creativecommons.org/licenses/by-nc/3.0/us/)
