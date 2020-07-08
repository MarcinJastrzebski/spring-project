call runcrud
if "%ERRORLEVEL%" == "0" goto openbrowser
echo.
echo RUNCRUD has errors - breaking work

:openbrowser
call start chrome http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" != "0" goto stoptomcat

:stoptomcat
call %CATALINA_HOME%\bin\shutdown.bat
echo.
echo RUNCRUD has errors - breaking work