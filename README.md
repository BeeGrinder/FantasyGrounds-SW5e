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
|SW5e Player Book.mod | Released. | Classes, Races, Backgrounds, Feats, Skills, etc. Requires Suplement module to be loaded also.|
|SW5e Supplement.mod | Released. | Powers (Spells) and Items/Equipement. Must be loaded with PHB module. |
|Ruleset Extension | Released. | Fantasy Grounds Classic ruleset modifications extension |

See the FG Forum post for news about current projects and module changes underway.

---

__Fantasy Grounds Unity(FGU)__ : Please note this is not tested in FGU.  Use at your own risk.  Some recent updates should help with compatibility issues.

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

#### Goals for next release
* Next Release (V1.1 mid-2020?)
   * Updates to "final" core manual changes (as of Jan. 2020).
   * Marking additional races already done as "Expanded Content".  No other expanded content will be included.
   * Remake NPC list from the Scum and Villainy book.  Attempt to integrate with main PHB module.
   * Powers will still be called spells in the FG interface.  This may be permanent as long as it is based on the core 5e ruleset.

---

__Project News__

May 8, 2020

The old NPC module is no longer required.  All the old NPCs, plus some new ones, are in the PHB module.

Apr. 15, 2020 Update

Several updates were done to the Player Book module and the SW5e extension available here.  Module now has NPCs from the Scum and Villiany book.  The extension has had some FGU compatibility issues fixed, but it is still not fully tested in FGU.

Apr. 6, 2020 Update

Progress is slow on the NPC update.  Over 200 NPCs require coding into the PAR5e utilities special format.  And, the PAR5e utility is about as finicky as it gets.  Some of the more complex NPCs can take hours to work correctly and not destroy the other NPC's output into the module.  I may do a partial release with non-force users.

The current world health crisis and lock-down has actually given me less time for this project.  My real-world programming job has gotten more demanding as the situation continues.  So, progress is not as fast as I would like.

---
###### This project is not endorsed by, directly affiliated with, maintained, authorized, or sponsored by the SW5e project, Fantasy Grounds, Smiteworks, NPCEngineer, rob2e, or Wizards of the Coast. All product and company names are the registered trademarks of their original owners. The use of any trade name or trademark is for identification and reference purposes only and does not imply any association with the trademark holder of their product brand.
![Creative Commons Logo](https://i.creativecommons.org/l/by-nc/3.0/us/88x31.png)

This project is open source and released under the [Creative Commons Attribution NonCommercial 3.0 License](http://creativecommons.org/licenses/by-nc/3.0/us/)
