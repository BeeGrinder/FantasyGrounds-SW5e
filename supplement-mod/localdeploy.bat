c:
cd "C:\sw5e-dev\FantasyGrounds-SW5e\supplement-mod\SW5e Supplement"
"C:\Program Files\7-Zip\7z.exe" u -tzip "SW5e Supplement.mod" common.xml definition.xml thumbnail.png
copy /Y "SW5e Supplement.mod" "D:\games\Smiteworks\FGClassic\FGCData\modules\"
move /Y "SW5e Supplement.mod" "D:\games\Smiteworks\FGUData\modules"
