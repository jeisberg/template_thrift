@REM ----------------------------------------------------------------------------
@REM Copyright 2001-2004 The Apache Software Foundation.
@REM
@REM Licensed under the Apache License, Version 2.0 (the "License");
@REM you may not use this file except in compliance with the License.
@REM You may obtain a copy of the License at
@REM
@REM      http://www.apache.org/licenses/LICENSE-2.0
@REM
@REM Unless required by applicable law or agreed to in writing, software
@REM distributed under the License is distributed on an "AS IS" BASIS,
@REM WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@REM See the License for the specific language governing permissions and
@REM limitations under the License.
@REM ----------------------------------------------------------------------------
@REM

@echo off

set ERROR_CODE=0

:init
@REM Decide how to startup depending on the version of windows

@REM -- Win98ME
if NOT "%OS%"=="Windows_NT" goto Win9xArg

@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" @setlocal

@REM -- 4NT shell
if "%eval[2+2]" == "4" goto 4NTArgs

@REM -- Regular WinNT shell
set CMD_LINE_ARGS=%*
goto WinNTGetScriptDir

@REM The 4NT Shell from jp software
:4NTArgs
set CMD_LINE_ARGS=%$
goto WinNTGetScriptDir

:Win9xArg
@REM Slurp the command line arguments.  This loop allows for an unlimited number
@REM of arguments (up to the command line limit, anyway).
set CMD_LINE_ARGS=
:Win9xApp
if %1a==a goto Win9xGetScriptDir
set CMD_LINE_ARGS=%CMD_LINE_ARGS% %1
shift
goto Win9xApp

:Win9xGetScriptDir
set SAVEDIR=%CD%
%0\
cd %0\..\.. 
set BASEDIR=%CD%
cd %SAVEDIR%
set SAVE_DIR=
goto repoSetup

:WinNTGetScriptDir
set BASEDIR=%~dp0\..

:repoSetup


if "%JAVACMD%"=="" set JAVACMD=java

if "%REPO%"=="" set REPO=%BASEDIR%\repo

set CLASSPATH="%BASEDIR%"\etc;"%REPO%"\com\lockerz\thrift\commons\1.0-SNAPSHOT\commons-1.0-20110824.183824-1.jar;"%REPO%"\c3p0\c3p0\0.9.1.2\c3p0-0.9.1.2.jar;"%REPO%"\com\googlecode\hibernate-memcached\1.2\hibernate-memcached-1.2.jar;"%REPO%"\spy\memcached\2.3.1\memcached-2.3.1.jar;"%REPO%"\org\slf4j\slf4j-api\1.6.1\slf4j-api-1.6.1.jar;"%REPO%"\org\hibernate\hibernate\3.2.6.ga\hibernate-3.2.6.ga.jar;"%REPO%"\net\sf\ehcache\ehcache\1.2.3\ehcache-1.2.3.jar;"%REPO%"\commons-collections\commons-collections\2.1.1\commons-collections-2.1.1.jar;"%REPO%"\asm\asm-attrs\1.5.3\asm-attrs-1.5.3.jar;"%REPO%"\dom4j\dom4j\1.6.1\dom4j-1.6.1.jar;"%REPO%"\antlr\antlr\2.7.6\antlr-2.7.6.jar;"%REPO%"\cglib\cglib\2.1_3\cglib-2.1_3.jar;"%REPO%"\asm\asm\1.5.3\asm-1.5.3.jar;"%REPO%"\org\springframework\spring-context\3.0.5.RELEASE\spring-context-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-aop\3.0.5.RELEASE\spring-aop-3.0.5.RELEASE.jar;"%REPO%"\aopalliance\aopalliance\1.0\aopalliance-1.0.jar;"%REPO%"\org\springframework\spring-asm\3.0.5.RELEASE\spring-asm-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-beans\3.0.5.RELEASE\spring-beans-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-core\3.0.5.RELEASE\spring-core-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-expression\3.0.5.RELEASE\spring-expression-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-orm\3.0.5.RELEASE\spring-orm-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-jdbc\3.0.5.RELEASE\spring-jdbc-3.0.5.RELEASE.jar;"%REPO%"\org\springframework\spring-tx\3.0.5.RELEASE\spring-tx-3.0.5.RELEASE.jar;"%REPO%"\log4j\log4j\1.2.16\log4j-1.2.16.jar;"%REPO%"\org\slf4j\jcl-over-slf4j\1.6.1\jcl-over-slf4j-1.6.1.jar;"%REPO%"\ch\qos\logback\log4j-bridge\0.9.7\log4j-bridge-0.9.7.jar;"%REPO%"\ch\qos\logback\logback-classic\0.9.27\logback-classic-0.9.27.jar;"%REPO%"\ch\qos\logback\logback-core\0.9.27\logback-core-0.9.27.jar;"%REPO%"\org\apache\thrift\libthrift\0.6.1\libthrift-0.6.1.jar;"%REPO%"\commons-lang\commons-lang\2.5\commons-lang-2.5.jar;"%REPO%"\javax\servlet\servlet-api\2.5\servlet-api-2.5.jar;"%REPO%"\org\apache\httpcomponents\httpclient\4.0.1\httpclient-4.0.1.jar;"%REPO%"\org\apache\httpcomponents\httpcore\4.0.1\httpcore-4.0.1.jar;"%REPO%"\commons-codec\commons-codec\1.3\commons-codec-1.3.jar;"%REPO%"\geronimo-spec\geronimo-spec-jta\1.0.1B-rc4\geronimo-spec-jta-1.0.1B-rc4.jar;"%REPO%"\mysql\mysql-connector-java\5.1.6\mysql-connector-java-5.1.6.jar;"%REPO%"\com\lockerz\thrift\template\1.0-SNAPSHOT\template-1.0-SNAPSHOT.jar
set EXTRA_JVM_ARGUMENTS=-Dcom.sun.management.jmxremote.port=7150 -Dcom.sun.management.jmxremote.authenticate=false -Dcom.sun.management.jmxremote.ssl=false
goto endInit

@REM Reaching here means variables are defined and arguments have been captured
:endInit

%JAVACMD% %JAVA_OPTS% %EXTRA_JVM_ARGUMENTS% -classpath %CLASSPATH_PREFIX%;%CLASSPATH% -Dapp.name="run" -Dapp.repo="%REPO%" -Dbasedir="%BASEDIR%" com.lockerz.thrift.template.server.Server %CMD_LINE_ARGS%
if ERRORLEVEL 1 goto error
goto end

:error
if "%OS%"=="Windows_NT" @endlocal
set ERROR_CODE=1

:end
@REM set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" goto endNT

@REM For old DOS remove the set variables from ENV - we assume they were not set
@REM before we started - at least we don't leave any baggage around
set CMD_LINE_ARGS=
goto postExec

:endNT
@endlocal

:postExec

if "%FORCE_EXIT_ON_ERROR%" == "on" (
  if %ERROR_CODE% NEQ 0 exit %ERROR_CODE%
)

exit /B %ERROR_CODE%
