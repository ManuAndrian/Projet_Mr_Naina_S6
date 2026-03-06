@echo off
set TARGET_TOMCAT=C:\xampp\tomcat\webapps
set SOURCE_FOLDER=./target

echo --- Deploiement Spring Boot vers Tomcat ---
echo.

:: 1. Verifier si le dossier target existe
if not exist "%SOURCE_FOLDER%" (
    echo [ERREUR] Le dossier /target n'existe pas. 
    echo Assurez-vous d'avoir lance "mvn clean package" d'abord.
    pause
    exit
)

:: 2. Verifier si le dossier webapps de Tomcat existe
if not exist "%TARGET_TOMCAT%" (
    echo [ERREUR] Chemin Tomcat introuvable : %TARGET_TOMCAT%
    pause
    exit
)

:: 3. Copier le fichier .war depuis target vers webapps
echo Recherche du fichier war dans %SOURCE_FOLDER%...
copy "%SOURCE_FOLDER%\*.war" "%TARGET_TOMCAT%\" /Y

if %errorlevel% equ 0 (
    echo.
    echo [SUCCES] Le fichier a ete copie dans webapps !
    echo Verifiez que Tomcat est lance pour deployer.
) else (
    echo.
    echo [ECHEC] La copie a echoue. 
    echo Verifiez si Tomcat utilise deja le fichier ou lancez en Administrateur.
)

echo.
pause