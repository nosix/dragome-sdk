// Generated by esidl 0.4.0.

package org.w3c.dom.html;

import org.w3c.dom.events.Event;

public interface HashChangeEvent extends Event
{
    // HashChangeEvent
    public String getOldURL();
    public String getNewURL();
    public void initHashChangeEvent(String typeArg, boolean canBubbleArg, boolean cancelableArg, String oldURLArg, String newURLArg);
}
