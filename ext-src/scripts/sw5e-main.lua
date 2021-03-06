
-- This project is not endorsed by, directly affiliated with, maintained, authorized,
-- or sponsored by the SW5e project, Fantasy Grounds, Smiteworks, NPCEngineer, 
-- or Wizards of the Coast. All product and company names are the registered trademarks of their original owners. 
-- The use of any trade name or trademark is for identification and reference purposes only and 
-- does not imply any association with the trademark holder of their product brand.

function onInit()
	--Debug.console("languages...");
	--Debug.console(GameSystem.languages);

	-- Damage Types
	dmgtypes = {
		Interface.getString("damage_value_kinetic"), -- SW5e Damage Types
		Interface.getString("damage_value_ion"),
		Interface.getString("damage_value_energy"),
		Interface.getString("damage_value_sonic"),
		"acid",		-- Classic TYPES
		"cold",
		"fire",
		"force",
		"lightning",
		"necrotic",
		"poison",
		"psychic",
		"radiant",
		"thunder",
		"adamantine", 	-- WEAPON PROPERTY DAMAGE TYPES
		"bludgeoning",
		"cold-forged iron",
		"magic",
		"piercing",
		"silver",
		"slashing",
		"critical", -- SPECIAL DAMAGE TYPES
	};
	
	-- Languages. 

	languages = {
		["Galactic Basic"] = "",
		["Aqualish"] = "Infernal",
		["Binary"] = "Binary",
		["Bith"] = "Primordial",
		["Bothese"] = "Elven",
		["Cerean"] = "Celestial",
		["Cheunh"] = "Draconic",
		["Durese"] = "Celestial",
		["Ewokese"] = "Elven",
		["Gamorrese"] = "Infernal",
		["Gand"] = "Draconic",
		["Geonosian"] = "Primordial",
		["Huttese"] = "Primordial",
		["Iktotchese"] = "Draconic",
		["Ithorese"] = "Dwarven",
		["Jawaese"] = "Elven",
		["Kaminoan"] = "Elven",
		["Kel Dor"] = "Elven",
		["Lasat"] = "Dwarven",
		["Mirialan"] = "Elven",
		["Mon Cal"] = "Draconic",
		["Nautila"] = "Primordial",
		["Rodese"] = "Dwarven",
		["Sith"] = "Aurebesh",
		["Togruti"] = "Primordial",
		["Dosh"] = "Elven",
		["Talzzi"] = "Primordial",
		["Twi'leki"] = "Draconic",
		["Shyriiwook"] = "Dwarven",
		["Sriluurian"] = "Dwarven",
		["Ugnaught"] = "Dwarven",
		["Zabraki"] = "Infernal",
	};
	languagefonts = {
		["Aurebesh"] = "Aurebesh",
		["Binary"] = "Binary",
		[Interface.getString("language_value_celestial")] = "Celestial",
		[Interface.getString("language_value_draconic")] = "Draconic",
		[Interface.getString("language_value_dwarvish")] = "Dwarven",
		[Interface.getString("language_value_elvish")] = "Elven",
		[Interface.getString("language_value_infernal")] = "Infernal",
		[Interface.getString("language_value_primordial")] = "Primordial",
	};
	-- Skills.  Added lore, piloting, technology
	skilldata = {
		[Interface.getString("skill_value_acrobatics")] = { lookup = "acrobatics", stat = 'dexterity' },
		[Interface.getString("skill_value_animalhandling")] = { lookup = "animalhandling", stat = 'wisdom' },
		[Interface.getString("skill_value_lore")] = { lookup = "lore", stat = 'intelligence' },
		[Interface.getString("skill_value_athletics")] = { lookup = "athletics", stat = 'strength' },
		[Interface.getString("skill_value_piloting")] = { lookup = "piloting", stat = 'intelligence' },
		[Interface.getString("skill_value_deception")] = { lookup = "deception", stat = 'charisma' },
		[Interface.getString("skill_value_technology")] = { lookup = "technology", stat = 'intelligence' },
		[Interface.getString("skill_value_insight")] = { lookup = "insight", stat = 'wisdom' },
		[Interface.getString("skill_value_intimidation")] = { lookup = "intimidation", stat = 'charisma' },
		[Interface.getString("skill_value_investigation")] = { lookup = "investigation", stat = 'intelligence' },
		[Interface.getString("skill_value_medicine")] = { lookup = "medicine", stat = 'wisdom' },
		[Interface.getString("skill_value_nature")] = { lookup = "nature", stat = 'intelligence' },
		[Interface.getString("skill_value_perception")] = { lookup = "perception", stat = 'wisdom' },
		[Interface.getString("skill_value_performance")] = { lookup = "performance", stat = 'charisma' },
		[Interface.getString("skill_value_persuasion")] = { lookup = "persuasion", stat = 'charisma' },
		[Interface.getString("skill_value_sleightofhand")] = { lookup = "sleightofhand", stat = 'dexterity' },
		[Interface.getString("skill_value_stealth")] = { lookup = "stealth", stat = 'dexterity', disarmorstealth = 1 },
		[Interface.getString("skill_value_survival")] = { lookup = "survival", stat = 'wisdom' },
	};

	-- Party sheet drop down skill list
	psskilldata = {
		Interface.getString("skill_value_acrobatics"),
		Interface.getString("skill_value_animalhandling"),
		Interface.getString("skill_value_lore"),
		Interface.getString("skill_value_athletics"),
		Interface.getString("skill_value_piloting"),
		Interface.getString("skill_value_deception"),
		Interface.getString("skill_value_technology"),
		Interface.getString("skill_value_insight"),
		Interface.getString("skill_value_intimidation"),
		Interface.getString("skill_value_investigation"),
		Interface.getString("skill_value_medicine"),
		Interface.getString("skill_value_nature"),
		Interface.getString("skill_value_perception"),
		Interface.getString("skill_value_performance"),
		Interface.getString("skill_value_persuasion"),
		Interface.getString("skill_value_sleightofhand"),
		Interface.getString("skill_value_stealth"),
		Interface.getString("skill_value_survival"),
	};

	classes = {
		Interface.getString("class_value_berserker"),
		Interface.getString("class_value_consular"),
		Interface.getString("class_value_engineer"),
		Interface.getString("class_value_fighter"),
		Interface.getString("class_value_guardian"),
		Interface.getString("class_value_monk"),
		Interface.getString("class_value_operative"),
		Interface.getString("class_value_scholar"),
		Interface.getString("class_value_scout"),
		Interface.getString("class_value_sentinel"),
};

	class_nametovalue = {
		[Interface.getString("class_value_berserker")] = "berserker",
		[Interface.getString("class_value_consular")] = "consular",
		[Interface.getString("class_value_engineer")] = "engineer",
		[Interface.getString("class_value_fighter")] = "fighter",
		[Interface.getString("class_value_guardian")] = "guardian",
		[Interface.getString("class_value_monk")] = "monk",
		[Interface.getString("class_value_operative")] = "operative",
		[Interface.getString("class_value_scholar")] = "scholar",
		[Interface.getString("class_value_scout")] = "scout",
		[Interface.getString("class_value_sentinel")] = "sentinel",
	};

	class_valuetoname = {
		["berserker"] = Interface.getString("class_value_berserker"),
		["consular"] = Interface.getString("class_value_consular"),
		["engineer"] = Interface.getString("class_value_engineer"),
		["fighter"] = Interface.getString("class_value_fighter"),
		["guardian"] = Interface.getString("class_value_guardian"),
		["monk"] = Interface.getString("class_value_monk"),
		["operative"] = Interface.getString("class_value_operative"),
		["scholar"] = Interface.getString("class_value_scholar"),
		["scout"] = Interface.getString("class_value_scout"),
		["sentinel"] = Interface.getString("class_value_sentinel"),
	};

	creaturetype = {
		Interface.getString("creature_value_droid"),
		Interface.getString("creature_value_forcewielder"),
		Interface.getString("creature_value_starship"),
		"aberration",
		"beast",
		"celestial",
		"construct",
		"dragon",
		"elemental",
		"fey",
		"fiend",
		"giant",
		"humanoid",
		"monstrosity",
		"ooze",
		"plant",
		"undead",
	};
	-- "Push" data changes in this file to the packages - overwriting the original base data.
	DataCommon.dmgtypes=dmgtypes;
	DataCommon.skilldata = skilldata;
	DataCommon.psskilldata = psskilldata;
	DataCommon.creaturetype = creaturetype;
	DataCommon.classes = classes;
	DataCommon.class_nametovalue = class_nametovalue;
	DataCommon.class_valuetoname = class_valuetoname;
	GameSystem.languages = languages;
	GameSystem.languagefonts = languagefonts;
	GameSystem.currencies = { Interface.getString("currency_value_cr") };
	GameSystem.currencyDefault = Interface.getString("currency_value_cr");
	LibraryData5E.aListViews.item.weapon.aGroupValueOrder = { "Simple Melee Vibroweapon", "Simple Ranged Blaster", "Simple Melee Lightweapon", "Martial Melee Vibroweapon", "Martial Ranged Blaster", "Martial Melee Lightweapon"};
	LibraryData5E.aListViews.item.armor.aGroupValueOrder = { "Light", "Medium", "Heavy", "Shield"};
	-- background choices
	OptionsManager.addOptionValue("DDCL", "option_val_sw5e_custom1", "desktopdecal_sw5e1", true);
	OptionsManager.addOptionValue("DDCL", "option_val_sw5e_custom2", "desktopdecal_sw5e2", true);
	OptionsManager.addOptionValue("DDCL", "option_val_sw5e_custom3", "desktopdecal_sw5e3", true);
	OptionsManager.addOptionValue("DDCL", "option_val_sw5e_custom4", "desktopdecal_sw5e4", true);
	OptionsManager.addOptionValue("DDCL", "option_val_sw5e_custom5", "desktopdecal_sw5e5", true);
	OptionsManager.addOptionValue("DDCL", "option_val_sw5e_custom6", "desktopdecal_sw5e6", true);
end
