cd /C/sw5e-dev/FantasyGrounds-SW5e/par5e/output
mv client.xml client_preedit.xml
cat client_preedit.xml |\
 sed 's/<name type="string">Berserker Approach<\/name>/<name type="string">Berserker Approach<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Consular Tradition<\/name>/<name type="string">Consular Tradition<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Engineering Discipline<\/name>/<name type="string">Engineering Discipline<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Fighter Speciality<\/name>/<name type="string">Fighter Speciality<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Operative Practice<\/name>/<name type="string">Operative Practice<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Guardian Form<\/name>/<name type="string">Guardian Form<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Monastic Order<\/name>/<name type="string">Monastic Order<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Academic Pursuit<\/name>/<name type="string">Academic Pursuit<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Scout Technique<\/name>/<name type="string">Scout Technique<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Sentinel Calling<\/name>/<name type="string">Sentinel Calling<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/----FightingMasteryReferenceList----/<link class="referencetext" recordname="reference.refmanualdata.refpage_000001fightingmastery\@SW5e Player Book">Fighting Mastery List<\/link>/g' |\
 sed 's/----LightsaberFormsReferenceList----/<link class="referencetext" recordname="reference.refmanualdata.refpage_000003lightsaberforms\@SW5e Player Book">Saber Form List<\/link>/g' |\
 sed 's/----FightingStyleReferenceList----/<link class="referencetext" recordname="reference.refmanualdata.refpage_000002fightingstyle\@SW5e Player Book">Fighting Style List<\/link>/g' \
 > client.xml
/c/Program\ Files/7-Zip/7z.exe a -mx9 "SW5e Player Book.zip" client.xml definition.xml thumbnail.png images tokens
mv "SW5e Player Book.zip" "SW5e Player Book.mod"
cp -f "SW5e Player Book.mod" "/d/games/Smiteworks/FGUData/modules"
mv "SW5e Player Book.mod" "/d/games/Smiteworks/FGClassic/FGCData/modules"
