﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;

namespace Checker.Exceptions
{
    /// <summary>
    /// Exception for Undefined Functions
    /// </summary>
    public class UndefinedFunction : Exception
    {
        #region Public Methods

        public UndefinedFunction(String identifier)
        {
            Console.WriteLine("Function " + identifier + " called but isn't defined");
        }

        #endregion
    }
}
