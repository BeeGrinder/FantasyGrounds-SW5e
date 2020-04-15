cd /C/sw5e-dev/FantasyGrounds-SW5e/par5e/output
mv client.xml client_preedit.xml
cat client_preedit.xml |\
 sed 's/<name type="string">Berserker Approach<\/name>/<name type="string">Berserker Approach<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Consular Tradition<\/name>/<name type="string">Consular Tradition<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Engineering Discipline<\/name>/<name type="string">Engineering Discipline<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Fighter Speciality<\/name>/<name type="string">Fighter Speciality<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Guardian Form<\/name>/<name type="string">Guardian Form<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Monastic Order<\/name>/<name type="string">Monastic Order<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Academic Pursuit<\/name>/<name type="string">Academic Pursuit<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Scout Technique<\/name>/<name type="string">Scout Technique<\/name><specializationchoice type="number">1<\/specializationchoice>/g' |\
 sed 's/<name type="string">Sentinel Calling<\/name>/<name type="string">Sentinel Calling<\/name><specializationchoice type="number">1<\/specializationchoice>/g' \
 > client.xml
/c/Program\ Files/7-Zip/7z.exe a "SW5e Player Book.zip" client.xml definition.xml thumbnail.png images tokens
mv "SW5e Player Book.zip" "SW5e Player Book.mod"
mv "SW5e Player Book.mod" /d/games/Smiteworks/FGClassic/FGCData/modules