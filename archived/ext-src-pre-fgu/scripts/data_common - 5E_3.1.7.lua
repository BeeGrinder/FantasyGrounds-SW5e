--
-- This file included for reference purposes only
-- 
-- This project is not endorsed by, directly affiliated with, maintained, authorized,
-- or sponsored by the SW5e project, Fantasy Grounds, Smiteworks, NPCEngineer, 
-- or Wizards of the Coast. All product and company names are the registered trademarks of their original owners. 
-- The use of any trade name or trademark is for identification and reference purposes only and 
-- does not imply any association with the trademark holder of their product brand.
--

-- Abilities (database names)
abilities = {
	"strength",
	"dexterity",
	"constitution",
	"intelligence",
	"wisdom",
	"charisma"
};

ability_ltos = {
	["strength"] = "STR",
	["dexterity"] = "DEX",
	["constitution"] = "CON",
	["intelligence"] = "INT",
	["wisdom"] = "WIS",
	["charisma"] = "CHA"
};

ability_stol = {
	["STR"] = "strength",
	["DEX"] = "dexterity",
	["CON"] = "constitution",
	["INT"] = "intelligence",
	["WIS"] = "wisdom",
	["CHA"] = "charisma"
};

-- Basic class values (not display values)
classes = {
	"barbarian",
	"bard",
	"cleric",
	"druid",
	"fighter",
	"monk",
	"paladin",
	"ranger",
	"rogue",
	"sorcerer",
	"warlock",
	"wizard",
};

-- Values for wound comparison
healthstatushalf = "bloodied";
healthstatuswounded = "wounded";

-- Values for alignment comparison
alignment_lawchaos = {
	["lawful"] = 1,
	["chaotic"] = 3,
	["lg"] = 1,
	["ln"] = 1,
	["le"] = 1,
	["cg"] = 3,
	["cn"] = 3,
	["ce"] = 3,
};
alignment_goodevil = {
	["good"] = 1,
	["evil"] = 3,
	["lg"] = 1,
	["le"] = 3,
	["ng"] = 1,
	["ne"] = 3,
	["cg"] = 1,
	["ce"] = 3,
};

-- Values for size comparison
creaturesize = {
	["tiny"] = 1,
	["small"] = 2,
	["medium"] = 3,
	["large"] = 4,
	["huge"] = 5,
	["gargantuan"] = 6,
	["T"] = 1,
	["S"] = 2,
	["M"] = 3,
	["L"] = 4,
	["H"] = 5,
	["G"] = 6,
};

-- Values for creature type comparison
creaturedefaulttype = "humanoid";
creaturehalftype = "half-";
creaturehalftypesubrace = "human";
creaturetype = {
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
creaturesubtype = {
	"aarakocra",
	"bullywug",
	"demon",
	"devil",
	"dragonborn",
	"dwarf",
	"elf", 
	"gith",
	"gnoll",
	"gnome", 
	"goblinoid",
	"grimlock",
	"halfling",
	"human",
	"kenku",
	"kuo-toa",
	"kobold",
	"lizardfolk",
	"living construct",
	"merfolk",
	"orc",
	"quaggoth",
	"sahuagin",
	"shapechanger",
	"thri-kreen",
	"titan",
	"troglodyte",
	"yuan-ti",
	"yugoloth",
};

-- Values supported in effect conditionals
conditionaltags = {
};

-- Conditions supported in effect conditionals and for token widgets
conditions = {
	"blinded", 
	"charmed",
	"cursed",
	"deafened",
	"encumbered",
	"frightened", 
	"grappled", 
	"incapacitated",
	"incorporeal",
	"intoxicated",
	"invisible", 
	"paralyzed",
	"petrified",
	"poisoned",
	"prone", 
	"restrained",
	"stable", 
	"stunned",
	"turned",
	"unconscious"
};

-- Bonus/penalty effect types for token widgets
bonuscomps = {
	"INIT",
	"CHECK",
	"AC",
	"ATK",
	"DMG",
	"HEAL",
	"SAVE",
	"STR",
	"CON",
	"DEX",
	"INT",
	"WIS",
	"CHA",
};

-- Condition effect types for token widgets
condcomps = {
	["blinded"] = "cond_blinded",
	["charmed"] = "cond_charmed",
	["deafened"] = "cond_deafened",
	["encumbered"] = "cond_encumbered",
	["frightened"] = "cond_frightened",
	["grappled"] = "cond_grappled",
	["incapacitated"] = "cond_paralyzed",
	["incorporeal"] = "cond_incorporeal",
	["invisible"] = "cond_invisible",
	["paralyzed"] = "cond_paralyzed",
	["petrified"] = "cond_paralyzed",
	["prone"] = "cond_prone",
	["restrained"] = "cond_restrained",
	["stunned"] = "cond_stunned",
	["unconscious"] = "cond_unconscious"
};

-- Other visible effect types for token widgets
othercomps = {
	["COVER"] = "cond_cover",
	["SCOVER"] = "cond_cover",
	["IMMUNE"] = "cond_immune",
	["RESIST"] = "cond_resist",
	["VULN"] = "cond_vuln",
	["REGEN"] = "cond_regen",
	["DMGO"] = "cond_ongoing"
};

-- Effect components which can be targeted
targetableeffectcomps = {
	"HIDDEN",
	"COVER",
	"SCOVER",
	"AC",
	"SAVE",
	"ATK",
	"DMG",
	"IMMUNE",
	"VULN",
	"RESIST"
};

connectors = {
	"and",
	"or"
};

-- Range types supported
rangetypes = {
	"melee",
	"ranged"
};

-- Damage types supported
dmgtypes = {
	"acid",		-- ENERGY TYPES
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

specialdmgtypes = {
	"critical",
};

-- Bonus types supported in power descriptions
bonustypes = {
};
stackablebonustypes = {
};

function onInit()
	-- Classes
	class_nametovalue = {
		[Interface.getString("class_value_barbarian")] = "barbarian",
		[Interface.getString("class_value_bard")] = "bard",
		[Interface.getString("class_value_cleric")] = "cleric",
		[Interface.getString("class_value_druid")] = "druid",
		[Interface.getString("class_value_fighter")] = "fighter",
		[Interface.getString("class_value_monk")] = "monk",
		[Interface.getString("class_value_paladin")] = "paladin",
		[Interface.getString("class_value_ranger")] = "ranger",
		[Interface.getString("class_value_rogue")] = "rogue",
		[Interface.getString("class_value_sorcerer")] = "sorcerer",
		[Interface.getString("class_value_warlock")] = "warlock",
		[Interface.getString("class_value_wizard")] = "wizard",
	};

	class_valuetoname = {
		["barbarian"] = Interface.getString("class_value_barbarian"),
		["bard"] = Interface.getString("class_value_bard"),
		["cleric"] = Interface.getString("class_value_cleric"),
		["druid"] = Interface.getString("class_value_druid"),
		["fighter"] = Interface.getString("class_value_fighter"),
		["monk"] = Interface.getString("class_value_monk"),
		["paladin"] = Interface.getString("class_value_paladin"),
		["ranger"] = Interface.getString("class_value_ranger"),
		["rogue"] = Interface.getString("class_value_rogue"),
		["sorcerer"] = Interface.getString("class_value_sorcerer"),
		["warlock"] = Interface.getString("class_value_warlock"),
		["wizard"] = Interface.getString("class_value_wizard"),
	};

	-- Skills
	skilldata = {
		[Interface.getString("skill_value_acrobatics")] = { lookup = "acrobatics", stat = 'dexterity' },
		[Interface.getString("skill_value_animalhandling")] = { lookup = "animalhandling", stat = 'wisdom' },
		[Interface.getString("skill_value_arcana")] = { lookup = "arcana", stat = 'intelligence' },
		[Interface.getString("skill_value_athletics")] = { lookup = "athletics", stat = 'strength' },
		[Interface.getString("skill_value_deception")] = { lookup = "deception", stat = 'charisma' },
		[Interface.getString("skill_value_history")] = { lookup = "history", stat = 'intelligence' },
		[Interface.getString("skill_value_insight")] = { lookup = "insight", stat = 'wisdom' },
		[Interface.getString("skill_value_intimidation")] = { lookup = "intimidation", stat = 'charisma' },
		[Interface.getString("skill_value_investigation")] = { lookup = "investigation", stat = 'intelligence' },
		[Interface.getString("skill_value_medicine")] = { lookup = "medicine", stat = 'wisdom' },
		[Interface.getString("skill_value_nature")] = { lookup = "nature", stat = 'intelligence' },
		[Interface.getString("skill_value_perception")] = { lookup = "perception", stat = 'wisdom' },
		[Interface.getString("skill_value_performance")] = { lookup = "performance", stat = 'charisma' },
		[Interface.getString("skill_value_persuasion")] = { lookup = "persuasion", stat = 'charisma' },
		[Interface.getString("skill_value_religion")] = { lookup = "religion", stat = 'intelligence' },
		[Interface.getString("skill_value_sleightofhand")] = { lookup = "sleightofhand", stat = 'dexterity' },
		[Interface.getString("skill_value_stealth")] = { lookup = "stealth", stat = 'dexterity', disarmorstealth = 1 },
		[Interface.getString("skill_value_survival")] = { lookup = "survival", stat = 'wisdom' },
	};

	-- Party sheet drop down list data
	psabilitydata = {
		Interface.getString("strength"),
		Interface.getString("dexterity"),
		Interface.getString("constitution"),
		Interface.getString("intelligence"),
		Interface.getString("wisdom"),
		Interface.getString("charisma"),
	};

	-- Party sheet drop down list data
	psskilldata = {
		Interface.getString("skill_value_acrobatics"),
		Interface.getString("skill_value_animalhandling"),
		Interface.getString("skill_value_arcana"),
		Interface.getString("skill_value_athletics"),
		Interface.getString("skill_value_deception"),
		Interface.getString("skill_value_history"),
		Interface.getString("skill_value_insight"),
		Interface.getString("skill_value_intimidation"),
		Interface.getString("skill_value_investigation"),
		Interface.getString("skill_value_medicine"),
		Interface.getString("skill_value_nature"),
		Interface.getString("skill_value_perception"),
		Interface.getString("skill_value_performance"),
		Interface.getString("skill_value_persuasion"),
		Interface.getString("skill_value_religion"),
		Interface.getString("skill_value_sleightofhand"),
		Interface.getString("skill_value_stealth"),
		Interface.getString("skill_value_survival"),
	};
end
