![alt text](https://github.com/BeeGrinder/FantasyGrounds-SW5e/blob/master/SW5EBW.png "SW5e")
# FantasyGrounds-SW5e
#### A FantasyGrounds module to implement SW5e game

SW5e is a user created (Home-brew) set of Races, Classes, NPCs, etc. that works within the 5e ruleset.

[SW5e Website](http://star-wars-5e.azurewebsites.net/)

[SW5e Subreddit](https://www.reddit.com/r/sw5e/)

[SW5e Fantasy Grounds Forum Thread](https://www.fantasygrounds.com/forums/showthread.php?47628-SW5e-a-star-wars-home-brew-on-the-5e-rule-set)

---
__Separating Modules__: For some time during development, the equiment/items and spells will be in separate modules.  This may be a slight inconvenience, but will ease ruleset development by allowing each section to be developed independently.  The base character creation and related subjects (Class, Race, Background, and Feats) will remain in the core player book module.  At some point, these will likely be joined back together into a single module.

 |Sub-Project | Status | Notes |
| --- | --- | -- |
|Player Book | Testing | Beta testing. Please, report any issues. |
|Spell Book | Testing | Beta testing. Please, report any issues. |
|Equipment Book | Testing | Working.  Releasing soon. |
|NPC Book | Released | Beta testing. Please, report any issues. |
|Rule-set Extension | Released | Beta testing. Please, report any issues. |

---

### Fantasy Grounds User Information

#### Installation
##### Be Warned - The current modules are still in development and have issues.  They are being addressed soon.

* To install the module(s) for use in Fantasy Grounds, download the file(s) in the module directory of this project into your Fantasy Grounds modules directory *(...\Fantasy Grounds\modules)*.  Then load sw5e modules using the Library->Modules selections.

   Download module files from [here](https://github.com/BeeGrinder/FantasyGrounds-SW5e/tree/master/modules)
 
* To install the extension, download *__sw5e.ext__* and place in your extensions directory *(...\Fantasy Grounds\extensions)*. When creating/loading your campaign, make sure to select extension *__sw5e__* from the list.

   Download the extension file from [here](https://github.com/BeeGrinder/FantasyGrounds-SW5e/tree/master/extensions)

* __*IMPORTANT:*__ Read the __Reference__ section of each module in Fantasy Grounds any notes or special instructions.

#### Creating your sw5e campaign

* When creating your new campaign in FG for SW5e, select the 5e rule-set (All the SW5e content is dependent on the base 5e rule-set).
* Once you select the 5e rule-set, the sw5e extension will appear in the extension window.  Select it.

  Note: It's best to only load SW5e modules and extensions. I cannot guarantee compatibility with other module or extensions.
* Once your campaign opens, go to *__Library__* then *__Modules__* and open the *__SW5e Player Book__*, *__SW5e Spell Book__*, *__SW5e Equipment__*, and *__SW5e NPC Manual__*.

### Developer Information

The *__par5e__* directory is for the text files that are parsed into the *__Player Book__* module and the "source" of the module content.</p>

The *__NPCEngineer__* directory is for the text files that are parsed into the *__NPC Book__* module and the "source" of the module content. [NPC Engineer website](http://www.masq.net/)

The *__spell-mod-src__* directory contains all Force and Tech Powers source.  It is maintained through editing the source XML.

The *__equipment__* directory contains all equiment shown in the Items selector button.  It is maintained through editing the source XML.

The *__ext-src__* dirctory is for the extension sources.

#### Release Goals
* Initial Release (V1.0)
   * Playable Races, Classes, Backgrounds, Feats, Equipment, Spells, NPCs from the sw5e PDF *__core__* documents.
   * If the data is readily available and easily parsed, some expanded content *__may__* be included.
   * Powers will still be called spells in the FG interface.
   * Enhanced Items will still be called Magic Items in the FG interface.
   * Most of the *__flavor__* of the SW5e handbook will not be added to the Fantasy Grounds modules.  This is to ease the conversion process.  The PDFs are free for anyone to get.  If you see something that would be beneficial to gameplay that should be in the module reference manual, please open an issue and let us know.
   
   
---
###### This project is not endorsed by, directly affiliated with, maintained, authorized, or sponsored by the SW5e project, Fantasy Grounds, Smiteworks, NPCEngineer, or Wizards of the Coast. All product and company names are the registered trademarks of their original owners. The use of any trade name or trademark is for identification and reference purposes only and does not imply any association with the trademark holder of their product brand.
