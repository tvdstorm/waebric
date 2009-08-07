using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using Microsoft.M;
using System.Dataflow;

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

            //Lets initialize the parser
            
            WaebricParser parser = new WaebricParser(Path);
        }

        #endregion
    }
}
