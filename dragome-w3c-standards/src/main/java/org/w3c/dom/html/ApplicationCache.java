// Generated by esidl 0.4.0.

package org.w3c.dom.html;

public interface ApplicationCache
{
    // ApplicationCache
    public static final short UNCACHED = 0;
    public static final short IDLE = 1;
    public static final short CHECKING = 2;
    public static final short DOWNLOADING = 3;
    public static final short UPDATEREADY = 4;
    public static final short OBSOLETE = 5;
    public short getStatus();
    public void update();
    public void swapCache();
    public Function getOnchecking();
    public void setOnchecking(Function onchecking);
    public Function getOnerror();
    public void setOnerror(Function onerror);
    public Function getOnnoupdate();
    public void setOnnoupdate(Function onnoupdate);
    public Function getOndownloading();
    public void setOndownloading(Function ondownloading);
    public Function getOnprogress();
    public void setOnprogress(Function onprogress);
    public Function getOnupdateready();
    public void setOnupdateready(Function onupdateready);
    public Function getOncached();
    public void setOncached(Function oncached);
    public Function getOnobsolete();
    public void setOnobsolete(Function onobsolete);
}
