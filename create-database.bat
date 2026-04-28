@echo off
set "MYSQL=C:\Program Files\MySQL\MySQL Server 8.0\bin\mysql.exe"
if not exist "%MYSQL%" (
  echo MySQL client not found at "%MYSQL%"
  exit /b 1
)

set /p MYSQL_ADMIN_USER=MySQL admin username [root]: 
if "%MYSQL_ADMIN_USER%"=="" set "MYSQL_ADMIN_USER=root"

echo Enter the password for %MYSQL_ADMIN_USER% when MySQL asks.
"%MYSQL%" -u%MYSQL_ADMIN_USER% -p < "%~dp0database-setup.sql"

if errorlevel 1 (
  echo Database setup failed.
  exit /b 1
)

echo Database ic_project_db and user ic_user are ready.
