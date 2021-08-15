![alt text](https://github.com/BeeGrinder/FantasyGrounds-SW5e/blob/master/SW5EBW.png "SW5e")
# FantasyGrounds-SW5e
#### A Fantasy Grounds&reg; module to implement SW5e game

SW5e is a user created (Home-brew) set of new Races, Classes, NPCs, etc. that works within the 5e ruleset but "flavored" for the Star Wars&reg; universe.

[Fantasy Grounds Forum Thread about the SW5e module](https://www.fantasygrounds.com/forums/showthread.php?47628-SW5e-a-star-wars-home-brew-on-the-5e-rule-set)

[SW5e Website](https://sw5e.com/)

[SW5e Subreddit](https://www.reddit.com/r/sw5e/)

---

|Sub-Project | Status | Notes |
| --- | --- | -- |
|SW5e Player Book.mod | Released. | Classes, Races, Backgrounds, Feats, Skills, Spells, NPCs, etc.|
|Ruleset Extension | Released. | Fantasy Grounds&reg; 5e ruleset modification extension |

See the FG Forum post for news about current projects and module changes underway.

---

__Fantasy Grounds Unity&reg; (FGU)__ : I am now primarily testing this rule set in FGU.  When reporting a problem, be sure to specify if you are using FGU or Classic.

---

### Fantasy Grounds&reg; User Information

This extension and module primarily cover the PHB and Scum and Villainy PDFs from the SW5e project.  This should be a good base from which others can add their own content and/or publish modules for the expanded content.

#### Installation

* The *__extension is required__* for the module to function.  

* Get the __extension__ from the Forge [here](https://forge.fantasygrounds.com/shop/items/53/view)

* The __module__ is available from the Forge [here](https://forge.fantasygrounds.com/shop/items/44/view)
 

* __*IMPORTANT:*__ Read the __Reference__ section of each module in Fantasy Grounds for any notes or special instructions.

#### Creating your sw5e campaign

* When creating your new campaign in FG for SW5e, select the *__5e__* rule-set (All the SW5e content is dependent on the base 5e rule-set).
* Once you select the 5e rule-set, the sw5e extension will appear in the extension window.  Select the SW5e extension.

  Note: It's best to only load SW5e module and extensions. I cannot guarantee compatibility with other module or extensions.
* Once your campaign opens, go to *__Library__* then *__Modules__* and open the *__SW5e Player Book__*.

#### PDFs

Because the SW5e project is constantly adding/removing/changing the contents of their Player Hand Book PDFs, 
I will be providing links to the version of the PDFs that match this FG ruleset.

[SW5e PHB PDF for Fantasy Grounds Module](https://mega.nz/file/2IEH1awA#NvlThnx4ZwxsvWNkpcIxXLDn5WfCRVV3hPKKeSsbXaE)

[SW5e Scum & Villainy PDF for Fantasy Grounds Module](https://mega.nz/file/TM8kVYaa#YcHsUUW5fi0CitCX_hQ1cXMLhZpqdKubP_PwCWzLvk4)

__A note on spells__ (powers)

Perhaps the most useful and powerful feature of FG is automation.  A player can target a group of many NPCs in combat, roll attack and damage and all saving throws and damage calculations are done automatically.  Any GM who has delt with large numbers in combat tracking knows this is a __HUGE__ time saver and makes combat move exponentially faster.  Which helps keep players "in the game" instead of "checking out" while the GM does all these rolls and calculations individually.

All spells (powers) with FG coding have the note "(* FG Coding)" at the end if their descriptions.  Not all the newer additions to the spell lists have been updated with coding yet.  As GM you can add coding yourself, or let the players do it manually until the module is updated. 

[Here is an excellent tutorial on spell effects coding](https://fantasygroundsunity.atlassian.net/wiki/spaces/FGCP/pages/996642031/5E+Effects+for+Advanced+Automation)

__New Starship Rules__

At this time none of the Starship combat rules will be added to my modules.  It is not compatible with the 5e ruleset and will require extensive extension development.  You can still used FG for the maps, tokens and dice rolls.  See the above link to the thread on the Fantasy Grounds forums to see 3rd party content for this module and user implemented space combat rules.

### Developer Information

The *__par5e__* directory is for the text files that are parsed into the *__Player Book__* module and the "source" of the module content. The current player book module is 80% compiled using PAR5e v0.0.9-b62.  I've created a crude java app called ModuleGenerator that takes the output from Par5e, massages and adds data to create a complete module.  If I continue down this path, eventually I will stop using Par5e.

PAR5e note: Do not use: equipment.txt, spells.txt, or parcels.txt.  Compatibility issues with modern Fantasy Grounds.

The *__ext-src__* dirctory is for the extension sources.

---

__Project News__

Aug 15, 2021

Fixes for caster attach rolls in combat tracker, concentration checks in combat tracker, new effects for items, class/race features, etc.  New release is v20210815.1 and will be available via the Forge "Test" build channel.

Feb 20, 2021

v3 released.  Fixed weapon category issues, NPC size issues, NPC token issues, Class ability score improvement, and background skill choices.

Feb 13, 2021

I have made release 3.0.1 as a pre-release and you can download the module and extension [from here](https://github.com/BeeGrinder/FantasyGrounds-SW5e/releases/tag/v3.0.1).  Please, notice it is now a single module.  You *__MUST__* unload all old modules when testing 3.0.1!

Jan 23, 2021

Updates are slow, but I am working on a way to update spells(powers) from the sw5e web site instead of hand copying/coding them when they do their frequent changes.  Without a way to automate these changes, keeping a module updated is extremely difficult especially because they do not follow the WoTC document and phrasing standards which most 3rd party electronic systems depend upon.

Dec 12, 2020

All current equipment added.  Only unfinished category for version 3.0 is Tech and Force "Spells".

Dec 5, 2020

Update to PHB module and extension. Fixed extension project web link and renamed directory. Update berserker instincts, operative exploits and monastic vows to be more readable.  Made scholar/doctor/panacea side-effects into link to rollable table.

Dec 3, 2020

All class definitions updated thanks to the assistance of lordcygnus! Also fixed links to the SW5e web site and a few NPC issues.  Both modules and the extension should be downloaded.

Nov 30, 2020

Updated Berserker class to current.

---
If you like my work, you can [<img src="https://cdn.buymeacoffee.com/buttons/v2/default-yellow.png">](https://www.buymeacoffee.com/BeeGrinder)

---
###### This project is not endorsed by, directly affiliated with, maintained, authorized, or sponsored by the SW5e project, Fantasy Grounds, Smiteworks, NPCEngineer, rob2e, or Wizards of the Coast. All product and company names are the registered trademarks of their original owners. The use of any trade name or trademark is for identification and reference purposes only and does not imply any association with the trademark holder of their product brand.
![Creative Commons Logo](https://i.creativecommons.org/l/by-nc/3.0/us/88x31.png)

This project is open source and released under the [Creative Commons Attribution NonCommercial 3.0 License](http://creativecommons.org/licenses/by-nc/3.0/us/)
