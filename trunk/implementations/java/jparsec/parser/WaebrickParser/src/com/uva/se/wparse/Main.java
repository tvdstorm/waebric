/*
 * File			: Main.java
 * Project		: WaebrickParser
 * 				: Waebrick Parser, practicum opdracht Software Construction
 * 
 * Author		: M. Wullink, L. Vinke, M. v.d. Laar
 * 
 * Description	:
 * 
 * 
 * Change history
 * -----------------------------------------------------------
 * Date			Change				 
 * -----------------------------------------------------------
 * 07-05-2009	Initial version.
 * 
 * 
 */
package com.uva.se.wparse;
import java.io.File;

import javax.swing.SwingUtilities;

import org.apache.log4j.Logger;

import com.uva.se.wparse.input.gui.MainParserFrame;
import com.uva.se.wparse.model.declaration.ModuleDef;
import com.uva.se.wparse.parser.DeclarationParser;
import com.uva.se.wparse.util.FileUtil;


public class Main {
	private static org.apache.log4j.Logger logger = Logger.getLogger(Main.class);

	public static void main(String[] args) {

		if(args.length > 0){
			if(args[0].equals("-i")){
				if(logger.isDebugEnabled()){
					logger.debug("Started in Interactive mode");
				}
				
				SwingUtilities.invokeLater(new Runnable() {
					public void run() {
						MainParserFrame inst = new MainParserFrame();
						inst.setLocationRelativeTo(null);
						inst.setVisible(true);
					}
				});
			}else if ( (args.length == 2) && args[0].equals("-c")){
				if(logger.isDebugEnabled()){
					logger.debug("Started in commandline mode");
				}
				
				File file = new File(args[1]);
				if(logger.isDebugEnabled()){
					logger.debug("Loading filet: " + file.toString());
				}
				try {
					if(file.exists()){
						String source = FileUtil.readFile(file);
						DeclarationParser dp = new DeclarationParser();
						ModuleDef md = dp.parse(source);
						
						if(logger.isDebugEnabled()){
							logger.debug("Parser result: " + md.toString());
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//TODO: Lammert got some stuff to do here :-)
			}else{
				
				//illegal start option provided, handle with error msg
			}
		}

	}
	

	
}
