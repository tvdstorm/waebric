using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Checker.Exceptions
{
    /// <summary>
    /// Class containing NonExistingModuleException
    /// </summary>
    public class NonExistingModule : Exception
    {
        #region Public Methods

        public NonExistingModule(String moduleIdentifier)
        {
            Console.WriteLine("Error: Module " + moduleIdentifier + " not found.");
        }

        #endregion
    }
}
