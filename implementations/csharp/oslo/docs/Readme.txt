Readme Oslo-C# implementation Waebric Parser
--------------------------------------------------

This readme describes which tools you need to build/run the implementation

Requirements for running tests and build code:
----------------------------------------------

- Windows Installer 4.5
- .NET Framework 3.5 SP1
- Visual Studio .NET 2008 (prerequisite for "Oslo")
- SQL Server 2008 Express ("Oslo" prerequisite for repository/quadrant only!) Note: Make sure default instance is selected during install and local user is sql administrator!
- Microsoft "Oslo" May 2009 CTP release (from http://msdn.com/oslo)

Howto build solution:
---------------------
1. Start Visual Studio 2008 Command Prompt from startmenu
2. Navigate to project directory (WaebricCompiler)
3. Run buildall.cmd with -debug or -release parameter for specific build

Remarks:
- Make sure your Windows Computer name is UPPERCASE! Otherwise tests would stay pending.
- Install Oslo on c drive in default folder to make sure project dependency's are ok.