using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Dataflow;

namespace Checker
{
    /// <summary>
    /// Class containing checker
    /// </summary>
    public class WaebricChecker
    {
        #region Public Methods

        public List<Exception> CheckSyntaxTree(Node tree)
        {
            List<Exception> exceptionList = new List<Exception>();

            //Check modules
            ModuleChecker moduleChecker = new ModuleChecker(exceptionList);
            moduleChecker.CheckModule(tree);

            //Check declarations
            DeclarationChecker declarationChecker = new DeclarationChecker(exceptionList);
            declarationChecker.VisitModule(tree);

            return exceptionList;
        }

        #endregion
    }
}
