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
|SW5e Player Book.mod | Released. | Classes, Races, Backgrounds, Feats, Skills, NPCs, etc. Requires Suplement module to also be loaded.|
|SW5e Supplement.mod | Released. | Powers (Spells) and Items/Equipement. Must be loaded with PHB module. |
|Ruleset Extension | Released. | Fantasy Grounds Classic ruleset modifications extension |

See the FG Forum post for news about current projects and module changes underway.

---

__Fantasy Grounds Unity(FGU)__ : I am now primarily testing this rule set in FGU.  When reporting a problem, be sure to specify if you are using FGU or Classic.

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
* Once you select the 5e rule-set, the sw5e extension will appear in the extension window.  Select the SW5e extension.

  Note: It's best to only load SW5e modules and extensions. I cannot guarantee compatibility with other module or extensions.
* Once your campaign opens, go to *__Library__* then *__Modules__* and open the *__SW5e Supplement__* and the *__SW5e Player Book__*.  It is *__VERY IMPORTANT TO OPEN BOTH__*!

__New Starship Rules__

At this time none of the Starship combat rules will be added to my modules.  It is not compatible with the 5e ruleset and will require extensive extension development.

### Developer Information

The *__par5e__* directory is for the text files that are parsed into the *__Player Book__* module and the "source" of the module content. The current player book module is 99% compiled using PAR5e v0.0.9-b62.  I've added a sed script to add the level 3 sub-class choices to the output XML.

The *__supplement-mod__* directory contains all Force and Tech Powers (spells) and Items/Equipment source.  It is maintained through editing the source XML.

The *__ext-src__* dirctory is for the extension sources.

---

__Project News__

Dec 3, 2020

All class definitions updated thanks to the assistance of lordcygnus! Also fixed links to the SW5e web site and a few NPC issues.  Both modules and the extension should be downloaded.

Nov 30, 2020

Updated Berserker class to current.

Nov 28, 2020

Fixes for NPC spell actions and Operative Practice choice at level 3 have been posted as module updates.

May 23, 2020

All NPCs from the Scum and Villainy PDF have been added to the PHB module.

---
If you like my work, you can [<img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png">](https://www.buymeacoffee.com/BeeGrinder)

---
###### This project is not endorsed by, directly affiliated with, maintained, authorized, or sponsored by the SW5e project, Fantasy Grounds, Smiteworks, NPCEngineer, rob2e, or Wizards of the Coast. All product and company names are the registered trademarks of their original owners. The use of any trade name or trademark is for identification and reference purposes only and does not imply any association with the trademark holder of their product brand.
![Creative Commons Logo](https://i.creativecommons.org/l/by-nc/3.0/us/88x31.png)

This project is open source and released under the [Creative Commons Attribution NonCommercial 3.0 License](http://creativecommons.org/licenses/by-nc/3.0/us/)
