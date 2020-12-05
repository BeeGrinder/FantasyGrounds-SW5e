c:
cd C:\sw5e-dev\FantasyGrounds-SW5e\ext-src
"C:\Program Files\7-Zip\7z.exe" u -tzip "sw5e.ext" extension.xml fonts graphics scripts strings
copy /Y "sw5e.ext" "D:\games\Smiteworks\FGClassic\FGCData\extensions\"
move /Y "sw5e.ext" "D:\games\Smiteworks\FGUData\extensions\"
