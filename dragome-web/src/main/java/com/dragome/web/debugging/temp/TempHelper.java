/*******************************************************************************
 * Copyright (c) 2011-2014 Fernando Petrola
 * 
 * This file is part of Dragome SDK.
 * 
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 ******************************************************************************/
package com.dragome.web.debugging.temp;

import com.dragome.commons.javascript.ScriptHelper;

public class TempHelper
{
	public static Object getObjectFromMessage(String aMessage)
	{
		ScriptHelper.put("result", aMessage, null);
		return ScriptHelper.eval("eval(result)", null);
	}
}
