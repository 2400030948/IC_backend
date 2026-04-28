@echo off
set "ROOT=%~dp0"
if exist "%ROOT%local-env.bat" call "%ROOT%local-env.bat"
if "%DB_USERNAME%"=="" set "DB_USERNAME=ic_user"
if "%DB_PASSWORD%"=="" set "DB_PASSWORD=ic_password"
"%ROOT%.tools\apache-maven-3.9.11\bin\mvn.cmd" spring-boot:run
