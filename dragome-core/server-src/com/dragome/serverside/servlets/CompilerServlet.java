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
package com.dragome.serverside.servlets;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dragome.serverside.compile.watchers.WatchDir;
import com.dragome.services.ServiceLocator;

//@WebServlet(loadOnStartup= 1, value= "/compiler-service")
public class CompilerServlet extends GetPostServlet
{
	private static Logger LOGGER= Logger.getLogger(CompilerServlet.class.getName());

	protected void doService(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		resp.getWriter().write(WatchDir.lastCompilation + "");
	}

	public void init() throws ServletException
	{
		try
		{
			compile();
		}
		catch (URISyntaxException e)
		{
			throw new RuntimeException(e);
		}
	}

	private void compile() throws URISyntaxException
	{
		final StringBuilder classPath= new StringBuilder();

		ClassLoader c= getClass().getClassLoader();
		URLClassLoader u= (URLClassLoader) c;
		URL[] urls= u.getURLs();
		String classesFolder= "";
		for (URL i : urls)
		{
			String classPathEntry= new File(i.toURI()).toString();
			boolean isClassesFolder= i.toString().endsWith("/classes/") || i.toString().endsWith("/classes");
			boolean addToClasspath= ServiceLocator.getInstance().getConfigurator().filterClassPath(classPathEntry);

			if (isClassesFolder || addToClasspath)
				classPath.append(classPathEntry + ";");

			if (isClassesFolder)
				classesFolder= classPathEntry;

			LOGGER.log(Level.INFO, "classpath entry: " + classPathEntry);
		}

		final String path= new File(new java.io.File(classesFolder).getParentFile().getParentFile().toURI()).toString() + File.separator + "compiled-js";

		LOGGER.log(Level.INFO, "classes: " + path);

		final String classesFolder2= classesFolder;

		new Thread()
		{
			public void run()
			{
				WatchDir.main(new String[] { "-r", classesFolder2 }, classPath.toString(), path);
			}
		}.start();
	}
}
