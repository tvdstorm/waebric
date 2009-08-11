@echo off
::Checking arguments and setting variable to store proper setting
if "%1" == "" set version=Debug
if "%1" == "-debug" set version=Debug
if "%1" == "-release" set version=Release

echo Cleaning up all build directory's...
if "%version%" == "Debug" rd /s /q bin\debug\
if "%version%" == "Release" rd /s /q bin\release\
cd ..\WaebricGrammar
if "%version%" == "Debug" rd /s /q bin\debug\
if "%version%" == "Release" rd /s /q bin\release\
cd ..\Parser
if "%version%" == "Debug" rd /s /q bin\debug\
if "%version%" == "Release" rd /s /q bin\release\
cd ..\Common
if "%version%" == "Debug" rd /s /q bin\debug\
if "%version%" == "Release" rd /s /q bin\release\
cd ..\Checker
if "%version%" == "Debug" rd /s /q bin\debug\
if "%version%" == "Release" rd /s /q bin\release\
:: Add here actions for INTERPRETER!!
cd ..\WaebricCompiler
echo Compiling Grammar...
cd ..\WaebricGrammar
msbuild WaebricGrammar.mproj /p:Configuration=%version%
cd ..\WaebricCompiler
echo Compiling Compiler...
msbuild WaebricCompiler.csproj /p:Configuration=%version%
echo Copying compiled grammar to right location
copy ..\WaebricGrammar\bin\%version%\WaebricGrammar.mx bin\%version%\Waebric.mx