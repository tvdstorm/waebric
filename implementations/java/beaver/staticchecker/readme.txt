Author: Aart van den Dolder
Date: 14-09-2009

This package contains a Waebric static syntax checker.
This program performs a static syntax check on a Waebric parse tree according to paragraph 3 of document http://waebric.googlecode.com/svn/trunk/doc/waebric.pdf
The software has been developed and tested on Windows XP with JDK 1.4, but it should also work on Unix/Linux.

The checker can be activated by running the run.bat (Windows) or the run.sh (Unix/Linux) script. 
In these scripts the name of the file to be checked must be filled in. The result of the check is written in a file: "evaluation.txt".

An overview of the classes used by the checker can be found in "Waebric Static Syntax Checker.jpg"
and "Waebric Static Syntax Checker.jude". The latter can be used for updating the design. The JUDE design tool can be downloaded from http://jude.change-vision.com.

The config.txt file contains information about the runtime environment and must be edited before running
the checker. The following variables can be set:
- waebric_dir:        the location where Waebric source files (imports) can be found
- waebric_extension:  the extension of the Waebric source files (default: wae)
- html_elements_file: the location and name of the document with a list of all HTML elements (default: html-elements.txt in this directory)