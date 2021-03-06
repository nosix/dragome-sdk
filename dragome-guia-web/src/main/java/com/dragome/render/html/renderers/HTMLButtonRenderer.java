/*
 * Copyright (c) 2011-2014 Fernando Petrola
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.dragome.render.html.renderers;

import org.w3c.dom.Element;

import com.dragome.guia.GuiaServiceLocator;
import com.dragome.guia.components.interfaces.VisualButton;
import com.dragome.helpers.DragomeEntityManager;
import com.dragome.render.canvas.interfaces.Canvas;

public class HTMLButtonRenderer extends AbstractHTMLComponentRenderer<VisualButton>
{
	public HTMLButtonRenderer()
	{
	}

	public Canvas<Element> render(final VisualButton visualButton)
	{
		Canvas<Element> canvas= GuiaServiceLocator.getInstance().getTemplateManager().getCanvasFactory().createCanvas();

		canvas.setContent(new MergeableElement()
		{
			public void mergeWith(Element element)
			{
				String id= DragomeEntityManager.add(visualButton);

				//		Element button1= ServiceLocator.getInstance().getDomHandler().getDocument().createElement("input");
				element.setAttribute("type", "button");
				element.setAttribute("value", visualButton.getCaption());

				addListeners(visualButton, element);
			}
		});

		return canvas;
	}

}
