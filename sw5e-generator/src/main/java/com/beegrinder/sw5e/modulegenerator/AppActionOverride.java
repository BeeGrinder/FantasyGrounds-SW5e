package com.beegrinder.sw5e.modulegenerator;

import java.util.HashMap;
import java.util.Map;

public class AppActionOverride {

	
	/*
	 * This is basically a spell action coding lookup database by spell name.
	 * 
	 * The actions section of the spell will be inserted into the module xml.
	 */
	private static final Map<String, String> actionOverrideMap = new HashMap<>() {
		{
			put("Acid Wind","<actions/>");
			put("Acidic Strike","<actions/>");
			put("Armor of Abeloth","<actions/>");
			put("Autonomous Servant","<actions/>");
			put("Bacta Pack","<actions/>");
			put("Battle Insight","<actions><id-00001><apply type=\"string\">roll</apply><durmod type=\"number\">1</durmod><effect_target type=\"string\">self</effect_target><label type=\"string\">Battle Insight; GRANTADVATK</label><order type=\"number\">1</order><type type=\"string\">effect</type></id-00001><id-00002><durmod type=\"number\">1</durmod><label type=\"string\">Battle Insight (C)</label><order type=\"number\">2</order><targeting type=\"string\">self</targeting><type type=\"string\">effect</type></id-00002></actions>");
			put("Beacon of Hope","<actions/>");
			put("Bestow Curse","<actions/>");
			put("Bestow Virus","<actions/>");
			put("Buffer","<actions/>");
			put("Call Lightning","<actions/>");
			put("Capacity Boost","<actions/>");
			put("Carbon Fog","<actions/>");
			put("Carbonite Explosion","<actions/>");
			put("Combustive Shot","<actions/>");
			put("Comprehend Speech","<actions/>");
			put("Concealed Caltrops","<actions/>");
			put("Condense/Vaporize","<actions/>");
			put("Control Pain","<actions/>");
			put("Copy","<actions/>");
			put("Countermeasures","<actions/>");
			put("Cryogenic Wave","<actions/>");
			put("Dark Aura","<actions/>");
			put("Decryption Program","<actions/>");
			put("Defibrillate","<actions/>");
			put("Destroy Tech","<actions/>");
			put("Dun Moch","<actions/>");
			put("Echo Blast","<actions/>");
			put("Elemental Accelerant","<actions/>");
			put("Energetic Burst","<actions/>");
			put("Enhance Droid","<actions/>");
			put("Execute Command","<actions/>");
			put("Extinguish","<actions/>");
			put("Fabricate Trap","<actions/>");
			put("Flash","<actions/>");
			put("Force Blinding","<actions><id-00001><durmod type=\"number\">1</durmod><label type=\"string\">Force Blinding; Blinded</label><order type=\"number\">1</order><type type=\"string\">effect</type></id-00001></actions>");
			put("Force Blur","<actions/>");
			put("Force Concealment","<actions/>");
			put("Force Focus","<actions><id-00001><apply type=\"string\">roll</apply><durmod type=\"number\">0</durmod><label type=\"string\">Force Focus; DMG: 1d4 force</label><order type=\"number\">1</order><targeting type=\"string\">self</targeting><type type=\"string\">effect</type></id-00001><id-00002><durmod type=\"number\">1</durmod><durunit type=\"string\">minute</durunit><label type=\"string\">Force Focus (C)</label><order type=\"number\">2</order><targeting type=\"string\">self</targeting><type type=\"string\">effect</type></id-00002></actions>");
			put("Force Imbuement","<actions><id-00001><atkbase type=\"string\">ability</atkbase><atkmod type=\"number\">0</atkmod><atkprof type=\"number\">1</atkprof><atkstat type=\"string\">base</atkstat><atktype type=\"string\">melee</atktype><order type=\"number\">1</order><savedcmod type=\"number\">0</savedcmod><savedcprof type=\"number\">1</savedcprof><type type=\"string\">cast</type></id-00001><id-00002><damagelist><id-00001><bonus type=\"number\">0</bonus><dice type=\"dice\">d8</dice><stat type=\"string\">wisdom</stat><type type=\"string\">kinetic, magic</type></id-00001></damagelist><order type=\"number\">2</order><type type=\"string\">damage</type></id-00002><id-00003><durmod type=\"number\">1</durmod><durunit type=\"string\">minute</durunit><label type=\"string\">Force Imbuement</label><order type=\"number\">3</order><targeting type=\"string\">self</targeting><type type=\"string\">effect</type></id-00003></actions>");
			put("Force Leap","<actions><id-00001><durmod type=\"number\">1</durmod><label type=\"string\">Force Leap</label><order type=\"number\">1</order><targeting type=\"string\">self</targeting><type type=\"string\">effect</type></id-00001></actions>");
			put("Force Mask","<actions><id-00001><durmod type=\"number\">1</durmod><durunit type=\"string\">hour</durunit><label type=\"string\">Force Mask</label><order type=\"number\">1</order><targeting type=\"string\">self</targeting><type type=\"string\">effect</type></id-00001></actions>");
			put("Force Meld","<actions/>");
			put("Force Propel","<actions><id-00001><onmissdamage type=\"string\">half</onmissdamage><order type=\"number\">1</order><savetype type=\"string\">dexterity</savetype><type type=\"string\">cast</type></id-00001><id-00002><damagelist><id-00001><bonus type=\"number\">0</bonus><dice type=\"dice\">d8,d8,d8</dice><type type=\"string\">kinetic</type></id-00001></damagelist><order type=\"number\">2</order><type type=\"string\">damage</type></id-00002></actions>");
			put("Force Reflect","<actions><id-00001><atkmod type=\"number\">0</atkmod><atkprof type=\"number\">1</atkprof><atktype type=\"string\">ranged</atktype><order type=\"number\">1</order><savedcmod type=\"number\">0</savedcmod><savedcprof type=\"number\">1</savedcprof><savemagic type=\"number\">0</savemagic><type type=\"string\">cast</type></id-00001><id-00002><heallist><id-00001><bonus type=\"number\">0</bonus><dice type=\"dice\">d10</dice><statmult type=\"number\">1</statmult></id-00001></heallist><healtargeting type=\"string\">self</healtargeting><order type=\"number\">2</order><type type=\"string\">heal</type></id-00002></actions>");
			put("Force Repulse","<actions/>");
			put("Force Shunt","<actions><id-00001><order type=\"number\">1</order><savetype type=\"string\">strength</savetype><type type=\"string\">cast</type></id-00001><id-00002><damagelist><id-00001><bonus type=\"number\">0</bonus><dice type=\"dice\">d4</dice><type type=\"string\">kinetic</type></id-00001></damagelist><order type=\"number\">2</order><type type=\"string\">damage</type></id-00002><id-00003><durmod type=\"number\">0</durmod><label type=\"string\">Force Shunt; Prone</label><order type=\"number\">3</order><type type=\"string\">effect</type></id-00003></actions>");
			put("Force Throw","<actions/>");
			put("Force Vision","<actions/>");
			put("Force Weapon","<actions/>");
			put("Force Whisper","<actions/>");
			put("Frequency Scan","<actions/>");
			put("Friendly Fire","<actions/>");
			put("Glide","<actions/>");
			put("Greater Analyze","<actions/>");
			put("Greater Heal","<actions/>");
			put("Greater Hologram","<actions/>");
			put("Greater Saber Throw","<actions/>");
			put("Greater Translation Program","<actions/>");
			put("Group Hologram","<actions/>");
			put("Hallucination","<actions/>");
			put("Haywire","<actions/>");
			put("Heroism","<actions/>");
			put("Holding Cell","<actions/>");
			put("Hologram","<actions/>");
			put("Holographic Disguise","<actions/>");
			put("Homing Rockets","<actions/>");
			put("Hysteria","<actions/>");
			put("Illusory Strike","<actions/>");
			put("Illusory Terrain","<actions/>");
			put("Improved Force Barrier","<actions/>");
			put("Improved Phasewalk","<actions/>");
			put("Improved Restoration","<actions/>");
			put("Improved Saber Throw","<actions/>");
			put("Ionic Strike","<actions/>");
			put("Kolto Dispenser","<actions/>");
			put("Magnetic Field","<actions/>");
			put("Magnetic Hold","<actions/>");
			put("Malacia","<actions/>");
			put("Mass Animation","<actions/>");
			put("Mass Hysteria","<actions/>");
			put("Mass Malacia","<actions/>");
			put("Master Force Barrier","<actions/>");
			put("Master Malacia","<actions/>");
			put("Master Saber Throw","<actions/>");
			put("Mind Prison","<actions/>");
			put("Mind Trap","<actions/>");
			put("Minor Defibrillation","<actions/>");
			put("Minor Hologram","<actions/>");
			put("Morichro","<actions/>");
			put("Motivator Boost","<actions/>");
			put("Necrotic Charge","<actions><id-00001><damagelist><id-00001><bonus type=\"number\">0</bonus><dice type=\"dice\">d8</dice><type type=\"string\">necrotic</type></id-00001></damagelist><order type=\"number\">1</order><type type=\"string\">damage</type></id-00001></actions>");
			put("Necrotic Touch","<actions><id-00001><atktype type=\"string\">melee</atktype><order type=\"number\">1</order><type type=\"string\">cast</type></id-00001><id-00002><damagelist><id-00001><bonus type=\"number\">0</bonus><dice type=\"dice\">d6</dice><type type=\"string\">necrotic</type></id-00001></damagelist><order type=\"number\">2</order><type type=\"string\">damage</type></id-00002></actions>");
			put("Neurotoxin","<actions/>");
			put("Override Interface","<actions/>");
			put("Phasewalk","<actions/>");
			put("Pheromone Burst","<actions/>");
			put("Poison Dart","<actions/>");
			put("Predictive AI","<actions/>");
			put("Pressure Crush","<actions/>");
			put("Project Hologram","<actions/>");
			put("Psychic Charge","<actions><id-00001><damagelist><id-00001><bonus type=\"number\">0</bonus><dice type=\"dice\">1d8</dice><type type=\"string\">psychic</type></id-00001></damagelist><order type=\"number\">1</order><type type=\"string\">damage</type></id-00001><id-00002><durmod type=\"number\">1</durmod><label type=\"string\">Psychic Charge - Silenced; </label><order type=\"number\">2</order><type type=\"string\">effect</type></id-00002></actions>");
			put("Psychometry","<actions/>");
			put("Radiation","<actions/>");
			put("Read Memory","<actions/>");
			put("Reboot","<actions/>");
			put("Rebuke","<actions><id-00001><atkbase type=\"string\">ability</atkbase><atkmod type=\"number\">0</atkmod><atkprof type=\"number\">1</atkprof><atkstat type=\"string\">base</atkstat><atktype type=\"string\">melee</atktype><order type=\"number\">1</order><savedcmod type=\"number\">0</savedcmod><savedcprof type=\"number\">1</savedcprof><type type=\"string\">cast</type></id-00001><id-00002><damagelist><id-00001><bonus type=\"number\">0</bonus><dice type=\"dice\">d12</dice><type type=\"string\">force</type></id-00001></damagelist><order type=\"number\">2</order><type type=\"string\">damage</type></id-00002><id-00003><damagelist><id-00001><bonus type=\"number\">0</bonus><dice type=\"dice\">d10</dice><type type=\"string\">force</type></id-00001></damagelist><order type=\"number\">3</order><type type=\"string\">damage</type></id-00003><id-00004><damagelist><id-00001><bonus type=\"number\">0</bonus><dice type=\"dice\">d8</dice><type type=\"string\">force</type></id-00001></damagelist><order type=\"number\">4</order><type type=\"string\">damage</type></id-00004></actions>");
			put("Remove Curse","<actions/>");
			put("Remove Virus","<actions/>");
			put("Reprogram Droid","<actions/>");
			put("Restoration","<actions/>");
			put("Rewrite Memory","<actions/>");
			put("Rime Shot","<actions/>");
			put("Scan Area","<actions/>");
			put("Scramble Interface","<actions/>");
			put("Scrambling Barrier","<actions/>");
			put("Security Protocols","<actions/>");
			put("Seethe","<actions/>");
			put("Shadow Sight","<actions/>");
			put("Shocking Ray","<actions/>");
			put("Short Circuit","<actions/>");
			put("Skill Protocol","<actions/>");
			put("Smoke Cloud","<actions/>");
			put("Sonic Charge","<actions/>");
			put("Sonic Fists","<actions/>");
			put("Sonic Shot","<actions/>");
			put("Sonic Strike","<actions/>");
			put("Sound Trick","<actions/>");
			put("Spectrum Bolt","<actions/>");
			put("Spectrum Ray","<actions/>");
			put("Spirit Blade","<actions/>");
			put("Stun Dart","<actions/>");
			put("Superior Translation Program","<actions/>");
			put("Sustained Lightning","<actions/>");
			put("Targeting Shot","<actions/>");
			put("Telekinetic Shield","<actions/>");
			put("Telekinetic Storm","<actions/>");
			put("Telemetry","<actions/>");
			put("Tonal Translocate","<actions/>");
			put("Translation Program","<actions/>");
			put("True Sight","<actions/>");
			put("Truth Serum","<actions/>");
			put("Venomous Strike","<actions/>");
			put("Vertical Maneuvering","<actions/>");
			put("Voltaic Shielding","<actions/>");
			put("Vortex Shot","<actions/>");
			put("Warding Shot","<actions/>");
			put("Will of the Force","<actions/>");
			put("Wire Bind","<actions/>");
			put("Wire Line","<actions/>");
			put("Wrack","<actions/>");
		}
		
		
	};

	public static Map<String, String> getActionOverrideMap() {
		return actionOverrideMap;
	}

}
