rem Google ne permet pas le téléversement de fichiers `.bat` - changer le '.' avec un '-' au besoin
rem    par exemple : launch.bat --> launch-bat 
javac -d bin ^
src/edu/ics4u/objets/MonTableau.java ^
src/edu/ics4u/objets/Vecteurs2D.java ^
src/edu/ics4u/objets/ClassesEtObjets.java

java -cp bin edu.ics4u.objets.ClassesEtObjets