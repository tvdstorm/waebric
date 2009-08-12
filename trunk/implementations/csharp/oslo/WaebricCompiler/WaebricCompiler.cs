using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.M;
using System.Dataflow;
using Checker;
using Common;
using Interpreter;

namespace WaebricCompiler
{
    public class WaebricCompiler
    {
        #region Private Members

        private static String Path; //Path of file to compile

        #endregion

        #region Public Methods

        public static void Main(string[] args)
        {
            Console.WriteLine("Waebric Compiler/Interpreter v1.0");
            Console.WriteLine("--------Builded with Oslo--------");
            Console.WriteLine("");

            if (args.Length == 1)
            {   //There is one file specified. 
                Path = args[0];
            }
            else
            {
                Console.WriteLine("WeabricCompiler: no input file specified.");
                return;
            }

            //Lets parse the file
            WaebricParser parser = new WaebricParser(Path);
            Node rootNode = parser.GetAST();

            //Initialize ModuleCache with correct DirectoryPath
            ModuleCache.Instance.SetDirectoryPath(GetDirectoryPath());

            //Lets check the file
            WaebricChecker checker = new WaebricChecker();
            checker.CheckSyntaxTree(rootNode);

            //Lets interpret the file
            WaebricInterpreter interpreter = new WaebricInterpreter();
            interpreter.InterpretAST(rootNode);

        }

        #endregion

        #region Private Methods

        /// <summary>
        /// Method to retrieve directorypath if there is one
        /// </summary>
        /// <returns></returns>
        private static String GetDirectoryPath()
        {
            //Split current path into seperate elements
            String[] splittedPath = Path.Split(new char[] { '/', '\\' });
            if (splittedPath.Length == 1)
            {   //Only filename specified, no additional directoryPath specified
                return "";
            }
            else
            {   //Return directory
                String directoryPath = "";
                for (int i = 0; i <= (splittedPath.Length - 2); i++)
                {
                    directoryPath += splittedPath[i];
                    directoryPath += "\\";
                }
                return directoryPath;
            }
        }

        #endregion
    }
}
